package comSemaforos;


public class Reader implements Runnable{

	private RWLock db; 
	
	Reader(RWLock db){
		this.db = db;
	}

	@Override
	public void run() {
		while(true){
			SleepUtilities.nap();
			db.acquireReadLock();
			System.out.println("Lendo");
			SleepUtilities.nap();
			db.releaseReadLock();
		}
	}

}
