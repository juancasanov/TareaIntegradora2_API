package model;

public class Stage {

    private StageName name;
    private String planedStartDate;
    private String planedEndDate;
    private String startDate;
    private String endDate;
    private StageStatus status;

    public Stage(StageName name, String planedStartDate, String planedEndDate, String startDate, String endDate, StageStatus status) {

        this.name = name;
        this.planedStartDate = planedStartDate;
        this.planedEndDate = planedEndDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        
    }

    public StageName getName() {
        return name;
    }

    public void setName(StageName name) {
        this.name = name;
    }

    public String getPlanedStartDate() {
        return planedStartDate;
    }

    public void setPlanedStartDate(String planedStartDate) {
        this.planedStartDate = planedStartDate;
    }

    public String getPlanedEndDate() {
        return planedEndDate;
    }

    public void setPlanedEndDate(String planedEndDate) {
        this.planedEndDate = planedEndDate;
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

    public StageStatus getStatus() {
        return status;
    }

    public void setStatus(StageStatus status) {
        this.status = status;
    }
    
}
