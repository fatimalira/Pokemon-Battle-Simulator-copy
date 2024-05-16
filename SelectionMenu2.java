import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectionMenu2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectionMenu2 extends World
{
    SelectionButton sbutton1;
    SelectionButton sbutton2;
    SelectionButton sbutton3;
    SelectionButton sbutton4;
    static int selection;
    /**
     * Constructor for objects of class SelectionMenu2.
     * 
     */
    public SelectionMenu2()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/selection menu background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        Actor actor1 = new TextActor();
        addObject(actor1, getWidth()/2,30);
        actor1.setImage(new GreenfootImage("Player 2, select your Pokémon!", 35, Color.BLACK, new Color(255,255,255,185)));
        
        SelectionButton sbutton1 = new SelectionButton("Charizard");
        addObject(sbutton1, 200, 250);
        addObject(sbutton1.actor, sbutton1.getX(), sbutton1.getY()-5);
        this.sbutton1 = sbutton1;
        
        SelectionButton sbutton2 = new SelectionButton("Pikachu");
        addObject(sbutton2, sbutton1.getX()+200, sbutton1.getY());
        addObject(sbutton2.actor, sbutton2.getX(), sbutton2.getY()-5);
        this.sbutton2 = sbutton2;
        
        SelectionButton sbutton3 = new SelectionButton("Squirtle");
        addObject(sbutton3, sbutton1.getX(), sbutton1.getY()-100);
        addObject(sbutton3.actor, sbutton3.getX(), sbutton3.getY()-5);
        this.sbutton3 = sbutton3;
        
        SelectionButton sbutton4 = new SelectionButton("Snorlax");
        addObject(sbutton4, sbutton1.getX()+200, sbutton1.getY()-100);
        addObject(sbutton4.actor, sbutton4.getX(), sbutton4.getY()-5);
        this.sbutton4 = sbutton4;
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(sbutton1) || Greenfoot.mouseClicked(sbutton1.actor)){
            Greenfoot.playSound("Button.wav");
            pickBackground();
            selection = 1;
        }
        if (Greenfoot.mouseClicked(sbutton2) || Greenfoot.mouseClicked(sbutton2.actor)){
            Greenfoot.playSound("Button.wav");
            pickBackground();
            selection = 2;
        }
        if (Greenfoot.mouseClicked(sbutton3) || Greenfoot.mouseClicked(sbutton3.actor)){
            Greenfoot.playSound("Button.wav");
            pickBackground();
            selection = 3;
        }
        if (Greenfoot.mouseClicked(sbutton4) || Greenfoot.mouseClicked(sbutton4.actor)){
            Greenfoot.playSound("Button.wav");
            pickBackground();
            selection = 4;
        }
    }
    public void pickBackground()
    {
        Greenfoot.setWorld(new SelectionMenubg());
    }
}
