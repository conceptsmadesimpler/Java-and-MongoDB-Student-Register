package studentregister;

import java.io.IOException;
import java.util.Scanner;

public class StudentRegisterDriver {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Admin admin = new Admin();

		int choice = 10;

		while (choice != 0) {
			System.out.println(
					"Choose the option (enter number):\n 1. Add \n 2. Edit \n 3. Delete \n 4. View \n 5. Save \n 6. Load \n 0. Exit\n");
			choice = Integer.parseInt(input.next());
			switch (choice) {
			case 1:
				System.out.println("Enter the Student's Name");
				String name = input.next();
				System.out.println("Enter the Student's ID");
				Integer iDInteger = Integer.parseInt(input.next());
				System.out.println("Enter the Students subjects seperated by comma");
				String subjectString = input.next();
				String[] subjects = subjectString.split(",");
				admin.add(iDInteger, name, subjects);
				break;
			case 2:
				System.out.println("Enter the Student's ID");
				Integer editIDInteger = Integer.parseInt(input.next());
				admin.edit(editIDInteger);
				break;
			case 3:
				System.out.println("Enter the Student's ID");
				Integer deleteIDInteger = Integer.parseInt(input.next());
				admin.delete(deleteIDInteger);
				break;
			case 4:
				admin.view();
				break;
			case 5:
				System.out.println("Saving");
				try {
					admin.save();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("Loading");
				try {
					admin.load();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 0:
				System.out.println("Exiting");
				break;
			default:
				System.out.println("Wrong input");
				break;
			}
		}

		if (choice == 0) {
			input.close();
			System.exit(0);
		}

	}

}
