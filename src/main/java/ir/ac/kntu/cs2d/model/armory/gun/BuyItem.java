package ir.ac.kntu.cs2d.model.armory.gun;

import ir.ac.kntu.cs2d.model.NotEnoughMoneyException;
import ir.ac.kntu.cs2d.model.TypeException;
import ir.ac.kntu.cs2d.model.person.Person;

public interface BuyItem {
    void buy(Person person) throws NotEnoughMoneyException, TypeException;
}
