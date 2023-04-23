package model;

import java.util.Calendar;

public class Stage {

    private StageName name;
    private Calendar planedStartDate;
    private Calendar planedEndDate;
    private Calendar startDate;
    private Calendar endDate;
    private StageStatus status;
    private KnowledgeUnit[] knowledgeUnit;

    public Stage(StageName name, Calendar planedStartDate, Calendar planedEndDate, Calendar startDate, Calendar endDate, StageStatus status) {

        this.name = name;
        this.planedStartDate = planedStartDate;
        this.planedEndDate = planedEndDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.knowledgeUnit = new KnowledgeUnit[50];
    }

    public StageName getName() {

        return name;
    }

    public void setName(StageName name) {

        this.name = name;
    }

    public Calendar getPlanedStartDate() {

        return planedStartDate;
    }

    public void setPlanedStartDate(Calendar planedStartDate) {

        this.planedStartDate = planedStartDate;
    }

    public Calendar getPlanedEndDate() {

        return planedEndDate;
    }

    public void setPlanedEndDate(Calendar planedEndDate) {

        this.planedEndDate = planedEndDate;
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

    public StageStatus getStatus() {

        return status;
    }

    public void setStatus(StageStatus status) {

        this.status = status;
    }

    public KnowledgeUnit[] getKnowledgeUnit() {

        return knowledgeUnit;
    }

    public void setKnowledgeUnit(KnowledgeUnit[] knowledgeUnit) {
        
        this.knowledgeUnit = knowledgeUnit;
    }

}
