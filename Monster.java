import greenfoot.*;

public class Monster extends Actor {
    private int health = 5;
    
    public void act() {
        moveTowardsPlayer();
    }
    
    protected void moveTowardsPlayer() {
        Actor player = getWorld().getObjects(Player.class).get(0);
        turnTowards(player.getX(), player.getY());
        move(1);
    }
    
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            getWorld().removeObject(this);
        }
    }
}
