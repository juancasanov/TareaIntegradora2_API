package ui;

import java.util.Scanner;
import javax.sound.midi.SysexMessage;
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

            System.out.println("1. Create proyect \n2. Mark stage of a project as complete \n3. Register knowledge unit \n4. Approve knowledge unit \n5. Publish knowledge unit \n6. Exit");
            int option = reader.nextInt();

            switch (option) {

                case 1: 

                    createProject();

                break;

                case 2:

                    stageAsComplete();

                break;

                case 3:

                    registerKnowledgeUnit();

                break;

                case 4:

                    approveKnowledgeUnit();

                break;

                case 5:

                    cond = true;

                break;

            }

        }

	}

    public void createProject() {

        System.out.println("Enter the project's information below");

        reader.nextLine();

        System.out.println("Provide the project's name");
        String projectName = reader.nextLine();

        System.out.println("Provide the client's name");
        String clientName = reader.nextLine();

        System.out.println("Provide the planned start date for the project");
        String plannedStartDate = reader.nextLine();

        System.out.println("Provide the planned end date for the project");
        String plannedEndDate = reader.nextLine();

        System.out.print("Provide the projec't budged");
        double budged = reader.nextDouble();

        /**
         * System.out.print("Provide the name of the project manager");
         * String projectManagerName = reader.nextLine();
         * 
         * System.out.print("Provide the celphone of the project manager");
         * String projectManagerCelphone = reader.nextLine();
         * 
         * System.out.println("How many months will each stage take")
         * String stageTime = reader.nextLine();
        */

        if (controller.createProyect(projectName, clientName, plannedStartDate, plannedEndDate, budged)) {

            System.out.println("Project correctly created");

        } else {

            System.out.println("Full memory. Project was not created");

        }

    }

    public void stageAsComplete() {

        System.out.println("Choose the proyect's number");
        String c = reader.nextLine();

        System.out.println("Provide the date of culmination");
        String culminationDate = reader.nextLine();

    }

    public void registerKnowledgeUnit() {

		System.out.println("Enter the knowledge units information below");

		reader.nextLine();
        
        System.out.println("Provide the knowledge unit id");
        String id = reader.nextLine();

        System.out.println("Provide the knowledge unit description");
        String description = reader.nextLine();

		System.out.println("Choose the type: \n1. Technical \n2. Domain \n 3. Experiences");
        int type = reader.nextInt();

		System.out.println("Provide the learned lessons");
        String learnedLessons = reader.nextLine();

        if (controller.registerKnowledgeUnit(id, description, type, learnedLessons)) {

            System.out.println("Knowledge unit correctly registered");

        } else { 

            System.out.println("Full memory. Knowledge unit was not registered");

        }

	}

	private void approveKnowledgeUnit() {

		System.out.println(controller.toApproveKnowledgeUnit());

		System.out.println("Select the position of the knowledge unit you want to approve");
		int position = reader.nextInt();

		controller.approveKnowledgeUnit(position);

	}

    public void publishKnowledgeUnit() {

        System.out.println("Provide the URL");
        String url = reader.nextLine();

    }

	public void showAllKnowledgeUnits() {

		String consult = controller.getAllKnowledgeUnits();

        if (consult.equals("")){

            System.out.println("There is any knowledge units registered");

        } else {

            System.out.println(consult);

        }

	}

}