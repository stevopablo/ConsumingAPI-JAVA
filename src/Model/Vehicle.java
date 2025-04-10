package Model;

public class Vehicle {
    private String model;
    private String brand;
    private String year;
    private String price;

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getYear() {
        return year;
    }

    public String getPrice() {
        return price;
    }

    public Vehicle(String model, String brand, String year, String price) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
}
