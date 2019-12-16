package doctorgen.flowpanels;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import doctorgen.provider.TestTypeProvider;

public class TestTypePanel extends FlowPanel {

	Object[][] testsArray;

	public TestTypePanel() {
		super();
		setLayout(new BorderLayout());
		panelName = "testTypePanel";
		Label typeLabel = new Label("type of tests");
		add(typeLabel, BorderLayout.NORTH);

		String[] colNames = { "test", "enabled" };
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colNames);

		TestTypeProvider testTypeProvider = new TestTypeProvider();
		testsArray = testTypeProvider.getStuff();

		for (int i = 0; i < testsArray.length; i++) {
			tableModel.addRow(testsArray[i]);
		}

		JTable testTable = new JTable(tableModel);

//		JCheckBox check = new JCheckBox();
//		DefaultCellEditor editor = new DefaultCellEditor(check);
//		testTable.getColumnModel().getColumn(1).setCellEditor(editor);
		
		testTable.getColumnModel().getColumn(1).setCellEditor(testTable.getDefaultEditor(Boolean.class));
		testTable.getColumnModel().getColumn(1).setCellRenderer(testTable.getDefaultRenderer(Boolean.class));

		add(new JScrollPane(testTable), BorderLayout.CENTER);
	}
}
