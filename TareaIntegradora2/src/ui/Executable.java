package ui;

import java.util.Scanner;
import model.Controller;


public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Executable exe = new Executable();
		exe.menu();
	}

	public void menu() {

		System.out.println("Welcome to GreenSQA");

        boolean cond = false;

        while (!cond) {

            System.out.println(" Main Menu \n1. Create proyect \n2. Mark stage of a project as complete \n3. Register knowledge unit \n4. Approve knowledge unit \n5. Publish knowledge unit \n6. Show how many knowledge units there are by type \n7. Show leared lessons of each knowledge unit in a specific stage \n8. show the name of the project with the most knowledge capsules \n9. Search if a collaborator has registered a knowledge unit in a project \n10. Seacher for learned lessons in approved and published knowledge units \n11. Exit");
            int option = reader.nextInt();

            switch (option) {
                case 1: 
                    createProject();
                break;

                case 2:
                    setStageAsComplete();
                break;

                case 3:
                    registerKnowledgeUnit();
                break;

                case 4:
                    approveKnowledgeUnit();
                break;

                case 5:
                    publishKnowledgeUnit();
                break;

                case 6:
                    numberKnowledgeUnitsByType();
                break;

                case 7:
                    showLearnedLessons();
                break;

                case 8:
                    projectWithMoreUnits();
                break;

                case 9:
                    showIfCollaboratorHasRegisteredKnowledgeUnits();
                break;

                case 10: 
                    showLearnedLessonsBySearch();
                break; 

                case 11: 
                    cond = true;
                break; 
            }
        }
	}

    public void createProject() {

        int[] stageTime = new int[6];

        System.out.println("Enter the project's information below");
        reader.nextLine();

        System.out.println("Provide the project's name");
        String projectName = reader.nextLine();

        System.out.println("Provide the client's name");
        String clientName = reader.nextLine();

        System.out.println("Provide the planned start date for the project:");
        System.out.println("Enter the day");
        String startDay = reader.nextLine();
        System.out.println("Enter the month"); 
        String startMonth = reader.nextLine();
        System.out.println("Enter the year"); 
        String startYear = reader.nextLine();

        System.out.println("Provide the planned end date for the project:");
        System.out.println("Enter the day");
        String endDay = reader.nextLine();
        System.out.println("Enter the month"); 
        String endMonth = reader.nextLine();
        System.out.println("Enter the year"); 
        String endYear = reader.nextLine();

        System.out.print("Provide the project's budged");
        double budged = reader.nextDouble();

        reader.nextLine();

        System.out.print("Provide the name of the GreenSQA project manager");
        String greenManagerName = reader.nextLine();
         
        System.out.print("Provide the celphone of the GreenSQA project manager");
        String greenManagerPhoneNumber = reader.nextLine();

        System.out.print("Provide the name of the client project manager");
        String clientManagerName = reader.nextLine();
         
        System.out.print("Provide the celphone of the client project manager");
        String clientManagerPhoneNumber = reader.nextLine();
        
        for (int i = 0; i < stageTime.length; i++) {

            System.out.println("How many months stage " + (i + 1) + " will take");
            stageTime[i] = reader.nextInt();
        }
       
        if (controller.createProyect(projectName, clientName, startDay, startMonth, startYear, endDay, endMonth, endYear, budged, greenManagerName, greenManagerPhoneNumber, clientManagerName, clientManagerPhoneNumber, stageTime)) {

            System.out.println("Project was correctly created");

        } else {

            System.out.println("Full memory. Project was not created");
        }
    }

    public void setStageAsComplete() {

        System.out.println(controller.showAllProjects());

        System.out.println("Select the proyect's number");
        int project = reader.nextInt();

        System.out.println(controller.showAllStages(project));

        System.out.println("Select the stage you want to culminate");
        int stage = reader.nextInt();

        if (controller.setStageAsComplete(project, stage)) {

            System.out.println("Culmination registered");

        } else {

            System.out.println("Error");
        }
    }

    public void registerKnowledgeUnit() {

        System.out.println(controller.showAllProjects());

        System.out.println("Choose the proyect's number");
        int project = reader.nextInt();

        System.out.println(controller.showAllStages(project));

        System.out.println("Choose the stage's number");
        int stage = reader.nextInt();

		System.out.println("Enter the knowledge units information below");

		reader.nextLine();
        
        System.out.println("Provide the knowledge unit id");
        String id = reader.nextLine();

        System.out.println("Provide the knowledge unit description");
        String description = reader.nextLine();

		System.out.println("Choose the type: \n1. Technical \n2. Management \n3. Domain \n4. Experiences");
        int type = reader.nextInt();

        reader.nextLine();

        System.out.print("Provide the collaborators name");
        String collaboratorName = reader.nextLine();

        System.out.print("Provide the collaborators charge");
        String collaboratorCharge = reader.nextLine();

		System.out.println("Provide the learned lessons");
        String learnedLessons = reader.nextLine();

        if (controller.registerKnowledgeUnit(project, stage, id, description, type, collaboratorName, collaboratorCharge, learnedLessons)) {

            System.out.println("Knowledge unit correctly registered");

        } else { 

            System.out.println("Full memory. Knowledge unit was not registered");
        }
	}

	private void approveKnowledgeUnit() {

        System.out.println(controller.showAllProjects());

        System.out.println("Choose the proyect's number");
        int project = reader.nextInt();

        System.out.println(controller.showAllStages(project));

        System.out.println("Choose the stage's number");
        int stage = reader.nextInt();

        System.out.println(controller.showAllKnowledgeUnits(project, stage));

		System.out.println("Select the position of the knowledge unit you want to approve");
		int unitPosition = reader.nextInt();

        System.out.println("Select [1] to approve, select [2] to disapprove");
        int approvalElection = reader.nextInt();

		controller.approveKnowledgeUnit(project, stage, unitPosition, approvalElection);
	}

    public void publishKnowledgeUnit() {
        
        System.out.println(controller.showAllProjects());

        System.out.println("Choose the proyect's number");
        int project = reader.nextInt();

        System.out.println(controller.showAllStages(project));

        System.out.println("Choose the stage's number");
        int stage = reader.nextInt();

        System.out.println(controller.showAllKnowledgeUnits(project, stage));

        System.out.println("Select the position of the knowledge unit you want to approve");
		int unitPosition = reader.nextInt();

        reader.nextLine();

        System.out.println("Provide the URL");
        String url = reader.nextLine();

        controller.publishKnowledgeUnit(project, stage, unitPosition, url);
    }

    public void numberKnowledgeUnitsByType(){

        System.out.println(controller.countKnowledgeUnitsByType());
    }

    public void showLearnedLessons() {

        System.out.println("Select the stage number: \n[1] Start \n[2] Analisys \n[3] Design \n[4] Ejecution \n[5] End \n[6] Control");
        int stageDesition = reader.nextInt();

        System.out.println(controller.showLearnedLessons(stageDesition));
    }

    public void projectWithMoreUnits() {

        System.out.println(controller.projectWithMoreKnowledgeUnits());
    }

    public void showIfCollaboratorHasRegisteredKnowledgeUnits(){

        reader.nextLine(); 
    
        System.out.println("Type the collaborators name");
        String name = reader.nextLine();

        System.out.println("Collaborator has restigered " + controller.showIfCollaboratorHasRegisteredKnowledgeUnits(name) + "knowledge units");   
    }

    public void showLearnedLessonsBySearch() {

        System.out.println("Type the learned lessons you want to search for:");
        String search = reader.nextLine();

        controller.showLearnedLessonsBySearch(search);
    }
}