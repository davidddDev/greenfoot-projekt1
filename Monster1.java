import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster1 extends Actor
{
    /**
     * Act - do whatever the Monster1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        followPlayer();
        move(5);
        shot();
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
            getWorld().removeObject(this);
        }
    }
}
