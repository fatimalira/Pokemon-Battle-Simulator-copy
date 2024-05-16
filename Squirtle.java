import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Squirtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Squirtle extends Pokemon implements Water
{
    /**
     * Act - do whatever the Squirtle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int passedMove = 0;
    int turnCount = 0;
    public Squirtle() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
        
        attacklist = new String[]{"Tackle", "Water Pulse", "Hydro Pump", "Wave Crash"};
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
    public static int WaterPulse(){
        Greenfoot.playSound("WaterPulse.wav");
        return Greenfoot.getRandomNumber(7) + 10;
    }
    public static int HydroPump(){
        Greenfoot.playSound("HydroPump.wav");
        return Greenfoot.getRandomNumber(8) + 10;
    }
    public static int WaveCrash(){
        Greenfoot.playSound("WaveCrash.wav");
        return Greenfoot.getRandomNumber(6) + 10;
    }
}
