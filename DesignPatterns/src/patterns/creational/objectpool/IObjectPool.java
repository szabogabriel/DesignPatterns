package patterns.creational.objectpool;

public interface IObjectPool<T> {

	T getObject();

	void releaseObject(T object);

	void shutdown();
}
