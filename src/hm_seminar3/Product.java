package hm_seminar3;

import hm_seminar3.exceptions.NotEnoughProductException;

public class Product {

    private String name;
    private int availableQuantity;
    private double price;

    public Product(String name, int availableQuantity, double price) {
        this.name = name;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    public int bye(int quantity) throws NotEnoughProductException {
        if (availableQuantity >= quantity) {
            availableQuantity -= quantity;
        } else {
            throw new NotEnoughProductException("Нет такого количества");
        }
        return availableQuantity;
    }

    @Override
    public String toString() {
        return String.format("name: %s, availableQuantity: %d, price: %f", name, availableQuantity, price);
    }
}
