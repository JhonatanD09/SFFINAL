package models;

import java.util.ArrayList;

public class OrderMotor{
    
	private int id;
	private String workshop;
	private String ownerName;
	private String ownerPhone;
	private String arriveDate;
    private ArrayList<String> engineParts;
    private String state;
    private ArrayList<Jobs> jobsList;
    
	
	public OrderMotor(String workshop, String ownerName, String ownerPhone, String arriveDate,
			ArrayList<String> engineParts, ArrayList<Jobs> jobsList) {
		this.workshop = workshop;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.arriveDate = arriveDate;
		this.engineParts = engineParts;
		this.state = "Recibido";
		this.jobsList = jobsList;
		id= 0;
	}

    public OrderMotor(){

    }

    public void setId(int id) {
		this.id = id;
	}

	public String getWorkshop() {
		return workshop;
	}

	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	
	public String getArriveDate() {
		return arriveDate;
	}

	public void setarriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public ArrayList<String> getEngineParts() {
		return engineParts;
	}

	public void setEngineParts(ArrayList<String> engineParts) {
		this.engineParts = engineParts;
	}

	public String getState() {
		return state;
	}

    public void addJob(Jobs job){
        jobsList.add(job);
    }

	public void addComponent(String component) {
		engineParts.add(component);
	}

	public int getId() {
		return id;
	}
	
	public void deleteComponent(String component) {
//		String[] temp = new String[engineParts.length-1];
//		for (int i = 0, j = 0 ; i < engineParts.length; i++) {
//			if(engineParts[i].compareTo(component)!=0) {
//				temp[j] = engineParts[i];
//				j++;
//			}
//		}
//		engineParts = temp;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<Jobs> getJobsList() {
		return jobsList;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}