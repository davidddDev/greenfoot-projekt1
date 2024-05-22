import greenfoot.*;

public class Controls extends World {
    public Controls() {
        super(600, 600, 1);
        prepare();
    }

    private void prepare() {
        GreenfootImage bg = getBackground();
        bg.setColor(new Color(193, 133, 98, 200));
        bg.setFont(new Font("Arial Bold", false, false, 20));
        bg.drawString("Controls:", 250, 100);
        bg.drawString("W - Move up", 98, 150);
        bg.drawString("A - Move left", 100, 180);
        bg.drawString("S - Move down", 100, 210);
        bg.drawString("D - Move right", 100, 240);
        bg.drawString("U - Upgrade gun (if coins >= 10)", 100, 270);
        bg.drawString("LMB - Shoot", 100, 300);
        bg.drawString("Chance to get coins = 50%", 100, 370);
        bg.drawString("Crawler = 1 coin", 100, 400);
        bg.drawString("Shooter = 2 coins", 100, 430);
        addObject(new ReturnButton(), 300, 500);
    }
}

class ReturnButton extends Actor {
    public ReturnButton() {
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage("Back to Main Menu", 25, new Color(193, 133, 98, 200), new Color(0, 0, 0, 0));
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MainMenu());
        }
    }
}