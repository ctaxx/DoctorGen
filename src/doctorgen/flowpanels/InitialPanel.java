package doctorgen.flowpanels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class InitialPanel extends FlowPanel {
	TextField nameTextField, projectTextField, quantityTextField;
	DefaultTableModel tableModel;
	JTable serialsTable;
	Object[][] serialsArray;
	int quantity = 1;
	JSpinner quantitySpinner;

	public InitialPanel() {
		super();
		panelName = "initialPanel";

		setLayout(new BorderLayout());
		Panel northPanel = new Panel();
		northPanel.setLayout(new FlowLayout());

		Panel namePanel = new Panel();
		namePanel.setLayout(new FlowLayout());
		Label nameLabel = new Label("name");
		namePanel.add(nameLabel);
		nameTextField = new TextField(20);
		namePanel.add(nameTextField);
		northPanel.add(namePanel);

		Panel projectPanel = new Panel();
		projectPanel.setLayout(new FlowLayout());
		Label projectLabel = new Label("project");
		projectPanel.add(projectLabel);
		projectTextField = new TextField(20);
		projectPanel.add(projectTextField);
		northPanel.add(projectPanel);

		Panel quantityPanel = new Panel();
		quantityPanel.setLayout(new FlowLayout());
		Label quantityLabel = new Label("quantity");
		quantityPanel.add(quantityLabel);
		
		SpinnerModel numberSpinnerModel = new SpinnerNumberModel(1, 1, 8, 1);
		quantitySpinner = new JSpinner(numberSpinnerModel);
		quantitySpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				int chosenQuantity = (Integer) quantitySpinner.getValue();
				while (chosenQuantity > quantity) {
					Object[] obj = { Integer.toString(++quantity), "" };
					tableModel.addRow(obj);
				}
				while (chosenQuantity < quantity) {
					tableModel.removeRow(--quantity);
				}
			}
		});
		quantityPanel.add(quantitySpinner);
		northPanel.add(quantityPanel);
		add(northPanel, BorderLayout.NORTH);

		String[] colNames = { "number", "serial" };
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colNames);
		quantity = (Integer)quantitySpinner.getValue();
		Object[] tmpObj = { "1", "" };
		tableModel.addRow(tmpObj);

		serialsTable = new JTable(tableModel) {
			public boolean getScrollableTracksViewportWidth() {
				return getPreferredSize().width < getParent().getWidth();
			}
		};
		serialsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// TableColumnModel tableColumnModel = serialsTable.getColumnModel();
		// tableColumnModel.getColumn(0).setWidth(10);
		// tableColumnModel.getColumn(1).setWidth(50);

		add(new JScrollPane(serialsTable), BorderLayout.CENTER);
	}

	@Override
	public void getData(JsonObject json) {
		json.addProperty("name", nameTextField.getText());
		json.addProperty("project", projectTextField.getText());
		json.addProperty("quantity", quantity);

		JsonArray serialsJson = new JsonArray();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			JsonObject tmpJson = new JsonObject();
			tmpJson.addProperty("number", tableModel.getValueAt(i, 0)
					.toString());
			tmpJson.addProperty("serial", tableModel.getValueAt(i, 1)
					.toString());
			serialsJson.add(tmpJson);
		}
		json.add("serials", serialsJson);
	}
}
