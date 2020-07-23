package ir.ac.kntu.cs2d.model.armory.gun;

import ir.ac.kntu.cs2d.model.GameSide;
import ir.ac.kntu.cs2d.model.NotEnoughMoneyException;
import ir.ac.kntu.cs2d.model.TypeException;
import ir.ac.kntu.cs2d.model.armory.gun.mainWeapon.MainWeaponFactory;
import ir.ac.kntu.cs2d.model.armory.gun.pistol.PistolFactory;
import ir.ac.kntu.cs2d.model.person.Person;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    final private List<BuyGun> pistols;
    final private List<BuyGun> mainWeapons;
    final private BuyVest vest;

    public ItemList(){
        pistols = new ArrayList<>();
        mainWeapons = new ArrayList<>();
        pistols.add(new BuyGun(PistolFactory.GetPistols.makeUSP()));
        pistols.add(new BuyGun(PistolFactory.GetPistols.makeGlock()));
        pistols.add(new BuyGun(PistolFactory.GetPistols.makeDeagle()));

        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.Famas()));
        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.Galil()));
        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.M4A1()));
        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.makeAK47()));
        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.makeMP5()));
        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.makeP90()));

        vest = new BuyVest();
    }

    public List<BuyGun> getPistolList(){
        return new ArrayList<>(pistols);
    }

    public List<Gun> getMainWeaponList(){
        return new ArrayList<>(mainWeapons);
    }

    public BuyVest getVest() {
        try {
            return (BuyVest) vest.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
}
