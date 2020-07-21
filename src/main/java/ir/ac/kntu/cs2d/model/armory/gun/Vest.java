package ir.ac.kntu.cs2d.model.armory.gun;

public class Vest implements Cloneable {
    private double health;
    private int price;

    public Vest(){
        setHealth(80);
        setPrice(1000);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
