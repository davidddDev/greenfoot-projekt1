import greenfoot.*;

public class Dungeon4 extends World {
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    private Coins coins;

    public Dungeon4(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty, initialHealth);
        coins = new Coins(Coins.score); 
        
        addObject(player, 525, 300);
        addObject(new Monster2(3), 100, 100);
        addObject(new Monster1(1,2), 200, 100);
        addObject(new Monster2(3), 100, 500);
        addObject(new Monster1(1,2), 200, 500);
        addObject(new Mine(), 300, 400);
        addObject(new Mine(), 300, 200);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
        addObject(coins, 75, 75);
    }

    public Dungeon4(int initialHealth) {
        this(1, initialHealth);
    }

    public void nextDungeon() {
        if (killCounter >= 4) {
            Greenfoot.setWorld(new Dungeon5(1, player.getHealth()));
            killCounter = 0;
        }
    }
    
    public Coins getCoins() {
        return coins;
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
