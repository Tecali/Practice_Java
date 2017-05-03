import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerTest extends Thread {
	private final BlockingQueue data;

	public ConsumerTest(BlockingQueue data) {
		this.data = data;
	}

	@Override
	public void run() {
		// while(true){
		System.out.println("Consumer Started " + data.size());
		while (!data.isEmpty()) {

			try {

				// data.wait();
				// data.notifyAll();
				System.out.println("Before Sleep Consumer");
				// Thread.sleep(5000);
				System.out.println("Consumed data is " + data.take());
				//data.take();
			}

			catch (InterruptedException e) {
				// System.out.println("Catch Interuptuble" + e.getMessage());
			}
		}
	}
}
