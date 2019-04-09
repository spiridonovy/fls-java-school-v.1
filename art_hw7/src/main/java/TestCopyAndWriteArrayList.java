import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

public class TestCopyAndWriteArrayList extends TestList {
    TestCopyAndWriteArrayList(CyclicBarrier barrier, List list) {
        super(barrier, list);
        this.list = new CopyOnWriteArrayList(list);
        name = "TestCopyAndWriteArrayList";
    }
}
