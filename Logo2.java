import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Logo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Logo2 extends Logo
{
    public Logo2()
    {
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Logo2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
