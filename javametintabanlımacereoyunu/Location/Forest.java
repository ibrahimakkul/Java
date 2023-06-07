package Location;

import charecter.Player;

import monster.vampire;

public class Forest extends Battle {

    public Forest(Player player) {
        super(player, "Orman", new vampire(), "Firewood",3);
        
    }
    
}
