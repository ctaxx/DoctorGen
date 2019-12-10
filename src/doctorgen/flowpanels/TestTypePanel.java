package doctorgen.flowpanels;

import java.awt.Label;

public class TestTypePanel extends FlowPanel {
	public TestTypePanel(){
		super();
		panelName = "testTypePanel";
		Label typeLabel = new Label("type of tests");
		add(typeLabel);
	}
}
