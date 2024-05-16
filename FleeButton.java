import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FleeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FleeButton extends Button
{
    /**
     * Act - do whatever the FleeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FleeButton(){
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
    }
    public void act()
    {
    }
}
