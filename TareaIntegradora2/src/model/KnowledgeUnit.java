package model;

import java.util.Calendar;

public class KnowledgeUnit {

	private String id;
	private String description;
	private KnowledgeUnitType type;
	private String collaboratorName;
	private String collaboratorCharge;
	private String learnedLessons;
	private String url;
	private KnowledgeUnitApproval approval;
	private Calendar approvalDate;

	public KnowledgeUnit(String id, String description, KnowledgeUnitType type, String collaboratorName, String collaboratorCharge, String learnedLessons) {
		
		this.id = id;
		this.description = description;
		this.type = type;
		this.collaboratorName = collaboratorName;
		this.collaboratorCharge = collaboratorCharge;
		this.learnedLessons = learnedLessons;
		this.url = "";
		this.approval = KnowledgeUnitApproval.TO_DEFINE;
	}

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public KnowledgeUnitType getType() {

		return type;
	}

	public void setType(KnowledgeUnitType type) {

		this.type = type;
	}

	public String getCollaboratorName() {

		return collaboratorName;
	}

	public void setCollaboratorName(String collaboratorName) {

		this.collaboratorName = collaboratorName;
	}

	public String getCollaboratorCharge() {

		return collaboratorCharge;
	}

	public void setCollaboratorCharge(String collaboratorCharge) {

		this.collaboratorCharge = collaboratorCharge;
	}

	public String getLearnedLessons() {

		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {

		this.learnedLessons = learnedLessons;
	}

	public String getUrl() {

		return url;
	}

	public void setUrl(String url) {

		this.url = url;
	}

	public KnowledgeUnitApproval getApproval() {

		return approval;
	}

	public void setApproval(KnowledgeUnitApproval approval) {

		this.approval = approval;
	}

	public Calendar getApprovalDate() {

		return approvalDate;
	}

	public void setApprovalDate(Calendar approvalDate) {

		this.approvalDate = approvalDate;
	}

	public String toString() {

		String msg = "";

		msg = "Id: " + id + "\nDescription: " + description + "\nType: " + type + "\nLearned lessons: " + learnedLessons;

		return msg;

	}
}