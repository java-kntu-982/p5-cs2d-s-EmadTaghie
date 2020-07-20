package ir.ac.kntu.cs2d.model.gun;

public class Gun {
    private final String name;
    private final int price;
    private final int damage;
    private final int MTS;
    private final double STR;
    private final int magCap;
    private final GameSide gameSide;
    private final boolean isPistol;

    public static class Builder {
        //Required params
        private final String name;
        private final int price;
        private final GameSide gameSide;

        //optional params
        private int damage = 20;
        private int MTS = 120;
        private double STR = 2.6;
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

        public Builder MTS(int MTS) {
            this.MTS = MTS;
            return this;
        }

        public Builder STR(double STR) {
            this.STR = STR;
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
        MTS = builder.MTS;
        STR = builder.STR;
        magCap = builder.magCap;
        isPistol = builder.isPistol;
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

    public int getMTS() {
        return MTS;
    }

    public double getSTR() {
        return STR;
    }

    public int getMagCap() {
        return magCap;
    }

    public boolean isPistol() {
        return isPistol;
    }

    @Override
    public String toString() {
        return "name: " + name +
                " price: " + price +
                " damage: " + damage +
                " MTS: " + MTS +
                " STR: " + STR +
                " magCap: " + magCap +
                " gameSide: " + gameSide +
                " isPistol: " + isPistol;
    }
}
