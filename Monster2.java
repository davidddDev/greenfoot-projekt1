import greenfoot.*;

public class Monster2 extends Actor {
    int lives;
    int time;
    public void act()
    {
        followPlayer();
        shot();
        health();
        shooting();
        time++;
    }
    
    public Monster2(int lives)
    {
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
    public void shooting()
    {
        if (time >= 120)
        {
            MonsterBullet bullet = new MonsterBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
            time = 0;
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
                getWorld().removeObject(this);
                Dungeon.killCounter++;
            }
        } else if (world instanceof Dungeon2) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon2.killCounter++;
            }
        } else if (world instanceof Dungeon3) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon3.killCounter++;
            }
        } else if (world instanceof Dungeon4) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon4.killCounter++;
            }
        } else if (world instanceof Dungeon5) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon5.killCounter++;
            }
        } else if (world instanceof Dungeon6) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon6.killCounter++;
            }
        } else if (world instanceof Dungeon7) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon7.killCounter++;
            }
        } else if (world instanceof Dungeon8) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon8.killCounter++;
            }            
        } else if (world instanceof Dungeon9) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon9.killCounter++;
            }
        } 
    }
}
