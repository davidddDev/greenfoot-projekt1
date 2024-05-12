import greenfoot.*;

public class Dungeon extends World {

    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty);
        addObject(player, getHeight()/2, getWidth()/2);
        addObject(new Monster1(1,2), 100, 200);
        addObject(new Monster1(1,2), 500, 500);
    }

    public Dungeon(int initialHealth) {
        this(1, initialHealth);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public void nextDungeon()
    {
        if (killCounter >= 4)
        {
            Greenfoot.setWorld(new Dungeon2());
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