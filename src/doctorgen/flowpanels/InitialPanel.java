package doctorgen.flowpanels;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class InitialPanel extends FlowPanel {
	TextField nameTextField, projectTextField, quantityTextField;
	DefaultTableModel tableModel;
	JTable serialsTable;
	Object[][] serialsArray;
	int quantity = 1;

	Choice quantityChoice;

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
		quantityChoice = new Choice();
		quantityChoice.add("1");
		quantityChoice.add("2");
		quantityChoice.add("3");
		quantityChoice.add("4");
		quantityChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int chosenQuantity = Integer.parseInt(quantityChoice
						.getSelectedItem());
				while (chosenQuantity > quantity) {
					Object[] obj = { Integer.toString(++quantity), "" };
					tableModel.addRow(obj);
				}
				while (chosenQuantity < quantity) {
					tableModel.removeRow(--quantity);
				}
			}
		});
		quantityPanel.add(quantityChoice);
		northPanel.add(quantityPanel);
		add(northPanel, BorderLayout.NORTH);

//		Panel tablePanel = new Panel();

		String[] colNames = { "number", "serial" };
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colNames);
		quantity = Integer.parseInt(quantityChoice.getSelectedItem());
		Object [] tmpObj = {"1",""};
		tableModel.addRow(tmpObj);

		serialsTable = new JTable(tableModel){
			public boolean getScrollableTracksViewportWidth(){
				return getPreferredSize().width < getParent().getWidth();
			}
		};
		serialsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//		TableColumnModel tableColumnModel = serialsTable.getColumnModel();
//		tableColumnModel.getColumn(0).setWidth(10);
//		tableColumnModel.getColumn(1).setWidth(50);

		add(new JScrollPane(serialsTable), BorderLayout.CENTER);
	}

	
	public void getData(JsonObject json){
		json.addProperty("name", nameTextField.getText());
		json.addProperty("project", projectTextField.getText());
		json.addProperty("quantity", quantity);
		
		JsonArray serialsJson = new JsonArray();
		for (int i=0; i< tableModel.getRowCount(); i++){
			JsonObject tmpJson = new JsonObject();
			tmpJson.addProperty("number", tableModel.getValueAt(i, 0).toString());
			tmpJson.addProperty("serial", tableModel.getValueAt(i, 1).toString());
			serialsJson.add(tmpJson);
		}
		json.add("serials", serialsJson);
	}
}
