package insurance;

public class HealtInsurance extends Insurance {

    public HealtInsurance(int price) {
        super(price);
        
    }

    @Override
    public double calculate() {
        
        return (this.getPrice()*0.12);
    }
    
    

}
