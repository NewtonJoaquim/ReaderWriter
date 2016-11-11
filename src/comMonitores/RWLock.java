package comMonitores;

public interface RWLock {
	public abstract void startRead();
	public abstract void endRead();
	public abstract void startWrite();
	public abstract void endWrite();
}
