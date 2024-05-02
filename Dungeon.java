import greenfoot.*;

public class Dungeon extends World {
    private int time;
    private int killCounter;
    private Player player;
    private HealthBar healthBar;
    public Dungeon(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty);
        addObject(player, getHeight()/2, getWidth()/2);
        addObject(new Monster(), 500, 600);
        addObject(new Monster(), 100, 300);
        addObject(new Monster(), 50, 50);
    }

    public Dungeon(int initialHealth) {
        this(1, initialHealth);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public void act() {
        time++;
        spawnEnemies();
        complete();
        }
        
    public void spawnEnemies()
    {
        if (time == 300)
        {
            addObject(new Monster(), Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(600));
            time = 100;
        }
    }
    
    public void complete()
    {
        if (killCounter == 5)
        {
            Greenfoot.setWorld(new Dungeon2());
        }
    }

    public Player getPlayer() {
        return player;
    }
}