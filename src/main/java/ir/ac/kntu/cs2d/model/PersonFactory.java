package ir.ac.kntu.cs2d.model;

public class PersonFactory {
    public static class MakePerson {
        public static Person makeCT(){
            return new Person(GameSide.CS);
        }

        public static Person makeTerror(){
            return new Person(GameSide.TERROR);
        }
    }
}
