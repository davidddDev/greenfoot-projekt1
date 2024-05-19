import greenfoot.*;  

public class Coins extends Actor {
    private int score;
    
    public Coins(int initialScore) {
        score = initialScore;
        setImage(new GreenfootImage("Coins: " + score, 30, Color.BLACK, Color.WHITE));
    }
    
    public void addCoins(int amount) {
        score += amount;
        setImage(new GreenfootImage("Coins: " + score, 30, Color.BLACK, Color.WHITE));
    }

    public void act() {
        setImage(new GreenfootImage("Coins: " + score, 30, Color.BLACK, Color.WHITE));
    }
}