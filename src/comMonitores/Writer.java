package comMonitores;

import comSemaforos.SleepUtilities;

public class Writer implements Runnable{
	private RWLock db;
	
	public Writer(RWLock db){
		this.db = db;
	}
	
	@Override
	public void run() {
		while(true){
			SleepUtilities.nap();
			
			db.startWrite();
			System.out.println("Escrevendo");
			SleepUtilities.nap();
			
			db.endWrite();
		}
	}

}
