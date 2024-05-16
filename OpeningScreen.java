import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpeningScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpeningScreen extends World
{
    Logo1 logo1 = new Logo1();
    Logo2 logo2 = new Logo2();
    StartButton sb = new StartButton();
    Copyright cr = new Copyright();
    
    static int p1wins;
    static int p2wins;
    
    Actor actor1;
    Actor actor2;
    Actor actor3;
    Actor actor4;
    Reset reset1;
    /**
     * Constructor for objects of class OpeningScreen.
     * 
     */
    public OpeningScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("G:/Shared drives/AP Comp Sci Midyear Project/Code/Pokemon Battle Simulator/images/StartScreen.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        addObject(logo1, 300, 75);
        addObject(logo2, 300, 140);
        addObject(sb, 300, 240);
        addObject(cr, 300, 390);
        
        Actor actor1 = new TextActor();
        addObject(actor1, 100,350);
        actor1.setImage(new GreenfootImage("" + p1wins, 35, Color.BLACK, new Color(255,255,255, 0)));
        this.actor1 = actor1;
        
        Actor actor2 = new TextActor();
        addObject(actor2,actor1.getX()+400,actor1.getY());
        actor2.setImage(new GreenfootImage("" + p2wins, 35, Color.BLACK, new Color(255,255,255, 0)));
        this.actor2 = actor2;
        
        Actor actor3 = new TextActor();
        addObject(actor3,actor1.getX(),actor1.getY()-45);
        actor3.setImage(new GreenfootImage("Player 1 Wins:", 20, Color.BLACK, new Color(255,255,255, 0)));
        this.actor3 = actor3;
        
        Actor actor4 = new TextActor();
        addObject(actor4,actor2.getX(),actor2.getY()-45);
        actor4.setImage(new GreenfootImage("Player 2 Wins:", 20, Color.BLACK, new Color(255,255,255, 0)));
        this.actor4 = actor4;
        
        Reset reset = new Reset();
        addObject(reset, sb.getX(), sb.getY()+90);
        this.reset1 = reset;
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(sb)){  
            Greenfoot.playSound("Button.wav");
            player1();
        }
        if (Greenfoot.mouseClicked(reset1)){
            p1wins = 0;
            p2wins = 0;
        }
        actor1.setImage(new GreenfootImage("" + p1wins, 35, Color.BLACK, new Color(255,255,255, 0)));
        actor2.setImage(new GreenfootImage("" + p2wins, 35, Color.BLACK, new Color(255,255,255, 0)));
    }
    
    /**
     * sets the player1 selection world after users click out of opening screen
     */
    public void player1()
    {
        Greenfoot.setWorld(new SelectionMenu());
    }
}
