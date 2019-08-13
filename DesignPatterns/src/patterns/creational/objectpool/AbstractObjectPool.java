package patterns.creational.objectpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractObjectPool implements IObjectPool<IPoolableObject>, IObjectFactory<IPoolableObject> {

	private int size;

	private boolean shutdown;

	private BlockingQueue<IPoolableObject> objects;

	public AbstractObjectPool(int size) {
		this.size = size;
		shutdown = false;
		init();
	}

	/*
	 * initiate the pool with fix size
	 */
	private void init() {
		objects = new LinkedBlockingQueue<>();
		for (int i = 0; i < size; i++) {
			objects.add(createNew());
		}
	}

	@Override
	public IPoolableObject getObject() {
		if (!shutdown) {
			IPoolableObject t = null;

			try {
				t = objects.take();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return t;
		}

		throw new IllegalStateException("Object pool is already shutdown.");
	}

	@Override
	public void releaseObject(IPoolableObject t) {
		try {
			objects.offer(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void shutdown() {
		objects.clear();
	}

	public int size() {
		return objects.size();
	}

}
