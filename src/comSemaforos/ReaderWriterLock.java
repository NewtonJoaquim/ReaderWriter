package comSemaforos;
import java.util.concurrent.Semaphore;


public class ReaderWriterLock implements RWLock{

	private Semaphore db = new Semaphore(1);
	private Semaphore mutex = new Semaphore(1);
	private int readerCount = 0;
	
	@Override
	public void acquireReadLock(){
		try {
			mutex.acquire();
		} catch (InterruptedException e) {}
		readerCount++;
		
		if(readerCount == 1)
			try {
				db.acquire();
			} catch (InterruptedException e) {}
		
		mutex.release();
	}
	

	@Override
	public void acquireWriteLock(){
		try {
			db.acquire();
		} catch (InterruptedException e) {}
	}

	@Override
	public void releaseReadLock(){
		try {
			mutex.acquire();
		} catch (InterruptedException e) {}
		readerCount--;
		
		if(readerCount == 0)
			db.release();
		
		mutex.release();
	}
	

	@Override
	
	public void releaseWriteLock(){
		db.release();
	}

}
