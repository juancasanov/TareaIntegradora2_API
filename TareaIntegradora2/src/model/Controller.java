package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private KnowledgeUnit[] units;
	private Project[] projects;
	private Stage[] stages;

	public Controller() {

		units = new KnowledgeUnit[50];
		projects = new Project[10];
		stages = new Stage[6];
	}

	/**
	 * Description: String createProject Method allow to register a project. 
	 * @param proyectName String is the project name.
	 * @param clientName String is the client name.
	 * @param startDay int is the day of the planned start date.
	 * @param startMonth int is the month of the planned start date.
	 * @param startYear int is the year of the planned start date. 
	 * @param endDay int is the day of the planned end date. 
	 * @param endMonth int is the month of the planned end date. 
	 * @param endYear int is the year of the planned end year. 
	 * @param budget double is the projects budget. 
	 * @param greenManagerName String is the name of the GreenSQA project manager. 
	 * @param greenManagerPhoneNumber String is the phone number of the GreenSQA project manager.
	 * @param clintManagerName String is the name if the client project manager. 
	 * @param clientManagerPhoneNumber String is the phone number of the GreenSQA project manager. 
	 * @param stageTime int is the array that contains the number of months each stage will take. 
	 * @return bolean true if the project is registered correctly. 
	 */
	public boolean createProyect(String proyectName, String clientName, int startDay, int startMonth, int startYear, int endDay, int endMonth, int endYear, double budget, String greenManagerName, String greenManagerPhoneNumber, String clintManagerName, String clientManagerPhoneNumber, int[] stageTime) {

		Calendar plannedDate0 = new GregorianCalendar(startYear, startMonth - 1, startDay);
		
		Calendar plannedDate1 = plannedDate0;
		plannedDate1.add(Calendar.MONTH, stageTime[0]);

		Calendar plannedDate2 = plannedDate1; 
		plannedDate2.add(Calendar.MONTH, stageTime[1]);

		Calendar plannedDate3 = plannedDate2; 
		plannedDate3.add(Calendar.MONTH, stageTime[2]);

		Calendar plannedDate4 = plannedDate3; 
		plannedDate4.add(Calendar.MONTH, stageTime[3]);

		Calendar plannedDate5 = plannedDate4; 
		plannedDate5.add(Calendar.MONTH, stageTime[4]);

		Calendar plannedDate6 = plannedDate5; 
		plannedDate6.add(Calendar.MONTH, stageTime[5]);

		stages[0] = new Stage(StageName.START, plannedDate0 , plannedDate1, plannedDate0, null, StageStatus.ACTIVE);
		stages[1] = new Stage(StageName.ANALISYS, plannedDate1, plannedDate2, null, null, StageStatus.INACTIVE);
		stages[2] = new Stage(StageName.DESIGN, plannedDate2, plannedDate3, null, null, StageStatus.INACTIVE);
		stages[3] = new Stage(StageName.EJECUTION, plannedDate3, plannedDate4, null, null, StageStatus.INACTIVE);
		stages[4] = new Stage(StageName.END, plannedDate4, plannedDate5, null, null, StageStatus.INACTIVE);
		stages[5] = new Stage(StageName.CONTROL, plannedDate5, plannedDate6, null, null, StageStatus.INACTIVE);

		Project newProyect = new Project(proyectName, clientName, plannedDate0, plannedDate6, budget, clientManagerPhoneNumber, clientManagerPhoneNumber, clientManagerPhoneNumber, clientManagerPhoneNumber, stages);

		for (int i = 0; i < projects.length; i++ ) {
 
			if (projects[i] == null) {

				projects[i] = newProyect;

				return true;
			}
		}

		return false; 
	}

	/**
	 * Description: String showAllProjects shows all the project registered. 
	 * @return msg String is the list of projects registered. 
	 */
	public String showAllProjects() {

		String msg = "Projects registered:";

		for (int i = 0; i < projects.length; i++) {

			if (projects[i] != null) {

				msg += "\n" + (i + 1) + ") " + projects[i].getProyectName();
			}
		}

		return msg;
	}

	/**
	 * Description: boolean setStageAsComplete allows to register the culmination of a project stage. 
	 * @param project int is the project position in the projecs array.
	 * @param stage int is the stage position in the stages array.
	 * @return true if the culmination was correctly registered. 
	 */
	public boolean setStageAsComplete(int project, int stage) {

		Calendar approvalDate = Calendar.getInstance();

		projects[project-1].getStages()[stage-1].setStatus(StageStatus.INACTIVE);
		projects[project-1].getStages()[stage-1].setEndDate(approvalDate);

		if (stage != 6) {

			projects[project-1].getStages()[stage].setStatus(StageStatus.ACTIVE);
			projects[project-1].getStages()[stage].setStartDate(approvalDate);
		}

		return true;
	}

	/**
	 * Description: String showAllStages shows all the stages of a project. 
	 * @param projectSelected int is the project position in projects array. 
	 * @return msg String is the stages list. 
	 */
	public String showAllStages(int projectSelected) {

		String msg = "Stages list:";
		Stage[] stagesFor = new Stage[6];

		if (projects[projectSelected - 1] != null) {

			stagesFor = projects[projectSelected - 1].getStages();

			for (int s = 0; s < stagesFor.length; s++) {

				msg += "\n" + (s + 1) + ") " + stagesFor[s].getName() + ": " + stagesFor[s].getStatus();
			}
		} else {

			msg = "Number outside bounds";
		}

		return msg;
	}

	/**
	* Description: The registerKnowledgeUnit method will allow to register a knowledge unit with all its attributes.
	* @param selectedProject int is the project position in the project array.
	* @param selectedStage int is the stage position in the stage array.
	* @param id String is the knowledge unit identification.
	* @param description String is a short description of the knowledge unit. 
	* @param type String is the knowledge units type (thecnical or experiences).
	* @param collaboratorName String is the collaborator name.
	* @param collaboratorCharge String is the collaborator charge.
	* @param learnedLessons String is the learned lesson. 
	* @return true boolean.
	*/

	public boolean registerKnowledgeUnit(int selectedProject, int selectedStage, String id, String description, int type, String collaboratorName, String collaboratorCharge, String learnedLessons) {

		KnowledgeUnitType selectedType = KnowledgeUnitType.DEFAULT;

		if (type == 1) {

			selectedType = KnowledgeUnitType.TECHNICAL;

		} else if (type == 2) {

			selectedType = KnowledgeUnitType.MANAGEMENT;

		} else if (type == 3) {

			selectedType = KnowledgeUnitType.DOMAIN;
		} else if (type == 4) {

			selectedType = KnowledgeUnitType.EXPERIENCES;
		}
		KnowledgeUnit[] knowledgeUnits = new KnowledgeUnit[50];
		knowledgeUnits = projects[selectedProject - 1].getStages()[selectedStage - 1].getKnowledgeUnit();
		KnowledgeUnit newKnowledgeUnit = new KnowledgeUnit(id, description, selectedType, collaboratorName, collaboratorCharge, learnedLessons);

		for (int i = 0; i < knowledgeUnits.length; i++) {

            if (knowledgeUnits[i] == null) {

            	knowledgeUnits[i] = newKnowledgeUnit;

                return true;
            }
        }

		projects[selectedProject-1].getStages()[selectedStage-1].setKnowledgeUnit(knowledgeUnits);

		return false;
	}

	/**
	 * Description: boolean approveKnowledgeUnit allows to register the knowlegde unit approval. 
	 * @param projectSelected int is the project position in the projects array. 
	 * @param stageSelected int is the stage position in the stages array. 
	 * @param knowledgeUnitSelected int id the knoeledge unit position int the units array. 
	 * @param approvalElection int is the seleccion between approved or disapproved. 
	 * @return bolean true if the methos was correctly executated. 
	 */
	public boolean approveKnowledgeUnit(int projectSelected, int stageSelected, int knowledgeUnitSelected, int approvalElection) {

		Calendar approvalDate = Calendar.getInstance();

		KnowledgeUnitApproval approval = KnowledgeUnitApproval.TO_DEFINE;

		switch (approvalElection) {
			case 1: 
				approval = KnowledgeUnitApproval.APPROVED;
			break; 

			case 2: 
				approval = KnowledgeUnitApproval.DISAPPROVED;
			break;
		}

		units = projects[projectSelected-1].getStages()[stageSelected-1].getKnowledgeUnit();
		units[knowledgeUnitSelected-1].setApproval(approval);

		units = projects[projectSelected-1].getStages()[stageSelected-1].getKnowledgeUnit();
		units[knowledgeUnitSelected-1].setApprovalDate(approvalDate);

        return true; 
	}

	/**
	 * Description: boolean publishKnowledgeUnit allows to store the url of a published knowledge unit. 
	 * @param projectSelected int is the project position in the projects array. 
	 * @param stageSelected int is the stage position in the stages array. 
	 * @param knowledgeUnitSelected int id the knoeledge unit position int the units array.
	 * @param url String is the url of a published knowledge unit.
	 * @return true.
	 */
	public boolean publishKnowledgeUnit(int projectSelected, int stageSelected, int knowledgeUnitSelected, String url) {

		projects[projectSelected-1].getStages()[stageSelected-1].getKnowledgeUnit()[knowledgeUnitSelected-1].setUrl(url);

		return true; 
	}

	/**
	 * Description: String showAllKnowledgeUnits show all the knowledge units of a project stage. 
	 * @param projectSelected int is the project position in the projects array. 
	 * @param stageSelected int is the stage position in the stages array. 
	 * @return String msg is the list of knowledge units. 
	 */
	public String showAllKnowledgeUnits(int projectSelected, int stageSelected) {

		String msg = "Knowledge units list:\n";
		Stage[] stagesFor = new Stage[6];
		KnowledgeUnit[] knowledgeUnitFor = new KnowledgeUnit[50];

		if (projects[projectSelected-1] != null) {

			stagesFor = projects[projectSelected-1].getStages();
			knowledgeUnitFor = stagesFor[stageSelected-1].getKnowledgeUnit();

			for (int s = 0; s < knowledgeUnitFor.length; s++) {

				if (knowledgeUnitFor[s] != null) {

					msg += (s + 1) + ") " + knowledgeUnitFor[s].getId() + "\n";
				}
			}
		} else {

			msg = "Number outside bounds";
		}

		return msg;
	}

	/**
	 * Description: String countKnowledgeUnitsByType allows to count how many knowledge units there are by each type. 
	 * @return msg String list of knowledge by type. 
	 */
	public String countKnowledgeUnitsByType() {

		String msg = "";
		Stage[] stagesFor = new Stage[6];
		KnowledgeUnit[] knowledgeUnitFor = new KnowledgeUnit[50];
		int countTechnical = 0;
		int countManagement = 0;
		int countDomain = 0;
		int countExperiences = 0;

		for (int p = 0; p < projects.length; p++) {

			if (projects[p] != null) {

				stagesFor = projects[p].getStages();

				for (int i = 0; i < stagesFor.length; i++) {

					knowledgeUnitFor = stagesFor[i].getKnowledgeUnit();
					
					for (int s = 0; s < knowledgeUnitFor.length; s++) {

						if (knowledgeUnitFor[s] != null) {
		
							if (knowledgeUnitFor[s].getType() == KnowledgeUnitType.TECHNICAL) {

								countTechnical += 1;

							} else if (knowledgeUnitFor[s].getType() == KnowledgeUnitType.MANAGEMENT) {

								countManagement +=1;

							} else if (knowledgeUnitFor[s].getType() == KnowledgeUnitType.DOMAIN) {

								countDomain += 1;

							} else if (knowledgeUnitFor[s].getType() == KnowledgeUnitType.EXPERIENCES) {

								countExperiences++;
							}
						}
					}
				}
			}
		}

		msg = "Number of knowledge units by type: \n1. Technical: " + countTechnical + "\n2. Management: " + "\n3. Domain: " + countDomain + "\n4. Experiences: " + countExperiences; 

		return msg;
	}

	/**
	 * Description: String showLearnedLessons shows the learned lessons of all projects in a specfic stage. 
	 * @param stageSelected String is the stage position in the stage array. 
	 * @return String msg is the list of learned lessons. 
	 */
	public String showLearnedLessons(int stageSelected) {

		StageName stageName = StageName.DEFAULT;

		switch(stageSelected) {
			case 1: 
				stageName = StageName.START;
			break;
			
			case 2: 
				stageName = StageName.ANALISYS;
			break;

			case 3: 
				stageName = StageName.DESIGN;
			break;

			case 4: 
				stageName = StageName.EJECUTION; 
			break;

			case 5: 
				stageName = StageName.END; 
			break; 

			case 6: 
				stageName = StageName.CONTROL;
			break;
		}

		String msg = "List of learned lessons in all projects - stage: " + stageName;
		KnowledgeUnit[] knowledgeUnitFor = new KnowledgeUnit[50];

		for (int i = 0; i < projects.length; i++) {

			if (projects[i] != null) {

				msg += "\nProject: " + projects[i].getProyectName(); 
				knowledgeUnitFor = projects[i].getStages()[stageSelected-1].getKnowledgeUnit();

				for (int s = 0; s < knowledgeUnitFor.length; s++) {

					if (knowledgeUnitFor[s] != null) {

						msg += "\n" + knowledgeUnitFor[s].getLearnedLessons();
					}
				}
			}
		}

		return msg;
	}

	/**
	 * Description: String projectWithMoreKnowledgeUnits shows the project with more knowledge units. 
	 * @return	msg String is name of the project with more knowledge units. 
	 */
	public String projectWithMoreKnowledgeUnits() {

		String msg = "";
		int unitsNumber = 0;
		int countUnits = 0;
		String projectName = "";
		Stage[] projectStages = new Stage[6];
		KnowledgeUnit[] projectUnits = new KnowledgeUnit[50];

		for (int p = 0; p < projects.length; p++) {

			if (countUnits > unitsNumber) {
				if (projects[p] != null) {

					projectName = projects[p].getProyectName();
				}
	
				unitsNumber = countUnits;
			}

			if (projects[p] != null) {

				projectStages = projects[p].getStages();
			}
			countUnits = 0;

			for (int s = 0; s < projectStages.length; s++) {

				if (projectStages[s] != null) {

					projectUnits = projectStages[s].getKnowledgeUnit();
				}

				for (int k = 0; k < projectUnits.length; k++) {
					
					if (projectUnits[k] != null) {

						countUnits+=1;
					}
				}
			}
		}

		msg = "The project with more knowledge units is: " + projectName + "\nNumber: " + unitsNumber;

		return msg;
	}

	/**
	 * Description: int showIfCollaboratorHasRegisteredKnowledgeUnits shows if a collaborator has registered a knowledge unit. 
	 * @param collaboratorName String is the collaborator name. 
	 * @return int numberOfKnowledgeUnits is the number of units that the cullaborator has created. 
	 */
	public int showIfCollaboratorHasRegisteredKnowledgeUnits(String collaboratorName) {

		int numberOfKnowledgeUnit = 0;
		Stage[] projectStages = new Stage[6];
		KnowledgeUnit[] projectUnits = new KnowledgeUnit[50];

		for (int p = 0; p < projects.length; p++) {

			if (projects[p] != null) {

				projectStages = projects[p].getStages();

				for (int s = 0; s < projectStages.length; s++) {
	
					projectUnits = projectStages[s].getKnowledgeUnit();
	
					for (int k = 0; k < projectUnits.length; k++) {

						if (projectUnits[k] != null) {

							if (projectUnits[k].getCollaboratorName().toLowerCase().contains(collaboratorName.toLowerCase())) {
	
								numberOfKnowledgeUnit++;
							}
						}

					}
				}
			}
			
		}

		return numberOfKnowledgeUnit;
	}

	/**
	 * Description: String showLearnedLessonsBySearch shows the learn lessons of a approved and piblished project according to a search index.
	 * @param search String is the search index. 
	 * @return String msg is the list of learned lessons. 
	 */
	public String showLearnedLessonsBySearch(String search) {

		String msg = "Learned lessons according to your search: ";
		String projectName = "";

		Stage[] stagesFor = new Stage[6];
		KnowledgeUnit[] knowledgeUnitFor = new KnowledgeUnit[50];


		for (int p = 0; p < projects.length; p++) {

			if (projects[p] != null) {

				projectName = projects[p].getProyectName();
				stagesFor = projects[p].getStages();

				for (int i = 0; i < stagesFor.length; i++) {

					knowledgeUnitFor = stagesFor[i].getKnowledgeUnit();
					
					for (int s = 0; s < knowledgeUnitFor.length; s++) {

						if (knowledgeUnitFor[s] != null) {
		
							if (knowledgeUnitFor[s].getApproval() == KnowledgeUnitApproval.APPROVED && knowledgeUnitFor[s].getUrl() != "") {

								if (knowledgeUnitFor[s].getLearnedLessons().toLowerCase().contains(search.toLowerCase())) {

									msg += "\n" + projects[p].getProyectName() + ": " + knowledgeUnitFor[s].getLearnedLessons();
								} else {

									msg = "No results";
								}

							}
						}
					}
				}
			}
		}

		return msg;
	}
}