public abstract class Payment {
    protected ShoppingBasket basket;

    public Payment(ShoppingBasket basket) {
        this.basket = basket;
    }

    // Toplam tutarı hesaplama
    public double calculateTotal() {
        if (basket.isEmpty){
            System.out.println("Your basket is empty.");
        }
        double total = 0;
        else{
            for (BasketItem item : basket.getItems().values()) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }

     // Fatura oluşturma
     public void generateBill() {
        System.out.println("\n--- BILL ---");
        System.out.println("Product Name\tQuantity\tPrice\tTotal");
        System.out.println("--------------------------------------------");

        double total = 0;
        for (BasketItem item : basket.getItems().values()) {
            double itemTotal = item.getQuantity() * item.getProduct().getPrice();
            System.out.printf(
                    item.getProduct().getName() + "  ",
                    item.getQuantity() + " ",
                    item.getProduct().getPrice()+ " ",
                    itemTotal);
            total += itemTotal;
        }
        System.out.printf("--------------------------------------------\nToplam: ", total);
    }

    // Ödeme 
    public abstract void processPayment();
}

// Kredi kartı ile ödeme 
class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardExpiry;

    public CreditCardPayment(ShoppingBasket basket, String cardNumber, String cardExpiry) {
        super(basket); //üst sınıftan constructor çağırmak için kullandım
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
    }

   
    public void processPayment() {
        double total = calculateTotal();
        System.out.printf("Paying by the credit card.\n" + "Total: " total);
    }
}

//PayPal'ın nasıl çalıştığını bilmiyorum. Bu yüzden EFT/Havale ile ödeme yöntemi ekledim.
class EFTPayment extends Payment{
    private String IBANnumber;

    public EFTPayment(ShoppingBasket basket, String IBANnumber){
        super(basket);
        this.IBANnumber = EFTPayment;
    }

    public void processPayment(){
        double total = calculateTotal();
        System.out.println("Paying by EFT/Transfer.\n" + "Total: " + total);
    }
}
