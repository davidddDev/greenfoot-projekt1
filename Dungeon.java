import greenfoot.*;

public class Dungeon extends World {
    private Coins coins;
    private Player player;  
    private HealthBar healthBar;
    public static int killCounter = 0;
    
    public Dungeon(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty, initialHealth);
        coins = new Coins(Coins.score); 
        addObject(player, 300, 75);
        addObject(new Monster2(2), 100, 500);
        addObject(new Monster1(1,1), 100, 400);
        addObject(new Monster2(2), 500, 500);
        addObject(new Monster1(1,1), 500, 400);
        addObject(new Mine(), 300, 200);
        addObject(new Mine(), 200, 300);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
        addObject(coins, 75, 75);
    }
    
    public Dungeon(int initialHealth) {
        this(1, initialHealth);
    }
    
    public Coins getCoins() {
        return coins;
    }
    
    public void nextDungeon() {
        if (killCounter >= 4) {
            Greenfoot.setWorld(new Dungeon2(1, player.getHealth()));
            killCounter = 0;
        }
    }
    
    public void act() {
        nextDungeon();
    }

    public Player getPlayer() {
        return player;
    }
    
    public void loseHealth() {
        healthBar.loseHealth();
    }
}