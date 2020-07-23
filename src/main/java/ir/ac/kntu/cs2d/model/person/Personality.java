package ir.ac.kntu.cs2d.model.person;

public interface Personality {
    void shooting(Person person, long shooterTimer);
    void getHit(int damage);
    void move(double angle);
    boolean isDead();
    void changeGun(int choice);
    void reload(long reloadTimer);
}
