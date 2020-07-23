package ir.ac.kntu.cs2d.model.armory.gun.pistol;

import ir.ac.kntu.cs2d.model.GameSide;
import ir.ac.kntu.cs2d.model.armory.gun.Gun;

public class PistolFactory {
    public static class GetPistols {
        public static Gun makeGlock() {
            return new Gun.Builder("Glock", 400, GameSide.TERROR).damage(21).
                    mts(300).str(2.3).magCap(20).isPistol(true).build();
        }

        public static Gun makeUSP() {
            return new Gun.Builder("USP", 500, GameSide.CT).damage(24).
                    mts(340).str(2.2).magCap(12).isPistol(true).build();
        }

        public static Gun makeDeagle() {
            return new Gun.Builder("Deagle", 650, GameSide.BOTH).damage(34).
                    mts(550).str(2.2).magCap(7).isPistol(true).build();
        }
    }
}
