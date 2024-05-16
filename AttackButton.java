import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackButton extends Button
{
    /**
     * Act - do whatever the AttackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Actor actor;
    public AttackButton(){
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(image.getWidth(), image.getHeight()/2);
        setImage(image);
    }
    public AttackButton(String name) {
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(200, 60);
        setImage(image);
        Actor actor = new TextActor();
        actor.setImage(new GreenfootImage(name, 35, Color.BLACK, new Color(0,0,0,0)));
        this.actor = actor;
    }
    public void act()
    {
        // Add your action code here.
    }
}
