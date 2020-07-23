package ir.ac.kntu.cs2d.model.armory.gun;

import ir.ac.kntu.cs2d.model.NotEnoughMoneyException;
import ir.ac.kntu.cs2d.model.armory.Vest;
import ir.ac.kntu.cs2d.model.person.Person;

public class BuyVest extends Vest implements BuyItem {
    @Override
    public void buy(Person person) throws NotEnoughMoneyException {
        if(person.getMoney() < super.getPrice()){
            throw new NotEnoughMoneyException("Not enough money for vest");
        }

        person.setMoney(person.getMoney() - super.getPrice());
        person.setHealth(100 + super.getHealth());
    }
}
