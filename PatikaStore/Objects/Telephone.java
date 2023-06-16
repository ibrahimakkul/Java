package Objects;

import Product.Product;

public class Telephone extends Product<Telephone> {
    private int Mah;
    private String color;

    public Telephone(String brand, String description, double unitPrice, double discount, int stock, int memory, double size, int Mah, int ram, String color) {

        super(brand, description, unitPrice, discount, stock, memory, size, ram);
        this.Mah = Mah;
        this.color = color;

    }

    public int getMah() {
        return Mah;
    }

    public void setMah(int mah) {
        Mah = mah;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
