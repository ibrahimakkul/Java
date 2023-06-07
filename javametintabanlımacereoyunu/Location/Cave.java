package Location;

import charecter.Player;

import monster.zombie;

public class Cave extends Battle {

    public Cave(Player player) {
        super(player, "Mağara", new zombie(), "Food",3);
        
    }
    
}
