package Location;

import charecter.Player;

public class SafeHouse extends NormalLocation {

    public SafeHouse(Player player ) {
        super(player, "Güvenli Ev");
        
    }


    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz");
        this.getPlayer().setHealt(this.getPlayer().getOriginalHealt());
        System.out.println("Caniniz Fullendi");
        getPlayer().printInventory();
		System.out.println();
		
        return true;
    }
    
}
