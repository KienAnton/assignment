package assigment.sem2.view;

import assigment.sem2.controller.OrderControllerImplement;

import java.util.Scanner;

public class OrderViewImplement implements OrderView {

    private OrderControllerImplement orderControllerImplement = new OrderControllerImplement();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void generateMenu() {
        while (true) {
            System.out.println("Order manager");
            System.out.println("----------------------------");
            System.out.println("1. Add new order.");
            System.out.println("2. Show list.");
            System.out.println("3. Search order by id.");
            System.out.println("4. Revenue by time.");
            System.out.println("5. Update");
            System.out.println("6. Delete");
            System.out.println("0. Exist.");
            System.out.println("-----------------------------");
            System.out.println("Please enter your choice (0-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    orderControllerImplement.addNewOrder();
                    break;
                case 2:
                    orderControllerImplement.showList();
                    break;
                case 3:
                    orderControllerImplement.searchOrderById();
                    break;
                case 4:
                    orderControllerImplement.searchByTime();
                    break;
                case 5:
                    orderControllerImplement.update();
                    break;
                case 6:
                    orderControllerImplement.delete();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 0-6");
                    break;
            }
            if (choice == 0) {
                break;
            }
        }

    }
}

