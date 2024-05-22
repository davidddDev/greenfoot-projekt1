import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MonsterBullet extends Actor {
    public void act() {
        move(3);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
