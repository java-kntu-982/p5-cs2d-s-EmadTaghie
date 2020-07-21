package ir.ac.kntu.cs2d.model;

import ir.ac.kntu.cs2d.model.armory.gun.Gun;
import ir.ac.kntu.cs2d.model.armory.gun.pistol.PistolFactory;

import java.awt.geom.Point2D;

public class Person {
    Gun pistol;
    Gun mainWeapon;

    int Health;
    int money;
    Point2D loc;
    int pistolCapacity;
    int mainWeaponCapacity;
    GameSide gameSide;
    int DeathPoint;
    int killPoint;

    public Person(GameSide gameSide) {
        setGameSide(gameSide);
        makePersonDefault(new Point2D.Double(0, 0));
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
        if (getGameSide().equals(GameSide.CS)) {
            setPistol(PistolFactory.GetPistols.makeUSP());
        } else {
            setPistol(PistolFactory.GetPistols.makeGlock());
        }
        setMainWeapon(null);
        setPistolCapacity(getPistol().getMagCap());
        try {
            setMainWeaponCapacity(getMainWeapon().getMagCap());
        }
        catch (NullPointerException e){
            setMainWeaponCapacity(0);
        }

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
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
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

    public int getPistolCapacity() {
        return pistolCapacity;
    }

    public void setPistolCapacity(int pistolCapacity) {
        this.pistolCapacity = pistolCapacity;
    }

    public int getMainWeaponCapacity() {
        return mainWeaponCapacity;
    }

    public void setMainWeaponCapacity(int mainWeaponCapacity) {
        this.mainWeaponCapacity = mainWeaponCapacity;
    }

    public GameSide getGameSide() {
        return gameSide;
    }

    public void setGameSide(GameSide gameSide) {
        this.gameSide = gameSide;
    }

    public int getDeathPoint() {
        return DeathPoint;
    }

    public void setDeathPoint(int deathPoint) {
        DeathPoint = deathPoint;
    }

    public int getKillPoint() {
        return killPoint;
    }

    public void setKillPoint(int killPoint) {
        this.killPoint = killPoint;
    }
}
