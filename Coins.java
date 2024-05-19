import greenfoot.*;  

public class Coins extends Actor {
    private int score;
    
    public Coins(int initialScore) {
        score = initialScore;
        setImage(new GreenfootImage("Coins: " + score, 30, new Color(230, 192, 159), new Color(0, 0, 0, 0)));
    }
    
    public void addCoins(int amount) {
        score += amount;
        setImage(new GreenfootImage("Coins: " + score, 30, new Color(230, 192, 159), new Color(0, 0, 0, 0)));
    }

    public void act() {
        setImage(new GreenfootImage("Coins: " + score, 30, new Color(230, 192, 159), new Color(0, 0, 0, 0)));
    }
}