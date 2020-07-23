package ir.ac.kntu.cs2d.model.armory.gun;

import ir.ac.kntu.cs2d.model.GameSide;

import java.io.Serializable;
import java.util.Objects;

public class Gun implements Cloneable, Serializable {
    private final String name;
    private final int price;
    private final int damage;
    private final int mts;
    private final double str;
    private final int magCap;
    private final GameSide gameSide;
    private final boolean isPistol;
    private int magState;

    public static class Builder {
        //Required params
        private final String name;
        private final int price;
        private final GameSide gameSide;

        //optional params
        private int damage = 20;
        private int mts = 120;
        private double str = 2.6;
        private int magCap = 25;
        private boolean isPistol = false;

        public Builder(String name, int price, GameSide gameSide) {
            this.name = name;
            this.price = price;
            this.gameSide = gameSide;
        }

        public Builder damage(int damage) {
            this.damage = damage;
            return this;
        }

        public Builder mts(int mts) {
            this.mts = mts;
            return this;
        }

        public Builder str(double str) {
            this.str = str;
            return this;
        }

        public Builder magCap(int magCap) {
            this.magCap = magCap;
            return this;
        }

        public Gun build(){
            return new Gun(this);
        }

        public Builder isPistol(boolean isPistol) {
            this.isPistol = isPistol;
            return this;
        }
    }

    private Gun(Builder builder){
        name = builder.name;
        price = builder.price;
        gameSide = builder.gameSide;
        damage = builder.damage;
        mts = builder.mts;
        str = builder.str;
        magCap = builder.magCap;
        isPistol = builder.isPistol;
        setMagState(getMagCap());
    }

    protected Gun(Gun gun) {
        name = gun.name;
        price = gun.price;
        gameSide = gun.gameSide;
        damage = gun.damage;
        mts = gun.mts;
        str = gun.str;
        magCap = gun.magCap;
        isPistol = gun.isPistol;
        setMagState(getMagCap());
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public GameSide getGameSide() {
        return gameSide;
    }

    public int getDamage() {
        return damage;
    }

    public int getMts() {
        return mts;
    }

    public double getStr() {
        return str;
    }

    public int getMagCap() {
        return magCap;
    }

    public boolean isPistol() {
        return isPistol;
    }

    public int getMagState() {
        return magState;
    }

    public void setMagState(int magState) {
        this.magState = magState;
    }

    @Override
    public String toString() {
        return "name: " + name +
                " price: " + price +
                " damage: " + damage +
                " MTS: " + mts +
                " STR: " + str +
                " magCap: " + magCap +
                " gameSide: " + gameSide +
                " isPistol: " + isPistol;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gun gun = (Gun) o;
        return price == gun.price &&
                damage == gun.damage &&
                mts == gun.mts &&
                Double.compare(gun.str, str) == 0 &&
                magCap == gun.magCap &&
                isPistol == gun.isPistol &&
                name.equals(gun.name) &&
                gameSide == gun.gameSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, damage, mts, str, magCap, gameSide, isPistol);
    }
}
