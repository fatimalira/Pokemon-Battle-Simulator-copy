import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reset extends Button
{
    /**
     * Act - do whatever the Reset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Reset() {
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(image.getWidth()/8, image.getHeight()/8);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
