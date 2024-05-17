import greenfoot.*;

public class Dungeon3 extends World {
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon3(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty, initialHealth);
        addObject(player, 300, 525);
        addObject(new Monster2(2), 100, 100);
        addObject(new Monster1(1,1), 100, 200);
        addObject(new Monster2(2), 500, 100);
        addObject(new Monster1(1,1), 500, 200);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public Dungeon3(int initialHealth) {
        this(1, initialHealth);
        
    }

    public void nextDungeon()
    {
        if (killCounter >= 4)
        {
            Greenfoot.setWorld(new Dungeon4(1, player.getHealth()));
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
