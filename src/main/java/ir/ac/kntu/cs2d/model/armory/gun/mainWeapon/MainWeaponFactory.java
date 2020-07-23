package ir.ac.kntu.cs2d.model.armory.gun.mainWeapon;

import ir.ac.kntu.cs2d.model.GameSide;
import ir.ac.kntu.cs2d.model.armory.gun.Gun;

public class MainWeaponFactory {
    public static class Weapons {
        public static Gun makeMP5() {
            return new Gun.Builder("MP5", 1500, GameSide.BOTH).damage(13).mts(120).str(3.1).magCap(30).build();
        }

        public static Gun makeP90() {
            return new Gun.Builder("P90", 2350, GameSide.BOTH).damage(11).mts(80).str(3.3).magCap(50).build();
        }

        public static Gun makeAK47() {
            return new Gun.Builder("AK47", 2500, GameSide.TERROR).damage(22).mts(120).str(2.5).magCap(30).build();
        }

        public static Gun galil() {
            return new Gun.Builder("Galil", 2000, GameSide.TERROR).damage(13).mts(120).str(2.6).magCap(35).build();
        }

        public static Gun m4a1() {
            return new Gun.Builder("M4A1", 3100, GameSide.CT).damage(22).mts(120).str(3.1).magCap(30).build();
        }

        public static Gun famas() {
            return new Gun.Builder("Famas", 2250, GameSide.CT).damage(14).mts(120).str(3.3).magCap(25).build();
        }
    }
}
