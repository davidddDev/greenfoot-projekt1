import greenfoot.*;

public class Dungeon2 extends World {
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon2(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty, initialHealth);
        addObject(player, 75, 300);
        addObject(new Monster2(2), 500, 100);
        addObject(new Monster1(1,1), 400, 100);
        addObject(new Monster2(2), 500, 500);
        addObject(new Monster1(1,1), 400, 500);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public Dungeon2(int initialHealth) {
        this(1, initialHealth);
    }

    public void nextDungeon()
    {
        if (killCounter >= 4)
        {
            Greenfoot.setWorld(new Dungeon3(1, player.getHealth()));
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
