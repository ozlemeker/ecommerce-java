import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<BasketItem> items;

    public ShoppingBasket() {
        items = new ArrayList<>();
    }

    
    public void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be a positive number.");
            return;  
        }

        boolean itemExists = false;
        for (BasketItem item : items) {
            if (item.getProduct().getProductId() == product.getProductId()) {
                item.setQuantity(item.getQuantity() + quantity);  
                itemExists = true;
                break;  // Looptan ürün eklendiğinde çık
            }
        }

        if (!itemExists) {
            // Yeni product yoksa sepete ekle
            items.add(new BasketItem(product, quantity));
        }
    }

    
    public void removeItem(Product product, int quantity) {

        for (BasketItem item : items) {
            if (item.getProduct().getProductId() == product.getProductId()) {
                if (item.getQuantity() < quantity) {
                    System.out.println("You're trying to remove more than the available quantity.");
                    return;  
                }

                item.setQuantity(item.getQuantity() - quantity);
                if (item.getQuantity() == 0) {
                    items.remove(item); 
                }
                return;
            }
        }
        System.out.println("This product is not in your basket."); 
    }

    public void displayBasket() {
        if (items.isEmpty()) {
            System.out.println("Your basket is empty.");
            return;
        }

        for (BasketItem item : items) {
            Product product = item.getProduct();
            double totalPrice = item.getQuantity() * product.getPrice();
            System.out.printf("Product: %s\nQuantity: %d\nUnit Price: $%.2f\nTotal Price: $%.2f\n", 
                  product.getName(), 
                  item.getQuantity(), 
                  product.getPrice(), 
                  totalPrice); 
        }
    }


    public List<BasketItem> getItems() {
        return items;
    }
}