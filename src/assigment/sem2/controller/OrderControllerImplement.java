package assigment.sem2.controller;

import assigment.sem2.Util.DateTimeUtil;
import assigment.sem2.entity.Order;
import assigment.sem2.model.OrderModel;
import assigment.sem2.model.OrderModelImplement;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderControllerImplement implements OrderController {
    private OrderModel orderModel;
    private Scanner scanner;
    private ValidateImplement validateImplement = new ValidateImplement();

    public OrderControllerImplement() {
        this.orderModel = new OrderModelImplement();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void addNewOrder() {
        String id;
        String customer;
        String productsName;
        int price;
        String strCreateAt;
        Date dob;
        int status;
        do {
            System.out.println("Please enter Order id (example: Order123): ");
            id = scanner.nextLine();
            if (!validateImplement.verifyId(id))
                System.out.println("Invalid data, please try again");
        } while (!validateImplement.verifyId(id));

        do {
            System.out.println("Please enter customer name: ");
            customer = scanner.nextLine();
            if (!validateImplement.verifyCustomer(customer))
                System.out.println("Invalid data, please try again");
        } while (!validateImplement.verifyCustomer(customer));

        do {
            System.out.println("Please enter products name: ");
            productsName = scanner.nextLine();
            if (productsName.length() <= 0)
                System.out.println("Invalid data, please try again");
        } while (productsName.length() <= 0);

        do {
            System.out.println("Please enter Price: ");
            price = scanner.nextInt();
            scanner.nextLine();
            if (price <= 0)
                System.out.println("Invalid data, please try again");
        } while (price <= 0);

        System.out.println("Create at (with format yyyy-mm-DD, for example:1994-09-10)");
        strCreateAt = scanner.nextLine();
        dob = DateTimeUtil.parseDateFromString(strCreateAt);

        do {
            System.out.println("Please enter status: ");
            status = scanner.nextInt();
            if (!validateImplement.verifyStatus(status))
                System.out.println("Invalid data, please try again");
        } while (!validateImplement.verifyStatus(status));

        Order order = new Order(id, customer, productsName, price, dob, status);
        if (orderModel.save(order)) {
            System.out.println("Action success!");
        } else {
            System.out.println("Action fails! Please try again");
        }
    }

    @Override
    public void showList() {
        List<Order> list = orderModel.findAll();
        if (list.size() == 0) {
            System.out.println("Have no Order. Please add first one");
            return;
        }
        System.out.printf("%5s%10s%10s | %10s%10s%10s | %5s%20s%5s | %5s%10s%5s | %5s%10s%5s | %5s%10s%5s\n",
                "", "id", "",
                "", "Customer", "",
                "", "Products", "",
                "", "Price", "", "",
                "", "Create at", "",
                "", "Status", "");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @Override
    public void searchOrderById() {
        System.out.println("Please enter id to search");
        String id = scanner.nextLine();
        Order order = orderModel.findById(id);
        if (order == null) {
            System.out.println("Not found");
            return;
        }
        System.out.printf("Found one order that match id %s: ", id);
        System.out.println(order.toString());
    }

    @Override
    public void searchByTime() {
        int totalPrice = 0;
        System.out.println("Enter begin date (with format yyy-mm-DD, for example:1994-09-10): ");
        String bDate = scanner.nextLine();
        System.out.println("Enter end date (with format yyy-mm-DD, for example:1994-09-10): ");
        String eDate = scanner.nextLine();
        System.out.println("Enter selection to display (1. Unpaid, 2. Paid, 0. Deleted)");
        int status = scanner.nextInt();
        scanner.nextLine();
        List<Order> list = orderModel.findByStatus(bDate, eDate, status);
        if (list.size() == 0) {
            System.out.printf("Have no finished order from time %s to %s\n", bDate, eDate);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
               totalPrice += list.get(i).getPrice();
        }
        System.out.printf("Total money: %d %s\n",totalPrice, "vnd");
    }

    @Override
    public void update() {
        System.out.println("Please enter id to update: ");
        String id = scanner.nextLine();
        Order order = orderModel.findById(id);
        if (order == null) {
            System.out.println("Not found");
            return;
        }
        System.out.println("Found one teacher with information below");
        System.out.println(order.toString());
        System.out.println("please enter new information");
        System.out.println("Please enter customer name: ");
        String customer = scanner.nextLine();
        System.out.println("Please enter products name: ");
        String productsName = scanner.nextLine();
        System.out.println("Please enter Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Create at (with format yyy-mm-DD, for example:1994-09-10)");
        String strCreateAt = scanner.nextLine();
        Date dob = DateTimeUtil.parseDateFromString(strCreateAt);
        System.out.println("Please enter status: ");
        int status = scanner.nextInt();
        Order updateOrder = new Order(id, customer, productsName, price, dob, status);
        if (orderModel.update(id, updateOrder)) {
            System.out.println("Action success!");
        } else {
            System.out.println("Action fails! Please try again");
        }

    }

    @Override
    public void delete() {
        System.out.println("Please enter id to delete");
        String id = scanner.nextLine();
        Order order = orderModel.findById(id);
        if (order == null) {
            System.out.println("Not found");
            return;
        }
        System.out.println("Found one order with information below");
        System.out.println(order.toString());
        System.out.println("Do you want to delete this teacher?(y/n): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            if (orderModel.delete(id)) {
                System.out.println("Action success");
            } else {
                System.out.println("Action fails! Please try again");
            }
        }
    }

}
