import greenfoot.*;

public class Dungeon10 extends World
{
    private Player player;
    private HealthBar healthBar;
    public static int killCounter = 0;
    public Dungeon10(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty, initialHealth);
        addObject(player, 300, 75);
        addObject(new Boss(1,30), 300, 525);
        addObject(new Mine2(), 500, 100);
        addObject(new Mine2(), 100, 100);
        addObject(new Mine2(), 100, 500);
        addObject(new Mine2(), 500, 500);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public Dungeon10(int initialHealth) {
        this(1, initialHealth);
    }

    public void nextDungeon() {
        if (killCounter == 1) {
            showText("Zvítězil jsi!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
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
