import greenfoot.*;

public class Player extends Actor {
    public int health;
    private int coins;
    private int weaponLevel;
    private int ammo = 5;
    private int count = 0;
    // obrázky
    private GreenfootImage imageBackView;
    private GreenfootImage imageRightBow;
    private GreenfootImage imageLeftBow;
    private GreenfootImage imageFrontBow;

    private GreenfootImage imageFrontGunOne;
    private GreenfootImage imageRightGunOne;
    private GreenfootImage imageLeftGunOne;

    private GreenfootImage imageFrontGunTwo;
    private GreenfootImage imageRightGunTwo;
    private GreenfootImage imageLeftGunTwo;
    // obrázky 

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

        // obrázky
        setImage(imageFrontBow);
        imageBackView = new GreenfootImage("player-backview.png");
        imageFrontBow = new GreenfootImage("player-bow-frontview.png");
        imageLeftBow = new GreenfootImage("player-bow-leftview.png");
        imageRightBow =new GreenfootImage("player-bow-rightview.png");

        imageFrontGunOne = new GreenfootImage("player-gun-frontview.png");
        imageRightGunOne = new GreenfootImage("player-gun-rightview.png");
        imageLeftGunOne = new GreenfootImage("player-gun-leftview.png");

        imageFrontGunTwo = new GreenfootImage("player-gun2-frontview.png");
        imageRightGunTwo = new GreenfootImage("player-gun2-rightview.png");
        imageLeftGunTwo = new GreenfootImage("player-gun2-leftview.png");
        //obrázky 

    }

    public void act() {
        moveAround();
        shoot();
        checkForUpgrade();
        moveToMouse();
        updateImageBasedOnRotation();
        count++;
        if (count >= 20) {
            checkCollision();
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
            ((Dungeon)getWorld()).loseHealth();
        }
        
        Actor monster1 = getOneIntersectingObject(Monster1.class);
        if (monster1 != null) {
            loseHealth();
            getWorld().removeObject(monster1);
            ((Dungeon)getWorld()).loseHealth();
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
        if (Greenfoot.isKeyDown("u") && coins >= 10) { // zmáčknout u na up grade zbraně
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

    private void updateImageBasedOnRotation() { // obrázky postavy (měnění podle úhlu pohledu) 
        int rotation = getRotation();
        if (weaponLevel == 1)
        {
            if (rotation >=0 && rotation <= 50) { 
                setImage(imageRightBow);
            } else if (rotation >=131 && rotation <=220) {
                setImage(imageLeftBow);
            } else if (rotation >=51 && rotation <= 130) {
                setImage(imageFrontBow);
            } else if (rotation >=221 && rotation <=310) {
                setImage(imageBackView);
            } else {
                setImage(imageRightBow);
            }

        } else if (weaponLevel == 2) {
            if (rotation >=0 && rotation <= 50) { 
                setImage(imageRightGunOne);
            } else if (rotation >=131 && rotation <=220) {
                setImage(imageLeftGunOne);
            } else if (rotation >=51 && rotation <= 130) {
                setImage(imageFrontGunOne);
            } else if (rotation >=221 && rotation <=310) {
                setImage(imageBackView);
            } else {
                setImage(imageRightGunOne);
            }

        } else if (weaponLevel == 3) {
            if (rotation >=0 && rotation <= 50) {
                setImage(imageRightGunTwo);
            } else if (rotation >= 131 && rotation <=220) {
                setImage(imageLeftGunTwo);
            } else if (rotation >=51 && rotation <= 130) {
                setImage(imageFrontGunTwo);
            } else if (rotation >=221 && rotation <=310) {
                setImage(imageBackView);
            } else {
                setImage(imageRightGunTwo);
            }
        }
    }
}
