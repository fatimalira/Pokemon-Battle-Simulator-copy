import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snorlax here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snorlax extends Pokemon
{
    /**
     * Act - do whatever the Snorlax wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int passedMove = 0;
    int turnCount = 0;
    public Snorlax() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        setImage(image);
        
        attacklist = new String[]{"Tackle", "Sleep Talk", "Body Slam", "Swallow"};
    }
    public void act()
    {
        if (passedMove == 1){
            turn(turnSpeed);
            turnCount++;
            if (turnCount % 5 == 0){
                setRotation(0);            
            }
            if (turnCount == 25){
                passedMove = 0;
                turnCount = 0;
            }
        }
    }
    public static int SleepTalk(){
        Greenfoot.playSound("Sleep.wav");
        return Greenfoot.getRandomNumber(7) + 10;
    }
    public static int BodySlam(){
        Greenfoot.playSound("BodySlam.wav");
        return Greenfoot.getRandomNumber(7) + 10;
    }
    public static int Swallow(){
        Greenfoot.playSound("Swallow.wav");
        return Greenfoot.getRandomNumber(8) + 10;
    }
}
