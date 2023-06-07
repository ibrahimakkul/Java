import java.util.Scanner;
import charecter.Player;

import Location.Cave;
import Location.Forest;
import Location.Location;
import Location.River;
import Location.SafeHouse;
import Location.ToolStore;

public class Game {
  Scanner scanner = new Scanner(System.in);

  public void start() {
    System.out.println("Macera oyununa hoşgeldiniz");
    System.out.println("Adinizi giriniz");
    String namePlayer = scanner.nextLine();
    System.out.println("Hoşgeldiniz : " + namePlayer);

    Player player = new Player(namePlayer);

    player.GameCharcters();

    Location location = null;
    boolean durum=true;
    while (durum) {
      player.printİnfo();
      System.out.println("Bölgeler");
      System.out.println("1-Güvenli Ev --> Burada Güvendesiniz");
      System.out.println("2-Eşya Dükkanı --> Burada Sialh ve Zırh alabilirsiniz");
      System.out.println("3- Mağara " +" Burada canavarlar var dikkatli ol");
      System.out.println("4- Orman " +" Burada canavarlar var dikkatli ol");
      System.out.println("5- Nedir " +" Burada canavarlar var dikkatli ol");
      System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz");
      System.out.println("Çıkış için 0");
      int selectLoc = scanner.nextInt();
      if (selectLoc == 3 && player.getInventory().getFood() == 1) {
				selectLoc = 0;
				System.out.println("Burasi tamamlandi");
				System.out.println();
				System.out.println("Safehouse dönüyorsunuz");
			}
			if (selectLoc == 4 && player.getInventory().getFirewood() == 1) {
				selectLoc = 0;
				System.out.println("Burasi tamamlandi");
				System.out.println();
				System.out.println("Safehouse dönüyorsunuz");
			}
			if (selectLoc == 5 && player.getInventory().getWater() == 1) {
				selectLoc = 0;
				System.out.println("Burasi tamamlandi");
				System.out.println();
				System.out.println("Safehouse dönüyorsunuz");
			}
      switch (selectLoc) {
        case 0:
          durum=false;
          break;
        case 1:
          location = new SafeHouse(player);
          break;
        case 2:
          location = new ToolStore(player);
          break;
        case 3:
          location = new Cave(player);
          break;
        case 4:
          location = new Forest(player);
          break; 
        case 5:
          location = new River(player);
          break;  
        default:
          System.out.println("Lütfen geçerli bir bölge giriniz");
      }
      
      
      
      if(durum ==false){
        System.out.println("Bir daha bekleriz");
      }
      if (!location.onLocation()) {
        System.out.println("Kaybettiniz");
        break;
      }
      
      
    }

  }

}
