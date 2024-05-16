import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pokemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Pokemon extends Actor
{
    int health = 100;
    String[] attacklist;
    
    int passedMove;
    int turnSpeed = 10;
    int turnCount;
    
    /**
     * Act - do whatever the Pokemon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    public static int Tackle(){
        Greenfoot.playSound("Tackle.wav");
        return Greenfoot.getRandomNumber(15) + 5;
    }
}
