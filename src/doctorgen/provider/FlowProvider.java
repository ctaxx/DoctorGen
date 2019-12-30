package doctorgen.provider;

import java.util.ArrayList;

import doctorgen.flowpanels.FlowPanel;
import doctorgen.flowpanels.InitialPanel;
import doctorgen.flowpanels.TestTypePanel;

public class FlowProvider extends AbstractProvider{
	
	private ArrayList <FlowPanel> stuff;
	
	public ArrayList<FlowPanel> getStuff() {
		return stuff;
	}

	public FlowProvider(){
		stuff = new ArrayList<FlowPanel>();
		stuff.add(new InitialPanel());
		stuff.add(new TestTypePanel());
	}
	
}
