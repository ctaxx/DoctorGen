package doctorgen.flowpanels;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestTypePanel extends FlowPanel {
	public TestTypePanel(){
		super();
		setLayout(new BorderLayout());
		panelName = "testTypePanel";
		Label typeLabel = new Label("type of tests");
		add(typeLabel,BorderLayout.NORTH);
		
		String [] colNames = {"test", "enabled"};
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colNames);
		
		Object[] tmp = {"test", false};
		tableModel.addRow(tmp);
		
		
		JTable testTable = new JTable(tableModel);
		
		JCheckBox check = new JCheckBox();
		DefaultCellEditor editor = new DefaultCellEditor(check);
		testTable.getColumnModel().getColumn(1).setCellEditor(editor);
		
		add(new JScrollPane(testTable), BorderLayout.CENTER);
	}
}
