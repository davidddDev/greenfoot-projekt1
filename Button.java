import greenfoot.*;

public class Button extends Actor {
    private String text;
    private int difficulty;

    public Button(String text, int difficulty) {
        this.text = text;
        this.difficulty = difficulty;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(text + " - Click to start", 25, new Color(193, 133, 98, 200), new Color(0, 0, 0, 0));
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int initialHealth = (difficulty == 1) ? 5 : ((difficulty == 2) ? 3 : 1);
            Greenfoot.setWorld(new Dungeon(initialHealth));
        }
    }
}
