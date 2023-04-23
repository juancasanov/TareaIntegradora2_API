package model;

import java.util.Calendar;

public class Project {

    private String proyectName;
    private String clientName;
    private Calendar startDate;
    private Calendar endDate;
    private double budget;
    private String greenManagerName;
    private String greenManagerPhoneNumber;
    private String clientManagerName;
    private String clientManagerPhoneNumber;
    private Stage[] stages;

    public Project(String proyectName, String clientName, Calendar startDate, Calendar endDate, double budget, String greenManagerName, String greenManagerPhoneNumber, String clientManagerName, String clientManagerPhoneNumber, Stage[] stages) {
       
        this.proyectName = proyectName;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.greenManagerName = greenManagerName;
        this.greenManagerPhoneNumber = greenManagerPhoneNumber;
        this.clientManagerName = clientManagerName;
        this.clientManagerPhoneNumber = clientManagerPhoneNumber;
        this.stages = stages;

    }

    public String getProyectName() {

        return proyectName;

    }

    public void setProyectName(String proyectName) {

        this.proyectName = proyectName;

    }

    public String getClientName() {

        return clientName;

    }

    public void setClientName(String clientName) {

        this.clientName = clientName;

    }

    public Calendar getStartDate() {

        return startDate;

    }

    public void setStartDate(Calendar startDate) {

        this.startDate = startDate;

    }

    public Calendar getEndDate() {
        
        return endDate;

    }

    public void setEndDate(Calendar endDate) {

        this.endDate = endDate;
        
    }

    public double getBudget() {

        return budget;

    }

    public void setBudget(double budget) {

        this.budget = budget;

    }

    public String getGreenManagerName() {

        return greenManagerName;

    }

    public void setGreenManagerName(String greenManagerName) {

        this.greenManagerName = greenManagerName;

    }

    public String getGreenManagerPhoneNumber() {

        return greenManagerPhoneNumber;

    }

    public void setGreenManagerPhoneNumber(String greenManagerPhoneNumber) {

        this.greenManagerPhoneNumber = greenManagerPhoneNumber;

    }

    public String getClientManagerName() {

        return clientManagerName;

    }

    public void setClientManagerName(String clientManagerName) {

        this.clientManagerName = clientManagerName;

    }

    public String getClientManagerPhoneNumber() {

        return clientManagerPhoneNumber;

    }

    public void setClientManagerPhoneNumber(String clientManagerPhoneNumber) {

        this.clientManagerPhoneNumber = clientManagerPhoneNumber;

    }

    public Stage[] getStages() {

        return stages;

    }

    public void setStages(Stage[] stages) {
        
        this.stages = stages;

    }
    
}
