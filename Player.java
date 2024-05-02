import greenfoot.*;

public class Player extends Actor {
    private int health;
    private int coins;
    private int weaponLevel;
    private int ammo = 5;

    private GreenfootImage imageBackView;
    private GreenfootImage imageRightBow;
    private GreenfootImage imageLeftBow;
    private GreenfootImage imageFrontBow;

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
        imageBackView = new GreenfootImage("player-backview.png");
        imageFrontBow = new GreenfootImage("player-bow-frontview.png");
        imageLeftBow = new GreenfootImage("player-bow-leftview.png");
        imageRightBow =new GreenfootImage("player-bow-rightview.png");
        setImage(imageFrontBow);
    }

    public void act() {
        moveAround();
        shoot();
        checkCollision();
        checkForUpgrade();
        moveToMouse();
        updateImageBasedOnRotation();
    }

    private void updateImageBasedOnRotation() {
        int rotation = getRotation();
        if (rotation >=0 && rotation <= 50) { 
            setImage(imageRightBow);
        } else if (rotation >=131 && rotation <=220) {
            setImage(imageLeftBow);
        } else if (rotation >=51 && rotation <= 130){
            setImage(imageFrontBow);
        } else if (rotation >=221 && rotation <=310) {
            setImage(imageBackView);
        } else {
            setImage(imageRightBow);
        }
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
            if (munition() == true) {
                Bullet bullet = new Bullet(getRotation(), weaponLevel);
                getWorld().addObject(bullet, getX(), getY());
                bullet.move(50);
                bullet.setRotation(getRotation());
                ammo--;
            }
        }
    }

    public boolean munition()
    {
        if(ammo > 0)
        {
            return true;
        }
        else 
        {
            return false;
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
