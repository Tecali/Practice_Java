import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducerTest {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> data = new ArrayBlockingQueue<Integer>(10);
		Thread pr = new ProducerTest(data);
		Thread ct = new ConsumerTest(data);
		pr.start();
		Thread.sleep(500);
		ct.start();

	}

}
