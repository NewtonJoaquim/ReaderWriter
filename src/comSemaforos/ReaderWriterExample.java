package comSemaforos;
import java.util.concurrent.Semaphore;

public class ReaderWriterExample {
	private static boolean Even = true;
	private static boolean Odd = false;
	
	public static void main(String[] args) {
		
		ReaderWriterLock rwLock = new ReaderWriterLock();
		(new Thread(new Reader(rwLock))).start();
		(new Thread(new Writer(rwLock))).start();
	}
}