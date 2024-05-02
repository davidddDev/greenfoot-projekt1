import greenfoot.*;

public class HealthBar extends Actor {
    private int health;

    public HealthBar(int initialHealth) {
        this.health = initialHealth;
        update();
    }

    public void update() {
        GreenfootImage image = new GreenfootImage(50 * 5, 50);
        GreenfootImage heart = new GreenfootImage("heart-removebg-preview.png");
        heart.scale(40, 40);
        for (int i = 0; i < health; i++) {
            image.drawImage(heart, 5+i * 40, 5);
        }
        setImage(image);
    }

    public void loseHealth() {
        if (health > 0) {
            health--;
            update();
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}