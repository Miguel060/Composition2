package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Enter Client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date: (DD/MM/YYYY): )");
        Date birthDate = sdf.parse(sc.nextLine());
        Client client = new Client(name, email, birthDate);
        System.out.println("Enter Order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        Order order = new Order(new Date(), status, client);
        System.out.print("How many itens to this order? ");
        int it = sc.nextInt();
        for (int i = 0; i < it; i++) {
            System.out.println();
            System.out.println("Enter # " + (i + 1) + "item data: ");
            System.out.print("Name: ");
            String itemName = sc.next();
            System.out.print("Product price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(itemName, price);
            OrderItem ot = new OrderItem(quantity, price, product);
            order.addItem(ot);
        }
        System.out.println();
        System.out.println(order); 

    }
}
