package doctorgen;

import java.util.ArrayList;

public class DocumentData {
	private String deviceName;
	private String project;
//	private String goal;
	private byte quantity;
	private ArrayList <String> serials;
	private ArrayList <String> tests;
	
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public byte getQuantity() {
		return quantity;
	}
	public void setQuantity(byte quantity) {
		this.quantity = quantity;
	}
	public ArrayList <String> getSerials() {
		return serials;
	}
	public void setSerials(ArrayList <String> serials) {
		this.serials = serials;
	}
	public ArrayList <String> getTests() {
		return tests;
	}
	public void setTests(ArrayList <String> tests) {
		this.tests = tests;
	}
}
