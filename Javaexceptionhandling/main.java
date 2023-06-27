public class main {
    public static final MyCalculator my_calculator = new MyCalculator();
    
    public static void main(String[] args) {
      try {
        System.out.println(my_calculator.power(7,-3));
    } catch (Exception e) {
       
        e.printStackTrace();
    }
    }
}
