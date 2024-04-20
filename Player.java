import greenfoot.*;

public class Player extends Actor {
    private int health;
    private int coins;
    private int weaponLevel;

    public Player(int difficulty) {
        if (difficulty == 1) {
            this.health = 5;
        } else if (difficulty == 2) {
            this.health = 3;
        } else {
            this.health = 1;
        }
        this.weaponLevel = 1;
        this.coins = 0;
    }

    public void act() {
        moveAround();
        shoot();
        checkCollision();
        checkForUpgrade();
        moveToMouse();
    }

    private void moveAround() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 2);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 2);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 2, getY());
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 2, getY());
        }
    }

    private void moveToMouse() {
        MouseInfo mouseinfo = Greenfoot.getMouseInfo(); 
        if (mouseinfo != null ) {
            int x = mouseinfo.getX();
            int y = mouseinfo.getY();
            turnTowards(x, y);
        }
    }

    private void shoot() {
        if (Greenfoot.mouseClicked(null)) {
            Bullet bullet = new Bullet(getRotation(), weaponLevel);
            getWorld().addObject(bullet, getX(), getY());
            bullet.move(50);
        }
    }

    private void checkCollision() {
        Actor monster = getOneIntersectingObject(Monster.class);
        if (monster != null) {
            loseHealth();
            getWorld().removeObject(monster);
        }
    }

    public void loseHealth() {
        health--;
        if (health <= 0) {
            die();
        }
    }

    private void die() {
        Greenfoot.stop();
    }

    private void checkForUpgrade() {
        if (Greenfoot.isKeyDown("u") && coins >= 10) { // Press 'U' to upgrade
        weaponLevel++;
        coins -= 10;
        }
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public int getHealth() {
        return health;
    }
}

