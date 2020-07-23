package ir.ac.kntu.cs2d.model.person;

import ir.ac.kntu.cs2d.model.GameSide;
import ir.ac.kntu.cs2d.model.armory.gun.Gun;
import ir.ac.kntu.cs2d.model.armory.gun.pistol.PistolFactory;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Objects;

public abstract class PersonDetails implements Serializable, Cloneable {
    private Gun pistol;
    private Gun mainWeapon;
    private Gun currGun;

    private int health;
    private int money;
    private Point2D loc;
    private GameSide gameSide;
    private int deathPoint;
    private int killPoint;
    private final double speed;

    public PersonDetails(GameSide gameSide) {
        setGameSide(gameSide);
        makePersonDefault(new Point2D.Double(0, 0));
        speed = 5;
    }

    public void makePersonDefault(Point2D loc){
        restorePerson(loc);
        setKillPoint(0);
        setDeathPoint(0);
        setMoney(800);
    }

    public void restorePerson(Point2D loc){
        makeDefaultGuns();
        setHealth(100);
        setLoc(loc);
    }

    public void makeDefaultGuns(){
        if (getGameSide().equals(GameSide.CT)) {
            setPistol(PistolFactory.GetPistols.makeUSP());
        } else {
            setPistol(PistolFactory.GetPistols.makeGlock());
        }
        setMainWeapon(null);
        setCurrGun(getPistol());
    }

    public Gun getPistol() {
        return pistol;
    }

    public void setPistol(Gun pistol) {
        this.pistol = pistol;
    }

    public Gun getMainWeapon() {
        return mainWeapon;
    }

    public void setMainWeapon(Gun mainWeapon) {
        this.mainWeapon = mainWeapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Point2D getLoc() {
        return loc;
    }

    public void setLoc(Point2D loc) {
        this.loc = loc;
    }

    public GameSide getGameSide() {
        return gameSide;
    }

    public void setGameSide(GameSide gameSide) {
        this.gameSide = gameSide;
    }

    public int getDeathPoint() {
        return deathPoint;
    }

    public void setDeathPoint(int deathPoint) {
        this.deathPoint = deathPoint;
    }

    public int getKillPoint() {
        return killPoint;
    }

    public void setKillPoint(int killPoint) {
        this.killPoint = killPoint;
    }

    public double getSpeed() {
        return speed;
    }

    public Gun getCurrGun() {
        return currGun;
    }

    public void setCurrGun(Gun currGun) {
        this.currGun = currGun;
    }

    @Override
    public String toString() {
        return "pistol: " + pistol +
                ", mainWeapon: " + mainWeapon +
                ", currGun: " + currGun +
                ", Health: " + health +
                ", money: " + money +
                ", loc: " + loc +
                ", gameSide: " + gameSide +
                ", DeathPoint: " + deathPoint +
                ", killPoint: " + killPoint +
                ", speed: " + speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonDetails that = (PersonDetails) o;
        return health == that.health &&
                money == that.money &&
                deathPoint == that.deathPoint &&
                killPoint == that.killPoint &&
                Double.compare(that.speed, speed) == 0 &&
                Objects.equals(pistol, that.pistol) &&
                Objects.equals(mainWeapon, that.mainWeapon) &&
                Objects.equals(currGun, that.currGun) &&
                Objects.equals(loc, that.loc) &&
                gameSide == that.gameSide;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pistol, mainWeapon, currGun, health, money, loc, gameSide, deathPoint, killPoint, speed);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
