package Location;

import armor.Armor;
import charecter.Player;
import weapon.Weapon;

public class ToolStore extends NormalLocation {

    public ToolStore(Player player) {
        super(player, "Mağaza");

    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağaza Hoşgeldiniz");
        boolean durum=true;
        while(durum){
            System.out.println("1 - Silahlar");
        System.out.println("2 - Zirhlar");
        System.out.println("3 - Çikiş yap");
        System.out.println("Seçiminiz :");
        int selectCase = input.nextInt();
        
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Geçersiz değer tekrar giriniz :");
            selectCase = input.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyAmor();

                break;
            case 3:
                System.out.println("Bir daha bekleriz");
                durum=false;
                break;
            default:
                break;
        }

        }return true;

        
    }

    public void printWeapon() {
        System.out.println("Silahlar");
        for (Weapon weaponList : Weapon.weapons()) {
            System.out.println("Adi : " + weaponList.getName() +
                    " \t Id :" + weaponList.getId() + "\t Damage : " + weaponList.getDamage() + " \t Fiyat : "
                    + weaponList.getPrice());
                    
        }System.out.println("Çikiş için 0 giriniz");

    }

    public void buyWeapon() {
        System.out.println("Bir silah seçiniz");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Geçersiz değer tekrar giriniz :");
            selectWeapon = input.nextInt();
        }

        if(selectWeapon  !=0){
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Bakiye yetersiz");
            } else {
                System.out.println(selectedWeapon.getName() + " Silahini Aldiniz");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                // System.out.println("Önceki Silahiniz : " +
                // this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                // System.out.println("Yeni Silahiniz : " +
                // this.getPlayer().getInventory().getWeapon().getName());
            }
        }
        }
    }

    public void printArmor() {
        System.out.println("Zirhlar");
        for (Armor armorList : Armor.armors()) {
            System.out.println("Adi : " + armorList.getName() +
                    " \t Id :" + armorList.getId() + "\t Block : " + armorList.getBlock() + " \t Fiyat : "
                    + armorList.getPrice());
        }

    }

    public void buyAmor() {
        System.out.println("Bir zirh seçiniz");
        int selectArmor = input.nextInt();
        while (selectArmor < 1 || selectArmor > Armor.armors().length) {
            System.out.println("Geçersiz değer tekrar giriniz :");
            selectArmor = input.nextInt();
        }System.out.println("Çikiş için 0 seçiniz");

        if(selectArmor !=0){
            Armor selectedArmor = Armor.getArmorById(selectArmor);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Bakiye yetersiz");
            } else {
                System.out.println(selectedArmor.getName() + " Zirhi Aldiniz");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());

                this.getPlayer().getInventory().setArmor(selectedArmor);

            }
        }
        }
    }

}
