import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Logo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Logo1 extends Logo
{
    public Logo1()
    {
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
    }
    
    /**
     * Act - do whatever the Logo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
