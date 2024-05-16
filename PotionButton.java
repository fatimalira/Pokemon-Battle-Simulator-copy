import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PotionButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PotionButton extends Button
{
    /**
     * Act - do whatever the PotionButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PotionButton(){
        GreenfootImage image = (GreenfootImage)getImage();
        image.scale(image.getWidth()/4, image.getHeight()/4);
        setImage(image);
    }
    public void act()
    {
        
    }
}
