import greenfoot.*;

public class Dungeon extends World {
    private Player player;
    private HealthBar healthBar;
    public Dungeon(int difficulty, int initialHealth) {
        super(600, 600, 1);
        player = new Player(difficulty);
        addObject(player, getHeight()/2, getWidth()/2);
    }

    public Dungeon(int initialHealth) {
        this(1, initialHealth);
        healthBar = new HealthBar(initialHealth);
        addObject(healthBar, 125, 30);
    }

    public void act() {
        
        }

    public Player getPlayer() {
        return player;
    }
}