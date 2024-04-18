import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 600, 1);
        generateWalls();
    }
    private void generateWalls() 
    {
        for (int x = 0; x < 600 / 20; x++) 
        {
            addObject(new Wall(), x * 20 + 20 / 2, 20 / 2);
            addObject(new Wall(), x * 20 + 20 / 2, 600 - 20 / 2);
        }
        for (int y = 1; y < 600 / 20 - 1; y++) 
        {
            addObject(new Wall(), 20 / 2, y * 20 + 20 / 2);
            addObject(new Wall(), 600 - 20 / 2, y * 20 + 20 / 2);
        }   
    }
}

