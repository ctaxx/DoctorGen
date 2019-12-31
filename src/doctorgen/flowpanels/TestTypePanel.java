package doctorgen.flowpanels;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import doctorgen.provider.TestTypeProvider;

public class TestTypePanel extends FlowPanel {

	Object[][] testsArray;
	DefaultTableModel tableModel;

	public TestTypePanel() {
		super();
		setLayout(new BorderLayout());
		panelName = "testTypePanel";
		Label typeLabel = new Label("type of tests");
		add(typeLabel, BorderLayout.NORTH);

		String[] colNames = { "test", "enabled" };
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colNames);

		TestTypeProvider testTypeProvider = new TestTypeProvider();
		testsArray = testTypeProvider.getStuff();

		for (int i = 0; i < testsArray.length; i++) {
			tableModel.addRow(testsArray[i]);
		}

		JTable testTable = new JTable(tableModel);

		testTable.getColumnModel().getColumn(1)
				.setCellEditor(testTable.getDefaultEditor(Boolean.class));
		testTable.getColumnModel().getColumn(1)
				.setCellRenderer(testTable.getDefaultRenderer(Boolean.class));

		add(new JScrollPane(testTable), BorderLayout.CENTER);
	}

	@Override
	public void getData(JsonObject json) {
		JsonArray testsJson = new JsonArray();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			JsonObject tmpJson = new JsonObject();
			tmpJson.addProperty("test", tableModel.getValueAt(i, 0).toString());
			tmpJson.addProperty("enabled", tableModel.getValueAt(i, 1)
					.toString());
			testsJson.add(tmpJson);
		}
		json.add("tests", testsJson);
	}
}
