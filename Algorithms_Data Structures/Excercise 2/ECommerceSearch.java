import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {

    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public void display() {
            System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
        }
    }

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Shoes", "Footwear"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Book", "Stationery")
        };

        System.out.println("Linear Search for 'Phone':");
        Product result1 = linearSearch(products, "Phone");
        if (result1 != null) result1.display();
        else System.out.println("Product not found.");

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\nBinary Search for 'Phone':");
        Product result2 = binarySearch(products, "Phone");
        if (result2 != null) result2.display();
        else System.out.println("Product not found.");
    }
}
