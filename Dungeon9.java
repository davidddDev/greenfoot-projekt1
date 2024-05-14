import greenfoot.*;

public class Dungeon9 extends World
{
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon9(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty);
        addObject(player, getHeight()/2, getWidth()/2);
        addObject(new Monster2(2,1), 100, 200);
        addObject(new Monster1(1,2), 550, 500);
        addObject(new Monster2(2,1), 500, 150);
        addObject(new Monster1(1,2), 100, 550);
    }

    public Dungeon9(int initialHealth) {
        this(1, initialHealth);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public void nextDungeon()
    {
        if (killCounter >= 16)
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
