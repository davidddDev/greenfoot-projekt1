import greenfoot.*;

public class Dungeon9 extends World
{
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon9(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty, initialHealth);
        addObject(player, 300, 75);
        addObject(new Monster2(2), 100, 500);
        addObject(new Monster1(1,1), 100, 400);
        addObject(new Monster2(2), 500, 500);
        addObject(new Monster1(1,1), 500, 400);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public Dungeon9(int initialHealth) {
        this(1, initialHealth);
    }

    public void nextDungeon()
    {
        if (killCounter >= 4)
        {
            Greenfoot.setWorld(new Dungeon10(1, player.getHealth()));
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
