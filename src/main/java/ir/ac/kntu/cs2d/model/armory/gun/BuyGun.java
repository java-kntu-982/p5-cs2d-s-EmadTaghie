package ir.ac.kntu.cs2d.model.armory.gun;

import ir.ac.kntu.cs2d.model.NotEnoughMoneyException;
import ir.ac.kntu.cs2d.model.TypeException;
import ir.ac.kntu.cs2d.model.person.Person;

public class BuyGun extends Gun implements BuyItem {
    public BuyGun(Gun gun) {
        super(gun);
    }
    @Override
    public void buy(Person person) throws NotEnoughMoneyException, TypeException{
        if(person.getMoney() < getPrice()) {
            throw new NotEnoughMoneyException("Not Enough Money for buying " + getName());
        }
        if(!person.getGameSide().equals(getGameSide())){
            throw new TypeException("Change person side or gun");
        }
        person.setMoney(person.getMoney() - getPrice());
        if (isPistol()) {
            try {
                person.setPistol((Gun)super.clone());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } else {
            try {
                person.setMainWeapon((Gun)super.clone());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
