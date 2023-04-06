package model;

public class KnowledgeUnit {

	private String id;
	private String description;
	private KnowledgeUnitType type;
	private String learnedLessons;
	private String status;

	public KnowledgeUnit(String id, String description, KnowledgeUnitType type, String learnedLessons) {

		this.id = id;
		this.description = description;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.status = "to define";

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

	public String getLearnedLessons() {

		return learnedLessons;

	}

	public void setLearnedLessons(String learnedLessons) {

		this.learnedLessons = learnedLessons;

	}
	
	public String getStatus() {

		return status;

	}

	public void setStatus(String status) {

		this.status = status;

	}

	public String toString() {

		String msg = "";

		msg = "Id: " + id + "\nDescription: " + description + "\nType: " + type + "\nLearned lessons: " + learnedLessons + "\nStatus: " + status;

		return msg;

	}

}