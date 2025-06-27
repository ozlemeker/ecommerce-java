public class Product {
    private String productId;  
    private String name;    
    private double price;    
    private int stockQuantity; 

    
    public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    
    public String getProductId() {
        return productId;
    }

   
    public String getName() {
        return name;
    }

   
    public double getPrice() {
        return price;
    }

    
    public int getStockQuantity() {
        return stockQuantity;
    }

   
    public void updateStock(int quantity){
        if (quantity > stockQuantity) {
           
            System.out.println("Sorry, insufficient stock available.");
        }
      
        stockQuantity -= quantity;
    }