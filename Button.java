import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String text;
    public Button(String text)
    {
        this.text = text;
        updateImage();
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (text.equals("Easy"))
            {
                Greenfoot.setWorld(new GameWorld(5)); // Spustí hru s 5 životy pro lehkou obtížnost
            }
            else if (text.equals("Medium"))
            {
                Greenfoot.setWorld(new GameWorld(3)); // Spustí hru s 3 životy pro střední obtížnost
            }
            else if (text.equals("Hard"))
            {
                Greenfoot.setWorld(new GameWorld(1)); // Spustí hru s 1 životem pro těžkou obtížnos
            }
        }
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(text, 24, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
