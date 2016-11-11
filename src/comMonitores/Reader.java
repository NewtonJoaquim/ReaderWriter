package comMonitores;

import comSemaforos.SleepUtilities;

public class Reader implements Runnable{

	private RWLock db; 
	
	Reader(RWLock db){
		this.db = db;
	}

	@Override
	public void run() {
		while(true){
			SleepUtilities.nap();
			db.startRead();
			System.out.println("Lendo");
			SleepUtilities.nap();
			db.endRead();
		}
	}

}
