import adress.AddressManager;
import adress.HomeAddress;
import insurance.TravelInsurance;
import user.*;



public class main {
    public static void main(String[] args) throws InvalidAuthenticationException {


        AccountManager accountManager = new AccountManager();
		
		
		//created user1 
		User user1 = new User("İbrahim", "Akkul", "ibrahimakkul.98@gmail.com", "123456", "Student", 24);
		
		//insurance added
		user1.getInsurances().add(new TravelInsurance(50000));
		
		//our user now has an address or addresses
		AddressManager addressManager = new AddressManager(user1);
		addressManager.addAddress((new HomeAddress("Türkiye","Diyarbakir","Yenişehir", "X","Y")));
		
		//now user1 has an individualAccount
		Account indAcc1 = new IndividualAccount(user1);
		
		//account added to dataList !! 
		accountManager.getDataList().add(indAcc1);
		
		accountManager.login("ibrahimakkul.98@gmail.com", "123456");

    }

    @SuppressWarnings("serial")
    class InvalidAuthenticationException extends Exception {
        public InvalidAuthenticationException(String message) {
            super(message);
        }
    }
}
