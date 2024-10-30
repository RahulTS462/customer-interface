package com.example.CustomerServicedemo;

import com.example.Customers.CustomerCare;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

			 Tasks:
		 *  1. Load the beans from ApplicationContext.xml
		 *  2. Display all the departments available and get the input from user.
		 *  3. Get the message from user and store it into the respective department.
		 *  
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("Welcome to our Customer Care application.");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		String name = scanner.next();
		while (true){
			System.out.println("Please select a department to connect to: \n1. Payment Department.\n2. Query Department.\n3. Sales Department.\n4. Exit");
			int userChoice = scanner.nextInt();
			String queryChoice = "";
			switch (userChoice) {
				case 1 -> queryChoice = "paymentDepartment";
				case 2 -> queryChoice = "queryDepartment";
				case 3 -> queryChoice = "salesDepartment";
				case 4 -> {
					System.out.println("Exiting...");
					return;
				}
				default -> {
					System.out.println("Invalid choice");
					return;
				}
			}
			CustomerCare customerCare = (CustomerCare) context.getBean(queryChoice);
			customerCare.setCustomerName(name);
			customerCare.getService();
			String problem = scanner.next();
			customerCare.setProblem(problem);
			customerCare.getProblem();
		}
	}
}
