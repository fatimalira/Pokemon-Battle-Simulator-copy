import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pikachu extends Pokemon implements Electric
{
    /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int passedMove = 0;
    int turnCount = 0;
    public Pikachu() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
        
        attacklist = new String[]{"Tackle", "Electro Ball", "Charge Beam", "Thunderbolt"};
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
    public static int ElectroBall(){
        Greenfoot.playSound("ElectroBall.wav");
        return Greenfoot.getRandomNumber(7) + 10;
    }
    public static int ChargeBeam(){
        Greenfoot.playSound("ChargeBeam.wav");
        return Greenfoot.getRandomNumber(5) + 10;
    }
    public static int Thunderbolt(){
        Greenfoot.playSound("Thunderbolt.wav");
        return Greenfoot.getRandomNumber(6) + 10;
    }
}
