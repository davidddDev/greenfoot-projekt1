import greenfoot.*;

public class Dungeon3 extends World {
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon3(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty, initialHealth);
        addObject(player, 100, 500);
        addObject(new Monster2(0,1), 100, 200);
        addObject(new Monster1(1,1), 550, 500);
        addObject(new Monster2(0,1), 500, 150);
        addObject(new Monster1(1,1), 300, 250);
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
