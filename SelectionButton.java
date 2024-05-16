import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectionButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectionButton extends Button
{
    /**
     * Act - do whatever the SelectionButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Actor actor;
    public SelectionButton() {
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        setImage(image);
    }
    public SelectionButton(String name) {
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        setImage(image);
        Actor actor = new TextActor();
        actor.setImage(new GreenfootImage(name, 35, Color.BLACK, new Color(0,0,0,0)));
        this.actor = actor;
    }
    public void act()
    {
        
    }
}
