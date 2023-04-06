package model;

public class Controller {

	private KnowledgeUnit[] units;
	private Project[] projects;
	private Stage[] stages;
	

	public Controller() {

		units = new KnowledgeUnit[24];
		projects = new Project[9];
		stages = new Stage[5];

	}

	public boolean createProyect(String proyectName, String clientName, String plannedStartDate, String plannedEndDate, double budget) {

		stages[0] = new Stage(StageName.START, "xx", "xx", "xx", "xx", StageStatus.ACTIVE);
		stages[1] = new Stage(StageName.ANALISYS, "xx", "xx", "xx", "xx", StageStatus.INACTIVE);
		stages[2] = new Stage(StageName.DESIGN, "xx", "xx", "xx", "xx", StageStatus.INACTIVE);
		stages[3] = new Stage(StageName.EJECUTION, "xx", "xx", "xx", "xx", StageStatus.INACTIVE);
		stages[4] = new Stage(StageName.END, "xx", "xx", "xx", "xx", StageStatus.INACTIVE);
		stages[5] = new Stage(StageName.CONTROL, "xx", "xx", "xx", "xx", StageStatus.INACTIVE);

		Project newProyect = new Project(proyectName, clientName, plannedStartDate, plannedEndDate, budget, stages);

		for (int i = 0; i < projects.length; i++ ) {
 
			if (projects[i] == null) {

				projects[i] = newProyect;

				return true;

			}

		}

		return false;

	}

	/**
	* Description: The registerKnowledgeUnit method will allow to register a knowledge unit with all its attributes.
	* @param id String is the knowledge unit identification.
	* @param description String is a short description of the knowledge unit. 
	* @param type String is the knowledge units type (thecnical or experiences).
	* @param learnedLessons String is the learned lesson. 
	* @return true boolean.
	*/

	public boolean registerKnowledgeUnit(String id, String description, int type, String learnedLessons) {

		KnowledgeUnitType selectedType = KnowledgeUnitType.DEFAULT;

		if (type == 1) {

			selectedType = KnowledgeUnitType.TECHNICAL;

		} else if (type == 2) {

			selectedType = KnowledgeUnitType.DOMAIN;

		} else if (type == 3) {

			selectedType = KnowledgeUnitType.EXPERIENCES;

		}

		KnowledgeUnit newKnowledgeUnit = new KnowledgeUnit(id, description, selectedType, learnedLessons);

		for (int i = 0; i < units.length; i++) {

            if (units[i] == null) {

            	units[i] = newKnowledgeUnit;

                return true;

            }

        }

		return false;

	}

	/**
	* Description: The toApproveKnowledgeUnit method will allow recolect the id and the status of each knowlege unit and create a message.
	* @return msg String is the knowledge units list.
	*/

	public String toApproveKnowledgeUnit() {

		String msg = "";

		if (units[0].equals("")) {

			msg = "There is no knowledge unit to approve";

		} else {

			msg = "The knowledge unit list is the following:";

			for (int i = 0; i < units.length; i++) {

				if (units[i] != null) {
	
					msg += "\n" + (i + 1) + "." + units[i].getId() + "(current status: " + units[i].getStatus() + ")";
	
				}
	
			}
	
		}
        
        return msg;

	}

	/**
	* Description: The approveKnowledgeUnit method will allow change the status of a knowledge unit.
	* @param position int is the position of the knowlege unit which status will be change.
	* @return void
	*/

	public void approveKnowledgeUnit(int position) {

		KnowledgeUnit app = units[position - 1];
		String status = app.getStatus();

		status = "Approved";

		app.setStatus(status);

	}

	/**
	* Description: The getAllknowledgeUnits method will allow to show all attributes of each knowledge unit.
	* @return msg String.
	*/

	public String getAllKnowledgeUnits() {

		String msg = "";

		for (int i = 0; i < units.length; i++) {

            if (units[i] != null) {

                msg += (i + 1) + "." + units[i].toString() + "\n";

            }

        }

		return msg;

	}

}
