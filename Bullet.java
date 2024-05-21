import greenfoot.*;
public class Bullet extends Actor {
    private int speed = 5;
    private int damage;
    
    public Bullet(int rotation, int weaponLevel) {
        setRotation(rotation);
        this.damage = 2 * weaponLevel; 
    }
    
    public void act() {
        move(speed);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
