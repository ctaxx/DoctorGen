package doctorgen.flowpanels;

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
import javax.swing.table.TableModel;

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

		Panel namePanel = new Panel();
		namePanel.setLayout(new FlowLayout());
		Label nameLabel = new Label("name");
		namePanel.add(nameLabel);
		nameTextField = new TextField(20);
		namePanel.add(nameTextField);
		add(namePanel);

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
		add(quantityPanel);

		Panel tablePanel = new Panel();

		String[] colNames = { "number", "serial" };
		// Object [][] data = {{"A bugs life", "G"},
		// {"Civil Action", "PG13"}};
		// JTable table = new JTable(data, colNames);
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(colNames);
		quantity = Integer.parseInt(quantityChoice.getSelectedItem());
		serialsArray = createSerialsArray(quantity);
		for (int i = 0; i < serialsArray.length; i++) {
			tableModel.addRow(serialsArray[i]);
		}
		serialsTable = new JTable(tableModel);

		tablePanel.add(new JScrollPane(serialsTable));
		add(tablePanel);

	}

	private Object[][] createSerialsArray(int quantity) {
		Object[][] objArray = new Object[quantity][2];

		for (int i = 0; i < quantity; i++) {
			objArray[i][0] = Integer.toString(i + 1);
			objArray[i][1] = "";
		}
		return objArray;
	}
}
