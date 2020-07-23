package ir.ac.kntu.cs2d.model.person;

import ir.ac.kntu.cs2d.model.GameSide;

public class PersonFactory {
    public static class MakePerson {
        public static Person makeCT(){
            return new Person(GameSide.CT);
        }

        public static Person makeTerror(){
            return new Person(GameSide.TERROR);
        }
    }
}
