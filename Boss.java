import greenfoot.*;

public class Boss extends Actor {
    private int health = 20;
    int time;
    public Boss() {
        this.health = 20;
    }
    
    public void act() {
        shot();
        health();
        shooting();
        time++;
    }
    public void shot()
    {
        Bullet intersectingBullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if (intersectingBullet != null)
        {
            health--;
            removeTouching(Bullet.class);
        }
    }
    public void shooting()
    {
        if (time >= 200)
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
            if(health == 0)
            {
                getWorld().removeObject(this);
                Dungeon10.killCounter++;
            }
        }
    }
}