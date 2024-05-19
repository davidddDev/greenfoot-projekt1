import greenfoot.*;

/**
 * Write a description of class Monster1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster1 extends Actor
{
    int speed;
    int lives;
    /**
     * Act - do whatever the Monster1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        followPlayer();
        move(speed);
        shot();
        health();
    }

    public Monster1(int speed, int lives)
    {
        this.speed = speed; // Nastaví rychlost pohybu
        this.lives = lives; // Nastaví počet životů
    }

    private void followPlayer()
    {
        int distance = 1000;
        Actor closest = null;

        if(!getObjectsInRange(distance, Player.class).isEmpty())
        {
            for (Object obj: getObjectsInRange(distance, Player.class))
            {
                Actor player = (Actor) obj;
                int playerDistance = (int) Math.hypot(player.getX() - getX(), player.getY() - getY());
                if (closest == null || playerDistance< distance)
                {
                    closest = player;
                    distance = playerDistance;
                }
            }
            turnTowards(closest.getX(),closest.getY());
        }  
    }

    public void shot()
    {
        Bullet intersectingBullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if (intersectingBullet != null)
        {
            lives--;
            removeTouching(Bullet.class);
        }
    }

    public void health()
    {
        World world = getWorld();
            if (world instanceof Dungeon) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon.killCounter++;
                }
            } else if (world instanceof Dungeon2) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon2)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon2.killCounter++;
                }
            } else if (world instanceof Dungeon3) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon3)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon3.killCounter++;
                }
            } else if (world instanceof Dungeon4) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon4)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon4.killCounter++;
                }
            } else if (world instanceof Dungeon5) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon5)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon5.killCounter++;
                }
            } else if (world instanceof Dungeon6) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon6)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon6.killCounter++;
                }
            } else if (world instanceof Dungeon7) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon7)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon7.killCounter++;
                }
            } else if (world instanceof Dungeon8) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon8)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon8.killCounter++;
                }            
            } else if (world instanceof Dungeon9) {
                if(lives == 0)
                {
                    if (Greenfoot.getRandomNumber(100) < 50) {
                        ((Dungeon9)world).getCoins().addCoins(1);
                    }
                    getWorld().removeObject(this);
                    Dungeon9.killCounter++;
                }
        } 
    }
}
