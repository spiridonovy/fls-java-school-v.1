import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args)  {
        CyclicBarrier barrier = new CyclicBarrier(2);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Long> resultCaW;
        Future<Long> resultSynch;

        ArrayList<Integer> list = new ArrayList<Integer>(1000000);
        for (int i = 0; i < 1000000; i++){
            list.add(i);
        }

        TestList testSynchArrayList = new TestSynchArrayList(barrier, list);
        TestList testCopyAndWriteArrayList = new TestCopyAndWriteArrayList(barrier, list);

        resultCaW = executor.submit(testCopyAndWriteArrayList);
        resultSynch = executor.submit(testSynchArrayList);

        try {
            System.out.println("result SynchArrayList - " + resultSynch.get());
            System.out.println("result CopyAndWriteArrayList - " + resultCaW.get());
        } catch (InterruptedException exc){
            System.out.println(exc);
        } catch (ExecutionException exc){
            System.out.println(exc);
        }

        executor.shutdown();
    }
}
