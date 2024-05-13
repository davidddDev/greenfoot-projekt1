import greenfoot.*;

/**
 * Write a description of class Dungeon6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon6 extends World
{
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon6(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty);
        addObject(player, getHeight()/2, getWidth()/2);
        addObject(new Monster2(2,1), 100, 200);
        addObject(new Monster1(1,2), 550, 500);
        addObject(new Monster2(2,1), 500, 150);
        addObject(new Monster1(1,2), 100, 550);
    }

    public Dungeon6(int initialHealth) {
        this(1, initialHealth);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public void nextDungeon()
    {
        if (killCounter >= 10)
        {
            Greenfoot.setWorld(new Dungeon4(3));
        }
    }

    public void act() {
        nextDungeon();
    }

    public Player getPlayer() {
        return player;
    }
    
    public void loseHealth()
    {
        healthBar.loseHealth();
    }
}
