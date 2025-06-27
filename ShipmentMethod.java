import java.util.Scanner;


public interface ShipmentMethod {
    double calculateShipping(double totalWeight);
}

class StandardShipment implements ShipmentMethod {
    
    public double calculateShipping(double totalWeight) {
        return totalWeight * 1.0;
    }
}

class ExpressShipment implements ShipmentMethod {
    
    public double calculateShipping(double totalWeight) {
        return totalWeight * 1.5;
    }
}

class SpeciaShipment implements ShipmentMethod{
    Scanner scanner = new Scanner(System.in);

    System.out.println("Please enter your note for special express: ")
    String usernote = scanner.nextline();

    System.out.println("###\n" + usernote + "###")

    public double calculateShipping(double totalWeight){
        
    }
}

public class Shipment {
    private String address;
    private ShipmentMethod shipmentMethod;

    public Shipment(String address, ShipmentMethod shipmentMethod) {
        this.address = address;
        this.shipmentMethod = shipmentMethod;
    }

    // Adresi ekrana verme
    public void displayShippingInfo() {
        System.out.println("Gönderim adresi: " + address);
    }

    // Gönderim maliyetini hesaplama
    public double shippingCost(double totalWeight) {
        return shipmentMethod.calculateShipping(totalWeight);
        System.out.println("Total cost: " + shipmentMethod.calculateShipping(totalWeight));
    }
}