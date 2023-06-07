package charecter;

import armor.Armor;
import weapon.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private int food;
    private int water;
    private int firewood;



    




    public Inventory( ) {
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armor=new Armor("Yok",-1,0,0);
        this.food = 0;
        this.water = 0;
        this.firewood = 0;
        

       
        
        
    }
   

    

    public int getFood() {
        
        return food;
    }

    public void setFood(int food) {
       
        this.food = food;
    }

    public int getWater() {
        
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getFirewood() {
        
        return firewood;
    }

    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

   

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

   

    

}
