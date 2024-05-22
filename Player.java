import greenfoot.*;

public class Player extends Actor {
    public int health;
    private int weaponLevel;
    private int ammo = 100;
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

    public Player(int difficulty, int initialHealth) {
        if (difficulty == 1) {
            this.health = 5;
        } else if (difficulty == 2) {
            this.health = 3;
        } else if (difficulty == 3) {
            this.health = 1;
        }
        this.health = initialHealth;
        this.weaponLevel = 1;

        // obrázky
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
        setImage(imageFrontBow);
        //obrázky 

    }

    public void act() {
        moveAround();
        shoot();
        checkForUpgrade();
        moveToMouse();
        updateImageBasedOnRotation();
        checkCollision();
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

    public boolean munition() {
        if(ammo > 0) {
            return true;
        } else {
            return false;
        }
    }

    private void checkCollision() {
        World world = getWorld();
        if (world instanceof Dungeon) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon)world).loseHealth();

            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon)world).loseHealth();
            }
            Actor mine = getOneIntersectingObject(Mine.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon)world).loseHealth();
            }
        } else if (world instanceof Dungeon2) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon2)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon2)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon2)world).loseHealth();
            }
            Actor mine = getOneIntersectingObject(Mine.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon2)world).loseHealth();
            }
        } else if (world instanceof Dungeon3) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon3)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon3)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon3)world).loseHealth();
            }            
            Actor mine = getOneIntersectingObject(Mine.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon3)world).loseHealth();
            }
        } else if (world instanceof Dungeon4) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon4)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon4)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon4)world).loseHealth();
            }        
            Actor mine = getOneIntersectingObject(Mine.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon4)world).loseHealth();
            }
        } else if (world instanceof Dungeon5) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon5)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon5)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon5)world).loseHealth();
            }            
            Actor mine = getOneIntersectingObject(Mine2.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon5)world).loseHealth();
            }
        } else if (world instanceof Dungeon6) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon6)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon6)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon6)world).loseHealth();
            }            
            Actor mine = getOneIntersectingObject(Mine2.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon6)world).loseHealth();
            }
        } else if (world instanceof Dungeon7) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon7)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon7)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon7)world).loseHealth();
            }            
            Actor mine = getOneIntersectingObject(Mine2.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon7)world).loseHealth();
            }
        } else if (world instanceof Dungeon8) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon8)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon8)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon8)world).loseHealth();
            }            
            Actor mine = getOneIntersectingObject(Mine2.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon8)world).loseHealth();
            }
        } else if (world instanceof Dungeon9) {
            Actor monster2 = getOneIntersectingObject(Monster2.class);
            if (monster2 != null) {
                loseHealth();
                world.removeObject(monster2);
                ((Dungeon9)world).loseHealth();
            }
            Actor monster1 = getOneIntersectingObject(Monster1.class);
            if (monster1 != null) {
                loseHealth();
                world.removeObject(monster1);
                ((Dungeon9)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon9)world).loseHealth();
            }
            Actor mine = getOneIntersectingObject(Mine2.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon9)world).loseHealth();
            }
        } else if (world instanceof Dungeon10) {
            Actor boss = getOneIntersectingObject(Boss.class);
            if (boss != null) {
                loseHealth();
                ((Dungeon10)world).loseHealth();
            }
            Actor bullet = getOneIntersectingObject(MonsterBullet.class);
            if (bullet != null) {
                loseHealth();
                world.removeObject(bullet);
                ((Dungeon10)world).loseHealth();
            }
            Actor mine = getOneIntersectingObject(Mine2.class);
            if (mine != null) {
                loseHealth();
                world.removeObject(mine);
                ((Dungeon10)world).loseHealth();
            }
        } 
    }

    public void loseHealth() {
        health--;
        if (health <= 0) {
            die();
        }
    }

    private void die() {
        Coins.score = 0;
        Greenfoot.stop();
    }

    private void checkForUpgrade() {
        if (Greenfoot.isKeyDown("u") && Coins.score >= 10) { // zmáčknout u na upgrade zbraně
            weaponLevel++;
            Coins.score -= 10;
        }
    }

    public int getHealth() {
        return health;
    }

    private void updateImageBasedOnRotation() { // obrázky postavy (měnění podle úhlu pohledu) 
        int rotation = getRotation();
        if (weaponLevel == 1) {
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
