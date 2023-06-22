import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
     private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

       
        for (int i = 1; i <= 10000; i++) {
            allNumbers.add(i);
        }

      
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        
        int batchSize = allNumbers.size() / THREAD_COUNT;
        for (int i = 0; i < allNumbers.size(); i += batchSize) {
            List<Integer> subList = allNumbers.subList(i, Math.min(i + batchSize, allNumbers.size()));
            executor.submit(new NumberRunnable(subList, evenNumbers, oddNumbers));
        }

        
        executor.shutdown();

       
        while (!executor.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }
    
}
