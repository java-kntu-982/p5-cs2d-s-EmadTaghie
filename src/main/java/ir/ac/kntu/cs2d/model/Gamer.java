package ir.ac.kntu.cs2d.model;

import ir.ac.kntu.cs2d.model.person.Person;

import java.io.Serializable;

public class Gamer implements Cloneable, Serializable {
    private Person agent;
    private final int id;

    public Gamer(int id) {
        setAgent(null);
        this.id = id;
    }

    public void setAgent(Person agent) {
        this.agent = agent;
        System.out.println(this.agent);
        System.out.println("agent added");
    }

    public Person getAgent() {
        try {
            return (Person) agent.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
