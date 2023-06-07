package charecter;

public abstract class GameChar {
    private int damage;
    private int id;
    
    private int healt;
    private int money;
    private String name;



    
    
    public GameChar(int id,int damage, int healt, int money,String name) {
        this.damage = damage;
        this.healt = healt;
        this.money = money;
        this.name=name;
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealt() {
        return healt;
    }
    public void setHealt(int healt) {
        this.healt = healt;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

}
