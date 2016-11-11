package comSemaforos;

public class Writer implements Runnable{
	private RWLock db;
	
	public Writer(RWLock db){
		this.db = db;
	}
	
	@Override
	public void run() {
		while(true){
			SleepUtilities.nap();
			
			db.acquireWriteLock();
			System.out.println("Escrevendo");
			SleepUtilities.nap();
			
			db.releaseWriteLock();
		}
	}

}
