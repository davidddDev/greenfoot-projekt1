import greenfoot.*;

public class Dungeon10 extends World
{
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon10(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty, initialHealth);
        addObject(player, getHeight()/2, getWidth()/2);
        addObject(new Boss(), 100, 200);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public Dungeon10(int initialHealth) {
        this(1, initialHealth);
        
    }

    public void nextDungeon()
    {
        if (killCounter == 1)
        {
            showText("Zvítězil jsi!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
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
