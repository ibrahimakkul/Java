package charecter;

import java.util.Scanner;

import weapon.Weapon;


public class Player {
    public Inventory Inventory;
    private int healt;
    private int id;
    private int damage;
    private int money;
    private String name;
    private int originalHealt;
    private Scanner scanner=new Scanner(System.in);

    
   

    public Player(String name) {

        this.name = name;

        this.Inventory = new Inventory();
    }

    public void GameCharcters(){
        GameChar [] characters={new Samurai(),
            new Archer(), new Knight()
           };
        for (GameChar gameChar : characters) {
            System.out.println("Id :" + gameChar.getId()+"Name :"+ gameChar.getName()+
            "\t Hasar :" +gameChar.getDamage()+
            "\t Healt :" +gameChar.getHealt()+
            "\t Money :" +gameChar.getMoney());
        }   
        System.out.println("Seçmek İstediğiniz karekterin Id giriniz ");
        int deger=scanner.nextInt();
        selected(deger);

    }

    public void printInventory(){
        System.out.println();
        System.out.println("Food : " + this.getInventory().getFood());
        System.out.println("Wood : " + this.getInventory().getFirewood());
        System.out.println("Water : " + this.getInventory().getWater());
        System.out.println();
    }

    public void selected(int id) {
        Samurai sam = new Samurai();
        Knight knig = new Knight();
        Archer arch = new Archer();
        switch (id) {
            case 1:
                System.out.println("Seçtiğiniz karekter " + sam.getName());
                initPlayer(sam);
                break;
            case 2:
                System.out.println("Seçtiğiniz karekter " + arch.getName());
                initPlayer(arch);
                break;
            case 3:
                System.out.println("Seçtiğiniz karekter " + knig.getName());
                initPlayer(knig);
                break;
            default:
                System.out.println("Böyle bir karekter mevcut değil");
                break;
        }

    }
    public void initPlayer(GameChar gameChar){
    this.setId(gameChar.getId());
    this.setDamage(gameChar.getDamage());
    this.setHealt(gameChar.getHealt());
    this.setOriginalHealt(gameChar.getHealt());
    this.setMoney(gameChar.getMoney());
    this.setName(gameChar.getName());

    }

    public void printİnfo(){
        System.out.println("Silahiniz : " +this.getInventory().getWeapon().getName()+
        " Zirh : " +this.getInventory().getArmor().getName()+
        " Hasariniz : "+ this.getTotalDamage() +
        " Sağlik : "+this.getHealt() +
        " Block : " +this.getInventory().getArmor().getBlock()+
        " Para : "+this.getMoney());
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getTotalDamage(){
        return damage+ this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return Inventory;
    }

    public void setInventory(Inventory inventory) {
        Inventory = inventory;
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
    public int getOriginalHealt() {
        return originalHealt;
    }

    public void setOriginalHealt(int originalHealt) {
        this.originalHealt = originalHealt;
    }

}