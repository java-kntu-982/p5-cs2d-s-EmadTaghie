package ir.ac.kntu.cs2d.model.armory.gun;

import ir.ac.kntu.cs2d.model.armory.gun.mainWeapon.MainWeaponFactory;
import ir.ac.kntu.cs2d.model.armory.gun.pistol.PistolFactory;

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

        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.famas()));
        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.galil()));
        mainWeapons.add(new BuyGun(MainWeaponFactory.Weapons.m4a1()));
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
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
}
