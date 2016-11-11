package comMonitores;

public class ReaderWriterLock implements RWLock{
	
	int readerCount = 0;
	boolean busy=false;
	
	@Override
	public synchronized void startRead(){
		try {
			if(busy)
				wait();
		} catch (InterruptedException e) {}
		readerCount++;
		notify();
		
		/*if(readerCount == 1)
			try {
				db.acquire();
			} catch (InterruptedException e) {}
		
		mutex.release();*/
	}
	

	@Override
	public synchronized void startWrite(){
		try{
			if(busy||readerCount != 0){
				wait();
			}
		} catch (InterruptedException e) {}
		busy = true;
	}

	@Override
	public synchronized void endRead(){
		readerCount--;
		
		if(readerCount == 0)
			notify();
	}
	

	@Override
	public synchronized void endWrite(){
		busy = false;
		notify();
	}

}
