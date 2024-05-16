import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MonsterBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MonsterBullet extends Actor
{
    /**
     * Act - do whatever the MonsterBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(2);
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
