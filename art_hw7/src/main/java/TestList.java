import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class TestList <T extends List<Integer>> implements Callable<Long> {
    CyclicBarrier barrier;
    T list;
    String name;

    TestList(CyclicBarrier barrier, T list){
        this.barrier = barrier;
        this.list = list;
        name = "test";
    }

    public Long call() throws Exception {

        try{
            barrier.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }


        long start = System.currentTimeMillis();
        System.out.println("Start time " + name + " = " + start);
        for( int elem : list){
            elem++;
        }
        long fin = System.currentTimeMillis();
        System.out.println("fin time " + name + " = " + fin);

        return (fin - start);
    }
}
