package to_do_list;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList{
	private static ArrayList<String> task=new ArrayList<>();
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		while(true) {
			displayMenu();
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				addTask();
				break;
			case 2:
				viewTasks();
				break;
			case 3:
				markTaskComplete();
				break;
			case 4:
				deleteTask();
				break;
			case 5:
				System.out.println("Exiting...Goodbye!");
				return;
			default:
				System.out.println("Invalid choice.Pleace try again.");
			}
		}
	}
	public static void displayMenu() {
		System.out.println("\n---To-Do List Menu---");
		System.out.println("1.Add a Task");
		System.out.println("2.View All Tasks");
		System.out.println("3.Mark a Task as Complete");
		System.out.println("4.Delete a Task");
		System.out.println("5.Exit");
		System.out.println("Enter your choice:");
		}
	public static void addTask() {
		System.out.println("Enter the Task:");
		String newtask=sc.nextLine();
		task.add(newtask);
		System.out.println("Task added successfully");
	}
	public static void viewTasks() {
		if(task.isEmpty()) {
			System.out.println("No tasks available");
			return;
		}
		System.out.println("\n---Your tasks---");
		for(int i=0;i<task.size();i++) {
			System.out.println((i+1)+"."+task.get(i));
		}
	}
	public static void markTaskComplete() {
		if(task.isEmpty()) {
			System.out.println("No tasks available");
			return;
		}
		viewTasks();
		System.out.println("Enter the task number to mark as complete:");
		int taskNumber=sc.nextInt();
		sc.nextLine();
		
		if(taskNumber<=0 || taskNumber>task.size()) {
			System.out.println("invalid task number.");
		}
		else {
			String completedTask=task.get(taskNumber-1)+"[completed]";
			task.set(taskNumber-1, completedTask);
			System.out.println("Task marked as complete!");
		}
	}
	public static void deleteTask() {
		if(task.isEmpty()) {
			System.out.println("No tasks available");
			return;
		}
		viewTasks();
		System.out.println("Enter the task number to delete:");
		int taskNumber=sc.nextInt();
		sc.nextLine();
		
		if(taskNumber<=0 || taskNumber>task.size()) {
			System.out.println("invalid task number.");
		}
		else {
			task.remove(taskNumber-1);
			 System.out.println("task deleted successfully.");
		}
	}

}
