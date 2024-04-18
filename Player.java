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
    private int lives = 3;
    public void act()
    {
        movement();
        shooting();
    }
     public void setLives(int numLives) {
        lives = numLives; // Nastaví počet životů
    }
    public void movement()
    {
        int moveX = 0, moveY = 0;
        if (Greenfoot.isKeyDown("A"))  moveX -= 5; 
        if (Greenfoot.isKeyDown("D")) moveX += 5; 
        if (Greenfoot.isKeyDown("W"))    moveY -= 5;
        if (Greenfoot.isKeyDown("S"))  moveY += 5;
        this.setLocation(this.getX()+moveX, this.getY()+moveY);
        
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null)
        {
            int miX = mi.getX();
            int miY = mi.getY();
            turnTowards(miX, miY);
        }
    }
    public void shooting()
    {
        if (Greenfoot.mouseClicked(null))
        {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
        }
    }
}
