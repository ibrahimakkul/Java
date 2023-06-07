public class Main {
    public static void main(String []args) {
        MyList<Integer> intList = new MyList<>();
intList.add(10);
intList.add(20);
intList.add(30);
System.out.println(intList.toString());  

MyList<String> stringList = new MyList<>();
stringList.add("Hello");
stringList.add("World");
System.out.println(stringList.get(0)); 
System.out.println(stringList.get(1)); 
        
    }
}
