package Location;

import java.util.Random;

import armor.Armor;
import charecter.Player;
import monster.Obstacle;
import weapon.Weapon;

public abstract class Battle extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public Battle(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacle() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsnumber = this.randomObstacle();
        System.out.println("Şuan bu haritadasın :" + this.getName());
        System.out.println("Dikkatli ol burada " + obsnumber + " tane " + this.getObstacle().getName() + " yaşiyor");
        System.out.println("Savaşmak istiyorsan S istemiyor isen K ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")) {
            if(combat(obsnumber)){
                System.out.println(this.getName() + "tüm düşmanlari yendiniz");
                return true;
            }

        }

        if(this.getPlayer().getHealt() <=0){
            System.out.println("Öldünüz.");
            return false;
        }

        return true;
    }

    public boolean combat(int maxMonster) {
		if (this.getObstacle().getName().equals("Snake")) {
			this.getObstacle().setDamage(snakeDamage());
		}
		for (int i = 1; i <= maxMonster; i++) {
			this.getObstacle().setHealt(this.getObstacle().getOriginalHealth());
			playerStats();
			obstacleStats(i);
			int battlechance = chance();
			while (this.getPlayer().getHealt() > 0 && this.getObstacle().getHealt() > 0) {
				System.out.print("Savaşma için S kaçmak için K  : ");
				String selectCombat = input.nextLine().toUpperCase();

				if (selectCombat.equals("S")) {
					if (battlechance < 50) {
						System.out.println("Your hit !");
						this.getObstacle().setHealt(this.getObstacle().getHealt() - this.getPlayer().getTotalDamage());
						afterHit();
						if (this.getObstacle().getHealt() > 0) {
							System.out.println();
							System.out.println(getObstacle().getName() + "Damage !");
							int enemyDamage = this.getObstacle().getDamage()
									- this.getPlayer().getInventory().getArmor().getBlock();
							if (enemyDamage < 0) {
								enemyDamage = 0;
							}
							this.getPlayer().setHealt(this.getPlayer().getHealt() - enemyDamage);
							afterHit();
						}
					} else {
						if (this.getObstacle().getHealt() > 0) {
							System.out.println();
							System.out.println(getObstacle().getName() + "Damage : !");
							int enemyDamage = this.getObstacle().getDamage()
									- this.getPlayer().getInventory().getArmor().getBlock();
							if (enemyDamage < 0) {
								enemyDamage = 0;
							}
							this.getPlayer().setHealt(this.getPlayer().getHealt() - enemyDamage);
							afterHit();
						}
						System.out.println("Yor hit: !");
						this.getObstacle().setHealt(this.getObstacle().getHealt() - this.getPlayer().getTotalDamage());
						afterHit();
					}
				} else {
					return false;
				}
			}
			if (getObstacle().getHealt() < this.getPlayer().getHealt()) {
				System.out.println("Canavarlar öldürüldü !");

				if (getObstacle().getName().equals("Snake")) {
					drop();
				} else {
					System.out.println(this.getObstacle().getAward() + " Money earned !");
					this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
					if (this.getObstacle().getName().equals("Zombie")) {
						this.getPlayer().getInventory().setFood(this.getPlayer().getInventory().getFood()+1);
						System.out.println("Food earned");
					}
					if (this.getObstacle().getName().equals("Vampire")) {
						this.getPlayer().getInventory().setFirewood(this.getPlayer().getInventory().getFirewood()+1);
						System.out.println("Firewood earned");
					}
					if (this.getObstacle().getName().equals("Bear")) {
						this.getPlayer().getInventory().setWater(this.getPlayer().getInventory().getWater()+1);
						System.out.println("Water earned");
					}
					if (this.getObstacle().getName().equals("Snake")) {
					}
				}
				System.out.println("Toplam para " + this.getPlayer().getMoney());
			}
		}
		return false;
	}
    private int chance() {
		Random r = new Random();
		return r.nextInt()*100;
	}


    public int snakeDamage() {
		Random r = new Random();
		return r.nextInt() * 100;
	}
    public void drop() {
		Random r = new Random();
		int chance = r.nextInt() * 100;

		if (chance < 55) {
			Random rr = new Random();
			int itemchance = rr.nextInt() * 100;
			if (itemchance <= 30) {
				
				int weaponeChance = rr.nextInt() * 100;
				if (weaponeChance <= 20) {
					getPlayer().getInventory().setWeapon(Weapon.getWeaponById(3));
					System.out.println(getPlayer().getInventory().getWeapon().getName() + " Kazandiniz ..");
				}
				if (20 < weaponeChance && weaponeChance <= 50) {
					getPlayer().getInventory().setWeapon(Weapon.getWeaponById(2));
					System.out.println(getPlayer().getInventory().getWeapon().getName() + " Kazandiniz ..");
				}
				if (50 < weaponeChance) {
					getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
					System.out.println(getPlayer().getInventory().getWeapon().getName() + " Kazandiniz ..");
				}

			}
			if (30 < itemchance && itemchance <= 60) {
				Random ra = new Random();
				int armorChance = ra.nextInt() * 100;
				if (armorChance <= 20) {
					getPlayer().getInventory().setArmor(Armor.getArmorById(3));
					System.out.println(getPlayer().getInventory().getArmor().getName() + " earned");
				}
				if (20 < armorChance && armorChance <= 50) {
					getPlayer().getInventory().setArmor(Armor.getArmorById(2));
					System.out.println(getPlayer().getInventory().getArmor().getName() + " earned");
				}
				if (50 < armorChance) {
					getPlayer().getInventory().setArmor(Armor.getArmorById(1));
					System.out.println(getPlayer().getInventory().getArmor().getName() + " earned");
				}
			}
			if (60 < itemchance) {
				Random rg = new Random();
				int goldChance = rg.nextInt() * 100;
				if (goldChance <= 20) {
					getPlayer().setMoney(getPlayer().getMoney() + 10);
					System.out.println("10 Gold earned");
				}
				if (20 < goldChance && goldChance <= 50) {
					getPlayer().setMoney(getPlayer().getMoney() + 5);
					System.out.println("5 Gold earned");
				}
				if (50 < goldChance) {
					getPlayer().setMoney(getPlayer().getMoney() + 1);
					System.out.println("1 Gold earned");
				}
			}
		} else {
			System.out.println("Nothing..");
		}
	}

    public void afterHit() {
        System.out.println("Caniniz :" + this.getPlayer().getHealt());
        System.out.println("Canavarin cani : " + this.getObstacle().getHealt());
    }

    public void playerStats() {
        System.out.println("Oyuncu değerleri");
        System.out.println("--------------");
        System.out.println("Sağlik : " + this.getPlayer().getHealt());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Money : " + this.getPlayer().getMoney());
        System.out.println("Silah : " + this.getPlayer().getWeapon().getName());
        System.out.println("Zirh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Zirh : " + this.getPlayer().getInventory().getArmor().getBlock());
    }

    public void obstacleStats(int i) {
        System.out.println(i+"."+this.getObstacle().getName() + " değerleri");
        System.out.println("--------------");
        System.out.println("Damage : " + this.getObstacle().getDamage());
        System.out.println("Sağlik : " + this.getObstacle().getHealt());
        System.out.println("Ödül : " + this.getObstacle().getDamage());
    }

}
