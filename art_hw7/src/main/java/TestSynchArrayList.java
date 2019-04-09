import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class TestSynchArrayList extends TestList {

    TestSynchArrayList(CyclicBarrier barrier, List list) {
        super(barrier, list);
        this.list = Collections.synchronizedList(list);
        name = "TestSynchArrayList";
    }
}
