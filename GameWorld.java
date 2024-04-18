import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private int numLives; // Počet životů
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld(int numLives)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        this.numLives = numLives;
        prepare();
    }

    private void prepare()
    {
        // něco 
        Player player = new Player();
        player.setLives(numLives);
        
        addObject(player, getWidth() / 2, getHeight() / 2);
    }
}
