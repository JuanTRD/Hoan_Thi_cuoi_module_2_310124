package Module;

public class Product {
    protected int id;
    protected String name;
    protected int price;
    protected int quantity;
    protected String description;

    public Product(int id, String name, int price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }



    @Override
    public String toString() {
        return id +
                "," + name +
                "," + price +
                "," + quantity +
                "," + description;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public int getPrice() {
        return price;
    }






}
