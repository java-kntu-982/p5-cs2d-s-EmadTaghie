package ir.ac.kntu.cs2d.model;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String msg){
        super(msg);
    }
}
