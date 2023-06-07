package monster;

public class Obstacle {
    private int id;
    private int damage;
    private int healt;
    private String name;
    private int award;
    private  int originalHealth;


   

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public Obstacle(int id, int damage, int healt, String name,int award) {
        this.id = id;
        this.damage = damage;
        this.healt = healt;
        this.name = name;
        this.award=award;
        this.originalHealth=healt;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if(healt <0){
            healt=0;
        }
        this.healt = healt;
    }
}