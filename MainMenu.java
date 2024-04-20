import greenfoot.*;

public class MainMenu extends World {
    
    public MainMenu() { 
        super(600, 600, 1); 
        prepare();
    }
    
    private void prepare() {
        addObject(new Button("Easy", 1), 300, 150);
        addObject(new Button("Medium", 2), 300, 200);
        addObject(new Button("Hard", 3), 300, 250);
    }
}
