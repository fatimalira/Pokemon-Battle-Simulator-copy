import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Charizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charizard extends Pokemon implements Fire
{
    /**
     * Act - do whatever the Charizard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int passedMove = 0;
    int turnCount = 0;
    
    public Charizard() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        setImage(image);
        
        attacklist = new String[]{"Tackle", "Ember", "Fire Spin", "Blast Burn"};
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
    public static int Ember(){
        Greenfoot.playSound("Ember.wav");
        return Greenfoot.getRandomNumber(8) + 10;
    }
    public static int FireSpin(){
        Greenfoot.playSound("FireSpin.wav");
        return Greenfoot.getRandomNumber(6) + 10;
    }
    public static int BlastBurn(){
        Greenfoot.playSound("BlastBurn.wav");
        return Greenfoot.getRandomNumber(22);
    }
}
