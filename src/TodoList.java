import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TodoList {
    static ArrayList<String> list = new ArrayList<>();
    static String name;
    public static void main(String[] args) {
        System.out.println();
        System.out.println(" ######    ####    ####      ####             ##        ####     ####    ######  \n" +
                "   ##     ##  ##   ## ##    ##  ##            ##         ##     ##  ##     ##    \n" +
                "   ##     ##  ##   ##  ##   ##  ##            ##         ##     ##         ##    \n" +
                "   ##     ##  ##   ##  ##   ##  ##            ##         ##      ####      ##    \n" +
                "   ##     ##  ##   ##  ##   ##  ##            ##         ##         ##     ##    \n" +
                "   ##     ##  ##   ## ##    ##  ##            ##         ##     ##  ##     ##    \n" +
                "   ##      ####    ####      ####             ######    ####     ####      ##    \n" +
                "                                                                                 \n");

        name = addName();
        displayWelcome();
    }

    //Displays the welcome
    static void displayWelcome() {
        System.out.println("-------------------------------");

        for (int i = 0; i < 50; i++) {
            System.out.print("=");
        }

        System.out.println("\n| --Press 1 to add a new task                    |");
        System.out.println("| --Press 2 to view the list of tasks            |");
        System.out.println("| --Press 3 to delete tasks                      |");
        System.out.println("| --Press 4 to export the tasks to a Text File   |");
        System.out.println("| --Press 5 to exit the application              |");

        for (int i = 0; i < 50; i++) {
            System.out.print("=");
        }

        int enteredNumber = 0;
        do {
            System.out.print("\nEnter your choice (1|2|3|4|5): ");
            Scanner scanner = new Scanner(System.in);
            enteredNumber = scanner.nextInt();
            if ((enteredNumber < 1) || (enteredNumber > 5)){
                System.out.println("Entered Number invalid!!! Enter again");
            }
        } while ((enteredNumber < 1) || (enteredNumber > 5));

        switch (enteredNumber) {
            case 1:
                addTask();
                break;
            case 2:
                viewTask();
                break;
            case 3:
                deleteTask();
                break;
            case 4:
                export();
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                break;
        }
    }

    //method to add user's name
    static String addName(){
        System.out.print("Please enter your Full Name: ");
        Scanner nameScanner = new Scanner(System.in);
        String userName = nameScanner.nextLine();

        return userName;

    }

    //method to add a task
    static void addTask(){
        System.out.println("-------------------------------");
        System.out.println("Enter you task");
        Scanner entry = new Scanner(System.in);
        String taskName = "";
        taskName = entry.nextLine();
        list.add(taskName);
        System.out.println("Task added successfully!");

        displayWelcome();
    }

    //method to view tasks
    static void viewTask(){
        System.out.println("-------------------------------");
        System.out.println("\nYour current tasks:");
        System.out.println("");
        for (int i = 0; i < list.size(); i++){
            System.out.println((i + 1) + ". " + list.get(i));
        }
        if (list.size() == 0){
            System.out.println("List is empty!");
        } else {
            System.out.println("\nYou have " + list.size() + " tasks on your list right now");
        }

        displayWelcome();

    }

    //method to delete tasks
    static void deleteTask(){
        System.out.println("-------------------------------");
        if (list.size() == 0){
            System.out.println("List is empty! No tasks to delete!");
        } else {
            System.out.println("Task List: ");
            for (int i = 0; i < list.size(); i++){
                System.out.println((i + 1) + ". " + list.get(i));
            }
            System.out.print("\nWhich one of the tasks you want to delete? ");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if (input > 0 && input <= list.size()){
                String deletedTask = list.remove(input - 1);
                System.out.println(deletedTask + " deleted successfully");
            } else {
                System.out.println("Invalid input. Task does not exist.");
            }
        }

        displayWelcome();
    }

    //method to output the task list
    static void export() {
        System.out.println("-------------------------------");
        if (list.size() == 0) {
            System.out.println("No tasks to export");
        } else {
            String fileName = name + "'s tasks.txt";
            File file = new File(fileName);
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file: " + e.getMessage());
            }
            try {
                FileWriter Writer = new FileWriter(fileName);
                Writer.write(name + "'s tasks\n");
                for (int i = 0; i < list.size(); i++){
                    //System.out.println((i + 1) + ". " + list.get(i));
                    Writer.write((i + 1) + ". " + list.get(i) + "\n");
                }
                Writer.close();
                System.out.println("Successfully exported.");
            }
            catch (IOException e) {
                System.out.println("An error has occurred.");
                e.printStackTrace();
            }
        }

        displayWelcome();
    }

}