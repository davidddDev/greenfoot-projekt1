import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player() 
    {
        
    }
    public void act()
    {
        pohyb();
    }
    public void pohyb()
    {
        int posunX = 0, posunY = 0;
        if (Greenfoot.isKeyDown("left"))  posunX -= 3; 
        if (Greenfoot.isKeyDown("right")) posunX += 3; 
        if (Greenfoot.isKeyDown("up"))    posunY -= 3;
        if (Greenfoot.isKeyDown("down"))  posunY += 3;
        this.setLocation(this.getX()+posunX, this.getY()+posunY);
    }
    public void strela()
    {
        String klavesa = Greenfoot.getKey();
        if ("space".equals(klavesa))
        {
            this.getWorld().addObject(new Bullet(), this.getX(), this.getY());
        }
    }
}
