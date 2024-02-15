import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("+-----------+");
        System.out.println("| Todo List |");
        System.out.println("+-----------+");
        displayWelcome();
    }

    //Displays the welcome
    static void displayWelcome() {
        System.out.println("\nPress 1 to add a new task");
        System.out.println("Press 2 to view the list of tasks");
        System.out.println("Press 3 to delete tasks");
        System.out.println("Press 4 to exit the application");
        int enteredNumber = 0;
        do {
            System.out.print("\nEnter your choice (1|2|3|4): ");
            Scanner scanner = new Scanner(System.in);
            enteredNumber = scanner.nextInt();
            if ((enteredNumber < 1) || (enteredNumber > 4)){
                System.out.println("Entered Number invalid!!! Enter again");
            }
        } while ((enteredNumber < 1) || (enteredNumber > 4));

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
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("EnK: " + enteredNumber);
        }

    }

    //method to add a task
    static void addTask(){
        System.out.println("ADD TASK");
        Scanner entry = new Scanner(System.in);
        String taskName = "";
        taskName = entry.nextLine();
        list.add(taskName);
        System.out.println("Task added successfully!");

        displayWelcome();
    }

    //method to view tasks
    static void viewTask(){
        System.out.println("\nYour current tasks:");
        System.out.println("");
        for (int i = 0; i < list.size(); i++){
            System.out.println((i + 1) + ". " + list.get(i));
        }
        if (list.size() == 0){
            System.out.println("List is empty!");
        } else {
            System.out.println("You have " + list.size() + " tasks on your list right now");
        }

        displayWelcome();

    }

    //method to delete tasks
    static void deleteTask(){
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

}