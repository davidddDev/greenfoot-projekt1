import greenfoot.*;

public class MainMenu extends World {
    public MainMenu() {
        super(600, 600, 1);
        prepare();
    }
    
    private void prepare() {
        addObject(new Button("Easy", 1), 300, 300);
        addObject(new Button("Medium", 2), 300, 350);
        addObject(new Button("Hard", 3), 300, 400);
        addObject(new ControlsButton(), 300, 450);
    }
}

class ControlsButton extends Actor {
    public ControlsButton() {
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage("Controls", 25, new Color(193, 133, 98, 200), new Color(0, 0, 0, 0));
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Controls());
        }
    }
}