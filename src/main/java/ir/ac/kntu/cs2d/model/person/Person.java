package ir.ac.kntu.cs2d.model.person;

import ir.ac.kntu.cs2d.model.GameSide;

import java.io.Serializable;
import java.util.Objects;

public class Person extends PersonDetails implements Personality, Serializable, Cloneable {
    private long shooterTimer;
    private long reloadTimer;

    public Person(GameSide gameSide){
        super(gameSide);
        setShooterTimer(0);
        setReloadTimer(0);
    }

    // TODO
    @Override
    public void shooting(Person person, long shooterTimer) {
        if(shooterTimer - getReloadTimer() > getCurrGun().getSTR()) {
            if (shooterTimer - getShooterTimer() > getCurrGun().getMTS()) {
                setShooterTimer(shooterTimer);
                try {
                    person.getHit(getCurrGun().getDamage());
                } catch (Exception e) {}
                decreaseBullet(shooterTimer);
            }
        }
    }

    @Override
    public void getHit(int damage) {
        if (getHealth() < damage) {
            setHealth(0);
            return;
        }
        setHealth(getHealth() - damage);
    }

    @Override
    public void move(double angle) {
        getLoc().setLocation(getLoc().getX() + getSpeed()*Math.cos(angle),
                getLoc().getY() + getSpeed()*Math.sin(angle));
    }

    @Override
    public boolean isDead() {
        return getHealth() <= 0;
    }

    @Override
    public void changeGun(int choice) {
        switch (choice) {
            case 1:
                setCurrGun(getMainWeapon());
            case 2:
                setCurrGun(getPistol());
        }
    }

    @Override
    public void reload(long reloadTimer) {
        setReloadTimer(reloadTimer);
        getCurrGun().setMagState(getCurrGun().getMagCap());
    }

    private void decreaseBullet(long timer) {
        getCurrGun().setMagState(getCurrGun().getMagState() - 1);
        if(getCurrGun().getMagState() <= 0){
            reload(timer);
        }
    }

    public long getShooterTimer() {
        return shooterTimer;
    }

    public void setShooterTimer(long shooterTimer) {
        this.shooterTimer = shooterTimer;
    }

    public long getReloadTimer() {
        return reloadTimer;
    }

    public void setReloadTimer(long reloadTimer) {
        this.reloadTimer = reloadTimer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return shooterTimer == person.shooterTimer &&
                reloadTimer == person.reloadTimer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shooterTimer, reloadTimer);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
