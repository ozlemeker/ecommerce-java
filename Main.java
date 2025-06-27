import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("ID55268", "Laptop", 1000, 10);
        Product p2 = new Product("ID55287", "Phone", 100, 5);

        ShoppingBasket basket = new ShoppingBasket();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the product ID and quantity to add to the cart (example: ID55268, ID55287):");
        while (true) {
            System.out.print("Please enter the product ID (Press Q to quit): ");
            String productId = scanner.nextLine();
            if (productId.equalsIgnoreCase("Q")) break;

            System.out.print("Enter the quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            if (productId.equals(p1.getId())) {
                try {
                    basket.addItem(p1, quantity);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (productId.equals(p2.getId())) {
                try {
                    basket.addItem(p2, quantity);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid product ID.");
            }
        }

        System.out.println("Your Shopping Basket: ");
        basket.displayBasket();

        System.out.println("\nChoose the payment type: Press 1 for Credit Card, Press 2 for EFT/Transfer");
        int paymentChoice = Integer.parseInt(scanner.nextLine());
        if (paymentChoice == 1) {
            System.out.print("Enter the credit card number: ");
            String cardNumber = scanner.nextLine();
            System.out.println("Payment processed with Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
        } else if (paymentChoice == 2) {
            System.out.println("Payment processed via EFT/Transfer.");
        } else {
            System.out.println("Invalid payment choice.");
        }
        scanner.close();
    }
}
