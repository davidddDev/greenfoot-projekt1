import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenuWorld extends World
{
    /**
     * Constructor for objects of class MainMenuWorld.
     * 
     */
    public MainMenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        prepare();
    }

    private void prepare()
    {
        Button easyButton = new Button("Easy");
        addObject(easyButton, 100, 100);

        Button mediumButton = new Button("Medium");
        addObject(mediumButton, 300, 100);

        Button hardButton = new Button("Hard");
        addObject(hardButton, 500, 100);

    }
}

