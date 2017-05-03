import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProducerTest extends Thread {
	private final BlockingQueue data;
	private static final int MAXSIZE = 10;

	public ProducerTest(BlockingQueue data) {
		this.data = data;
	}

	@Override
	public void run() {
		// while(true){
		System.out.println("Producer Started");
		while (data.size() != MAXSIZE) {
			try {

				// System.out.println("Producer MaxVal");
				// data.wait();
				// data.notifyAll();
				Random r = new Random();
				int val = r.nextInt();
				data.put(val);
				// Thread.sleep(500);
				// data.notifyAll();
				System.out.println("Producing " + val);
			}

			catch (InterruptedException e) {
				// System.out.println("exception" + e.getStackTrace());
				e.printStackTrace();

			}
		}
	}
}
