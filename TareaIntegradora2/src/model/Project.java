package model;

public class Project {

    private String proyectName;
    private String clientName;
    private String startDate;
    private String endDate;
    private double budget;
    private Stage[] stages;

    public Project(String proyectName, String clientName, String startDate, String endDate, double budget, Stage[] stages) {
       
        this.proyectName = proyectName;
        this.clientName = clientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.stages = new Stage[5];
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

    public String getStartDate() {

        return startDate;

    }

    public void setStartDate(String startDate) {

        this.startDate = startDate;

    }

    public String getEndDate() {

        return endDate;

    }

    public void setEndDate(String endDate) {

        this.endDate = endDate;

    }

    public double getBudget() {

        return budget;

    }

    public void setBudget(double budget) {

        this.budget = budget;
        
    }
    
}
