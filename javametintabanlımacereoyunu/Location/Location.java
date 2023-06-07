package Location;

import java.util.Scanner;

import charecter.Player;

public abstract class Location {
    public Player player;
    public String name;
    protected Scanner input=new Scanner(System.in);

    public abstract boolean onLocation();
    
    public Location(Player player,String name) {
        this.player = player;
        this.name = name;
        
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    

    

}
