import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectionMenubg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectionMenubg extends World
{
    SelectionButton sbutton1;
    SelectionButton sbutton2;
    SelectionButton sbutton3;
    SelectionButton sbutton4;    
    
    /**
     * Constructor for objects of class SelectionMenubg.
     * 
     */
    public SelectionMenubg()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/selection menu background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        Actor actor1 = new TextActor();
        addObject(actor1, getWidth()/2,30);
        actor1.setImage(new GreenfootImage("Choose your battlefield!", 35, Color.BLACK, new Color(255,255,255,185)));
        
        SelectionButton sbutton1 = new SelectionButton("Forest");
        addObject(sbutton1, 200, 250);
        addObject(sbutton1.actor, sbutton1.getX(), sbutton1.getY()-5);
        this.sbutton1 = sbutton1;
        
        SelectionButton sbutton2 = new SelectionButton("Space");
        addObject(sbutton2, sbutton1.getX()+200, sbutton1.getY());
        addObject(sbutton2.actor, sbutton2.getX(), sbutton2.getY()-5);
        this.sbutton2 = sbutton2;
        
        SelectionButton sbutton3 = new SelectionButton("Snow");
        addObject(sbutton3, sbutton1.getX(), sbutton1.getY()-100);
        addObject(sbutton3.actor, sbutton3.getX(), sbutton3.getY()-5);
        this.sbutton3 = sbutton3;
        
        SelectionButton sbutton4 = new SelectionButton("City");
        addObject(sbutton4, sbutton1.getX()+200, sbutton1.getY()-100);
        addObject(sbutton4.actor, sbutton4.getX(), sbutton4.getY()-5);
        this.sbutton4 = sbutton4;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(sbutton1) || Greenfoot.mouseClicked(sbutton1.actor)){
            Greenfoot.playSound("Button.wav");
            startBattle1();
        }
        if (Greenfoot.mouseClicked(sbutton2) || Greenfoot.mouseClicked(sbutton2.actor)){
            Greenfoot.playSound("Button.wav");
            startBattle2();
        }
        if (Greenfoot.mouseClicked(sbutton3) || Greenfoot.mouseClicked(sbutton3.actor)){
            Greenfoot.playSound("Button.wav");
            startBattle3();
        }
        if (Greenfoot.mouseClicked(sbutton4) || Greenfoot.mouseClicked(sbutton4.actor)){
            Greenfoot.playSound("Button.wav");
            startBattle4();
        }
    }
    
    public void startBattle1(){
        Greenfoot.setWorld(new BattleGround(SelectionMenu.selection, SelectionMenu2.selection, "G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/forest.jpg"));
    }
    
    public void startBattle2(){
        Greenfoot.setWorld(new BattleGround(SelectionMenu.selection, SelectionMenu2.selection, "G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/space.jpg"));
    }
    
    public void startBattle3(){
        Greenfoot.setWorld(new BattleGround(SelectionMenu.selection, SelectionMenu2.selection, "G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/snow.jpg"));
    }
    
    public void startBattle4(){
        Greenfoot.setWorld(new BattleGround(SelectionMenu.selection, SelectionMenu2.selection, "G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/city.jpg"));
    }
}



