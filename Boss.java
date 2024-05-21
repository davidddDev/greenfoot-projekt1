import greenfoot.*;

public class Boss extends Actor {
    int time;
    int speed;
    int lives;

    public Boss(int speed, int lives)
    {
        this.speed = speed; // Nastaví rychlost pohybu
        this.lives = lives; // Nastaví počet životů
    }

    public void act() {
        followPlayer();
        shot();
        move(speed);
        health();
        shooting();
        time++;
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

    public void shooting()
    {
        if (time >= 75)
        {
            MonsterBullet bullet = new MonsterBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
            time = 0;
        }
    }

    public void health() {
        World world = getWorld();
        if (world instanceof Dungeon10) {
            if(lives == 0)
            {
                getWorld().removeObject(this);
                Dungeon10.killCounter++;
            }
        }
    }
}