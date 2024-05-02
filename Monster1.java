import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster1 extends Actor
{
    int speed;
    int lives;
    /**
     * Act - do whatever the Monster1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        followPlayer();
        move(speed);
        shot();
        health();
    }
    public Monster1(int speed, int lives)
    {
        this.speed = speed; // Nastaví rychlost pohybu
        this.lives = lives; // Nastaví počet životů
    }
    private void followPlayer()
    {
        int distance = 1000;
        Actor closest = null;
         
        if(!getObjectsInRange(distance, Player.class).isEmpty())
        {
            for (Object obj: getObjectsInRange(distance, Player.class))
            {
                Actor player = (Actor) obj;
                int playerDistance = (int) Math.hypot(player.getX() - getX(), player.getY() - getY());
                if (closest == null || playerDistance< distance)
                {
                    closest = player;
                    distance = playerDistance;
                }
            }
            turnTowards(closest.getX(),closest.getY());
        }  
    }
    public void shot()
    {
        Bullet intersectingBullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if (intersectingBullet != null)
        {
            lives--;
            removeTouching(Bullet.class);
        }
    }
    public void health()
    {
        if(lives == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
