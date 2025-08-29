import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine vm = new VendingMachine(new ConsoleNotifier());

        // Add products
        vm.addProduct(new Product("A1", "Coke", 1.50, 2));
        vm.addProduct(new Product("B1", "Pepsi", 1.40, 1));
        vm.addProduct(new Product("C1", "Sprite", 1.60, 3));

        System.out.println("==== Welcome to the Vending Machine ====");

        boolean exit = false;

        while (!exit) {
            System.out.println("**************************");
            System.out.println("\nAvailable Products:");
            for (Product product : vm.getInventory().values()) {
                System.out.println(product.getCode() + ": " + product.getName() +
                        " - $" + product.getPrice() + " [" + product.getQuantity() + "]");
            }
            System.out.println("**************************");
            System.out.println("\nChoose an action:");
            System.out.println("1. Insert Coin");
            System.out.println("2. Eject Coin");
            System.out.println("3. Select Item");
            System.out.println("4. Press Button");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    vm.insertCoin();
                    break;

                case "2":
                    vm.ejectCoin();
                    break;

                case "3":
                    System.out.print("Enter item code: ");
                    String code = scanner.nextLine().toUpperCase();
                    vm.selectItem(code);
                    break;

                case "4":
                    vm.pressButton();
                    break;

                case "5":
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            if (vm.isAllSoldOut()) {
                System.out.println("\n⚠️ Machine is sold out. Exiting...");
                break;
            }
        }

        System.out.println("Thank you for using the Vending Machine!");
        scanner.close();
    }
}
