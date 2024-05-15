import greenfoot.*;

public class Dungeon5 extends World
{
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon5(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty);
        addObject(player, 100, 500);
        addObject(new Monster2(1,1), 100, 200);
        addObject(new Monster1(1,1), 550, 500);
        addObject(new Monster2(1,1), 500, 150);
        addObject(new Monster1(1,1), 300, 250);
    }

    public Dungeon5(int initialHealth) {
        this(1, initialHealth);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public void nextDungeon()
    {
        if (killCounter >= 4)
        {
            Greenfoot.setWorld(new Dungeon6(3));
            killCounter = 0;
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
