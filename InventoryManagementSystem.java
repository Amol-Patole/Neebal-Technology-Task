import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nInventory Management System:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Display Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    int addQuantity = scanner.nextInt();
                    manager.addProduct(addId, addName, addQuantity);
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new product name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new product quantity: ");
                    int updateQuantity = scanner.nextInt();
                    manager.updateProduct(updateId, updateName, updateQuantity);
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    String displayId = scanner.nextLine();
                    manager.displayProduct(displayId);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    static class Product {
        private String id;
        private String name;
        private int quantity;

        public Product(String id, String name, int quantity) {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Product [ID=" + id + ", Name=" + name + ", Quantity=" + quantity + "]";
        }
    }

    static class InventoryManager {
        private Map<String, Product> products;

        public InventoryManager() {
            products = new HashMap<>();
        }

        public void addProduct(String id, String name, int quantity) {
            if (!products.containsKey(id)) {
                Product product = new Product(id, name, quantity);
                products.put(id, product);
                System.out.println("Product added: " + product);
            } else {
                System.out.println("Product with ID " + id + " already exists.");
            }
        }

        public void updateProduct(String id, String name, int quantity) {
            Product product = products.get(id);
            if (product != null) {
                product.setName(name);
                product.setQuantity(quantity);
                System.out.println("Product updated: " + product);
            } else {
                System.out.println("Product with ID " + id + " does not exist.");
            }
        }

        public void displayProduct(String id) {
            Product product = products.get(id);
            if (product != null) {
                System.out.println(product);
            } else {
                System.out.println("Product with ID " + id + " does not exist.");
            }
        }
    }
}
