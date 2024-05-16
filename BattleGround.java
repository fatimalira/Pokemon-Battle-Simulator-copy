import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleGround extends World
{
    // Forest - "G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/forest.jpg"
    // Space - "G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/space.jpg"
    // Snow - "G:/Shared drives/AP Comp Sci Midyear Project/Pokemon Images/snow.jpg"
    // Placeholder - ""
    
    // 1 is Charizard
    // 2 is Pikachu
    // 3 is Squirtle
    // 4 is City   
    
    Pokemon Player1Pokemon;
    Pokemon Player2Pokemon;
    String p1Pokemon;
    String p2Pokemon;
    
    Actor p1Health;
    Actor p2Health;
    Actor currentTurnDisplay;
    Actor PotionButton;
    Actor RunButton;
    Actor FinalText;
    
    AttackButton abutton1;
    AttackButton abutton2;
    AttackButton abutton3;
    AttackButton abutton4;
    
    int Player1PotionsRemaining = 1;
    int Player2PotionsRemaining = 1;
    int currentPlayer;
    int otherPlayer;
    
    StartButton sb = new StartButton();
    boolean soundPlayed = false;
    /**
     * Constructor for objects of class BattleGround.
     * 
     */
    public BattleGround()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    public BattleGround(int selection1, int selection2, String imagefile){
        super(600, 400, 1);
        GreenfootImage bg = new GreenfootImage(imagefile);
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        switch (selection1){
            case 1:
                Charizard charizard = new Charizard();
                addObject(charizard, 150, 185);
                Player1Pokemon = charizard;
                p1Pokemon = "Charizard";
                break;
            case 2:
                Pikachu pikachu = new Pikachu();
                addObject(pikachu, 150, 185);
                Player1Pokemon = pikachu;
                p1Pokemon = "Pikachu";
                break;
            case 3:
                Squirtle squirtle = new Squirtle();
                addObject(squirtle, 150, 185);
                Player1Pokemon = squirtle;
                p1Pokemon = "Squirtle";
                break;
            case 4:
                Snorlax snorlax = new Snorlax();
                addObject(snorlax, 150, 185);
                Player1Pokemon = snorlax;
                p1Pokemon = "Snorlax";
                break;
        }
        switch (selection2){
            case 1:
                Charizard charizard = new Charizard();
                addObject(charizard, 450, 185);
                Player2Pokemon = charizard;
                p2Pokemon = "Charizard";
                break;
            case 2:
                Pikachu pikachu = new Pikachu();
                addObject(pikachu, 450, 185);
                Player2Pokemon = pikachu;
                p2Pokemon = "Pikachu";
                break;
            case 3:
                Squirtle squirtle = new Squirtle();
                addObject(squirtle, 450, 185);
                Player2Pokemon = squirtle;
                p2Pokemon = "Squirtle";
                break;
            case 4:
                Snorlax snorlax = new Snorlax();
                addObject(snorlax, 450, 185);
                Player2Pokemon = snorlax;
                p2Pokemon = "Snorlax";
                break;
        }
        
        //attack button:
        AttackButton abutton1 = new AttackButton("");
        addObject(abutton1, 185, 365);
        addObject(abutton1.actor, abutton1.getX(), abutton1.getY()-3);
        this.abutton1 = abutton1;
        
        AttackButton abutton2 = new AttackButton("");
        addObject(abutton2, abutton1.getX()+225, abutton1.getY());
        addObject(abutton2.actor, abutton2.getX(), abutton2.getY()-3);
        this.abutton2 = abutton2;
        
        AttackButton abutton3 = new AttackButton("");
        addObject(abutton3, abutton1.getX(), abutton1.getY()-65);
        addObject(abutton3.actor, abutton3.getX(), abutton3.getY()-3);
        this.abutton3 = abutton3;
        
        AttackButton abutton4 = new AttackButton("");
        addObject(abutton4, abutton1.getX()+225, abutton1.getY()-65);
        addObject(abutton4.actor, abutton4.getX(), abutton4.getY()-3);
        this.abutton4 = abutton4;
        
        //health: 
        Actor p1Health = new TextActor();
        addObject(p1Health, Player1Pokemon.getX(), Player1Pokemon.getY() - 125);
        this.p1Health = p1Health;
        
        Actor p2Health = new TextActor();
        addObject(p2Health, Player2Pokemon.getX(), Player2Pokemon.getY() - 125);
        this.p2Health = p2Health;
        
        //turn display:
        Actor currentTurnDisplay = new TextActor();
        addObject(currentTurnDisplay, 300, 15);
        this.currentTurnDisplay = currentTurnDisplay;
        
        //flee button:
        FleeButton fleebutton = new FleeButton();
        addObject(fleebutton, 544, 16);
        this.RunButton = fleebutton;
        
        //potion button:
        PotionButton potionbutton = new PotionButton();
        addObject(potionbutton, 30, 30);
        this.PotionButton = potionbutton;
        
        //final text:
        Actor FinalText = new TextActor();
        this.FinalText = FinalText;        
        
        //players:
        currentPlayer = 1;
        otherPlayer = 2;
    }
    public BattleGround(String imagefile){
        super(600, 400, 1);
        GreenfootImage bg = new GreenfootImage(imagefile);
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
    public void act() {
        switch (currentPlayer){
            case 1:
                otherPlayer = 2;
                break;
            case 2:
                otherPlayer = 1;
                break;
        }
        
        p1Health.setImage(new GreenfootImage("Health: " + Player1Pokemon.health, 25, Color.BLACK, new Color(255,255,255, 150)));
        p2Health.setImage(new GreenfootImage("Health: " + Player2Pokemon.health, 25, Color.BLACK, new Color(255,255,255, 150)));
        
        currentTurnDisplay.setImage(new GreenfootImage("Player " + currentPlayer + ", make your selection!", 20, Color.BLACK, new Color(255, 255, 255, 150)));
        
        if (Greenfoot.mouseClicked(RunButton)){
            removeObjects(getObjects(Actor.class));
            addObject(FinalText, 300, 200);
            addObject(sb, 300, 340);
            FinalText.setImage(new GreenfootImage("Player " + currentPlayer + " has fled! Player " + otherPlayer + " wins!", 40, Color.BLACK, new Color(255, 255, 255, 150)));
            Greenfoot.playSound("Win.wav");
            switch(currentPlayer){
                case 1:
                    OpeningScreen.p2wins++;
                    break;
                case 2:
                    OpeningScreen.p1wins++;
                    break;
            }
        }
        if (Greenfoot.mouseClicked(sb)){  
            Greenfoot.playSound("Button.wav");
            Greenfoot.setWorld(new OpeningScreen());
        }
        
        if (Greenfoot.mouseClicked(PotionButton)){
            if (currentPlayer == 1 && Player1PotionsRemaining == 1){
                Greenfoot.playSound("Potion.wav");
                Player1Pokemon.health += 20;
                Player1PotionsRemaining--;
            }
            else if (currentPlayer == 2 && Player2PotionsRemaining == 1){
                Greenfoot.playSound("Potion.wav");
                Player2Pokemon.health += 20;
                Player2PotionsRemaining--;
            }
        }
        
        switch (currentPlayer){
            case 1:
                abutton1.actor.setImage(new GreenfootImage(Player1Pokemon.attacklist[0], 35, Color.BLACK, new Color(0,0,0,0)));
                abutton2.actor.setImage(new GreenfootImage(Player1Pokemon.attacklist[1], 35, Color.BLACK, new Color(0,0,0,0)));
                abutton3.actor.setImage(new GreenfootImage(Player1Pokemon.attacklist[2], 35, Color.BLACK, new Color(0,0,0,0)));
                abutton4.actor.setImage(new GreenfootImage(Player1Pokemon.attacklist[3], 35, Color.BLACK, new Color(0,0,0,0)));
                break;
            case 2:
                abutton1.actor.setImage(new GreenfootImage(Player2Pokemon.attacklist[0], 35, Color.BLACK, new Color(0,0,0,0)));
                abutton2.actor.setImage(new GreenfootImage(Player2Pokemon.attacklist[1], 35, Color.BLACK, new Color(0,0,0,0)));
                abutton3.actor.setImage(new GreenfootImage(Player2Pokemon.attacklist[2], 35, Color.BLACK, new Color(0,0,0,0)));
                abutton4.actor.setImage(new GreenfootImage(Player2Pokemon.attacklist[3], 35, Color.BLACK, new Color(0,0,0,0)));
                break;
        }
        
        if (Player1Pokemon.health > 0 && Player2Pokemon.health > 0){
            switch (currentPlayer){
            case 1:
                if(Greenfoot.mouseClicked(abutton1) || Greenfoot.mouseClicked(abutton1.actor)){
                    if (Player1Pokemon instanceof Charizard){
                        Player2Pokemon.health -= Charizard.Tackle();
                        if (Player2Pokemon instanceof Charizard){
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Pikachu){
                        Player2Pokemon.health -= Pikachu.Tackle();
                        if (Player2Pokemon instanceof Charizard){
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Snorlax){
                        Player2Pokemon.health -= Snorlax.Tackle();
                        if (Player2Pokemon instanceof Charizard){
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Squirtle){
                        Player2Pokemon.health -= Squirtle.Tackle();
                        if (Player2Pokemon instanceof Charizard){
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    currentPlayer = 2;
                }
                if(Greenfoot.mouseClicked(abutton2) || Greenfoot.mouseClicked(abutton2.actor)){
                    if (Player1Pokemon instanceof Charizard){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Charizard.Ember();
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Charizard.Ember() * 0.65;
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Charizard.Ember();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Charizard.Ember();
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Pikachu){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Pikachu.ElectroBall();
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Pikachu.ElectroBall()*1.5;
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Pikachu.ElectroBall();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Pikachu.ElectroBall();
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Snorlax){
                        Player2Pokemon.health -= Snorlax.SleepTalk();
                        if (Player2Pokemon instanceof Charizard){
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Squirtle){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Squirtle.WaterPulse() * 1.5;
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Squirtle.WaterPulse();
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Squirtle.WaterPulse();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Squirtle.WaterPulse()*0.65;
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    currentPlayer = 2;
                }
                if(Greenfoot.mouseClicked(abutton3) || Greenfoot.mouseClicked(abutton3.actor)){
                    if (Player1Pokemon instanceof Charizard){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Charizard.FireSpin();
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Charizard.FireSpin() * 0.65;
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Charizard.FireSpin();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Charizard.FireSpin();
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Pikachu){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Pikachu.ChargeBeam();
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Pikachu.ChargeBeam()*1.5;
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Pikachu.ChargeBeam();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Pikachu.ChargeBeam();
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Snorlax){
                        Player2Pokemon.health -= Snorlax.BodySlam();
                        if (Player2Pokemon instanceof Charizard){
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Squirtle){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Squirtle.HydroPump() * 1.5;
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Squirtle.HydroPump();
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Squirtle.HydroPump();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Squirtle.HydroPump()*0.65;
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    currentPlayer = 2;
                }
                if(Greenfoot.mouseClicked(abutton4) || Greenfoot.mouseClicked(abutton4.actor)){
                    if (Player1Pokemon instanceof Charizard){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Charizard.BlastBurn();
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Charizard.BlastBurn() * 0.65;
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Charizard.BlastBurn();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Charizard.BlastBurn();
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Pikachu){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Pikachu.Thunderbolt();
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Pikachu.Thunderbolt()*1.5;
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Pikachu.Thunderbolt();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Pikachu.Thunderbolt();
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Snorlax){
                        Player2Pokemon.health -= Snorlax.Swallow();
                        if (Player2Pokemon instanceof Charizard){
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player1Pokemon instanceof Squirtle){
                        if (Player2Pokemon instanceof Charizard){
                            Player2Pokemon.health -= Squirtle.WaveCrash()*1.5;
                            ((Charizard)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Squirtle){
                            Player2Pokemon.health -= Squirtle.WaveCrash();
                            ((Squirtle)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Snorlax){
                            Player2Pokemon.health -= Squirtle.WaveCrash();
                            ((Snorlax)Player2Pokemon).passedMove = 1;
                        }
                        if (Player2Pokemon instanceof Pikachu){
                            Player2Pokemon.health -= Squirtle.WaveCrash()*0.65;
                            ((Pikachu)Player2Pokemon).passedMove = 1;
                        }
                    }
                    currentPlayer = 2;
                }
                break;
            case 2:
                if(Greenfoot.mouseClicked(abutton1) || Greenfoot.mouseClicked(abutton1.actor)){
                    if (Player2Pokemon instanceof Charizard){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Charizard.Tackle();
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Charizard.Tackle();
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Charizard.Tackle();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Charizard.Tackle();
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Pikachu){
                        Player1Pokemon.health -= Pikachu.Tackle();
                        if (Player1Pokemon instanceof Charizard){
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Snorlax){
                        Player1Pokemon.health -= Snorlax.Tackle();
                        if (Player1Pokemon instanceof Charizard){
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Squirtle){
                        Player1Pokemon.health -= Squirtle.Tackle();
                        if (Player1Pokemon instanceof Charizard){
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    currentPlayer = 1;
                }
                if(Greenfoot.mouseClicked(abutton2) || Greenfoot.mouseClicked(abutton2.actor)){
                    if (Player2Pokemon instanceof Charizard){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Charizard.Ember();
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Charizard.Ember() * 0.65;
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Charizard.Ember();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Charizard.Ember();
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Pikachu){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Pikachu.ElectroBall();
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Pikachu.ElectroBall()*1.5;
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Pikachu.ElectroBall();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Pikachu.ElectroBall();
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Snorlax){
                        Player1Pokemon.health -= Snorlax.SleepTalk();
                        if (Player1Pokemon instanceof Charizard){
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Squirtle){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Squirtle.WaterPulse() *1.5;
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Squirtle.WaterPulse();
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Squirtle.WaterPulse();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Squirtle.WaterPulse()*0.65;
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    currentPlayer = 1;
                }
                if(Greenfoot.mouseClicked(abutton3) || Greenfoot.mouseClicked(abutton3.actor)){
                    if (Player2Pokemon instanceof Charizard){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Charizard.FireSpin();
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Charizard.FireSpin() * 0.65;
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Charizard.FireSpin();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Charizard.FireSpin();
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Pikachu){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Pikachu.ChargeBeam();
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Pikachu.ChargeBeam()*1.5;
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Pikachu.ChargeBeam();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Pikachu.ChargeBeam();
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Snorlax){
                        Player1Pokemon.health -= Snorlax.BodySlam();
                        if (Player1Pokemon instanceof Charizard){
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Squirtle){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Squirtle.HydroPump()*1.5;
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Squirtle.HydroPump();
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Squirtle.HydroPump();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Squirtle.HydroPump()*0.65;
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    currentPlayer = 1;
                }
                if(Greenfoot.mouseClicked(abutton4) || Greenfoot.mouseClicked(abutton4.actor)){
                    if (Player2Pokemon instanceof Charizard){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Charizard.BlastBurn();
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Charizard.BlastBurn() * 0.65;
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Charizard.BlastBurn();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Charizard.BlastBurn();
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Pikachu){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Pikachu.Thunderbolt();
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Pikachu.Thunderbolt()*1.5;
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Pikachu.Thunderbolt();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Pikachu.Thunderbolt();
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Snorlax){
                        Player1Pokemon.health -= Snorlax.Swallow();
                        if (Player1Pokemon instanceof Charizard){
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    else if (Player2Pokemon instanceof Squirtle){
                        if (Player1Pokemon instanceof Charizard){
                            Player1Pokemon.health -= Squirtle.WaveCrash()*1.5;
                            ((Charizard)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Squirtle){
                            Player1Pokemon.health -= Squirtle.WaveCrash();
                            ((Squirtle)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Snorlax){
                            Player1Pokemon.health -= Squirtle.WaveCrash();
                            ((Snorlax)Player1Pokemon).passedMove = 1;
                        }
                        if (Player1Pokemon instanceof Pikachu){
                            Player1Pokemon.health -= Squirtle.WaveCrash()*0.65;
                            ((Pikachu)Player1Pokemon).passedMove = 1;
                        }
                    }
                    currentPlayer = 1;
                }
                break;
            }
        }
        else if(Player1Pokemon.health <= 0 || Player2Pokemon.health <= 0){
                if(!soundPlayed) {
                    Greenfoot.playSound("Win.wav");
                    soundPlayed = true;
                }
                
                if(Player1Pokemon.health <= 0){
                    removeObjects(getObjects(Actor.class));
                    addObject(FinalText, 300, 200);
                    addObject(sb, 300, 340);
                    FinalText.setImage(new GreenfootImage("Player 1's " + p1Pokemon + " has fainted! Player 2 wins!", 30, Color.BLACK, new Color(255, 255, 255, 150)));
                    if(Greenfoot.mouseClicked(sb)){
                        OpeningScreen.p2wins++;
                    }
                }
                else if(Player2Pokemon.health <= 0){
                    removeObjects(getObjects(Actor.class));
                    addObject(FinalText, 300, 200);
                    addObject(sb, 300, 340);
                    FinalText.setImage(new GreenfootImage("Player 2's " + p2Pokemon + " has fainted! Player 1 wins!", 30, Color.BLACK, new Color(255, 255, 255, 150)));
                    if(Greenfoot.mouseClicked(sb)){
                        OpeningScreen.p1wins++;
                    }
                }
        }
    }
}
