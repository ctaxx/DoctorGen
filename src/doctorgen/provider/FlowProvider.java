package doctorgen.provider;

import java.awt.Panel;
import java.util.ArrayList;

import doctorgen.flowpanels.FlowPanel;
import doctorgen.flowpanels.InitialPanel;
import doctorgen.flowpanels.TestTypePanel;

public class FlowProvider extends AbstractProvider{
	
	public ArrayList <FlowPanel> getStuff(){
		ArrayList <FlowPanel> stuff = new ArrayList<FlowPanel>();
		stuff.add(new InitialPanel());
		stuff.add(new TestTypePanel());
		
		return stuff;
	}
}
