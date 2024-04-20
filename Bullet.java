import greenfoot.*;

public class Bullet extends Actor {
    private int speed = 5;
    private int damage;
    
    public Bullet(int rotation, int weaponLevel) {
        setRotation(rotation);
        this.damage = 2 * weaponLevel; // Damage increases with weapon level
    }
    
    public void act() {
        move(speed);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        } else {
            checkHit();
        }
    }
    
    private void checkHit() {
        Monster hit = (Monster)getOneIntersectingObject(Monster.class);
        if (hit != null) {
            hit.takeDamage(damage);
            getWorld().removeObject(this);
        }
    }
}