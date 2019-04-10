import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class SpeedTest {
    private List<Integer> syncList;
    private List<Integer> cowList;

    public SpeedTest() {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            temp.add(i);
        syncList = Collections.synchronizedList(temp);
        cowList = new CopyOnWriteArrayList<>(temp);
    }

    public long testSpeed(List list) throws Exception {
        long startTime = new Date().getTime();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        CountDownLatch finished = new CountDownLatch(list.size() * 10);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    countDownLatch.await();
                    for (int j = 0; j < list.size(); j++) {
                        int num = (int) list.get(j);
                        list.add(j, ++num);
                        list.remove(j+1);
                    }
                    finished.countDown();
                    return null;
                }
            });
            countDownLatch.countDown();
        }
        finished.await(30, TimeUnit.MILLISECONDS);
        long endTime = new Date().getTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        SpeedTest test = new SpeedTest();
        try {
            long syncList = test.testSpeed(test.syncList);
            long cowList = test.testSpeed(test.cowList);
            String theFastest = (syncList < cowList) ? "SynchronizedList" : "CopyOnWriteList";
            System.out.println("The fastest list is: " + theFastest);
            System.out.println("SynchronizedList time: " + syncList + " ms");
            System.out.println("CopyOnWriteList time: " + cowList + " ms");
        } catch (Exception e) {
            System.out.println("Shit happened");
            e.printStackTrace();
        }
        System.out.println("Have a nice day :)");
        System.exit(0);
    }
}
