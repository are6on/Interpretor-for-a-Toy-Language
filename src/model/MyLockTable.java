package model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import exceptions.Exceptons;
import exceptions.InvalidKey;

public class MyLockTable implements MyILockTable{
private int free;
private Map<Integer,Integer> data;
private ReadWriteLock lock = new ReentrantReadWriteLock();

public MyLockTable()
{
	free = 1;
	data = new HashMap<Integer,Integer>();
}
@Override
public int alocate() {
	int key = free;
	data.put(key, -1);
	free=freepos();
	return key;
}
@Override
public void change(int key, int value) throws Exceptons {
	if(data.containsKey(key))
		data.put(key, value);
	else
		throw new InvalidKey();
}
@Override
public int lookup(int key) throws Exceptons {
	if(data.containsKey(key))
		return data.get(key);
	else
	{
		lock.readLock().unlock();
		throw new InvalidKey();
	}
}
@Override
public String toString() {
	//return dict.toString();
	String msg="";
	if(data.isEmpty())
		return "";
	else
		for (Map.Entry<Integer,Integer> e : data.entrySet())
			msg+=e.getKey().toString()+"->"+e.getValue().toString()+'\n';
	return msg;
}
@Override
public Map<Integer, Integer> getContent() {
	return data;
}
@Override
public void setContent(Map<Integer, Integer> map) {
	if(map == null)
		data.clear();
	else
		data=map;
}
@Override
public int freepos(){
	int p=1;
	while(data.containsKey(p))p++;
	return p;}
@Override
public void lock() {
	lock.writeLock().lock();
	
}
@Override
public void unlock() {
	lock.writeLock().unlock();
}
@Override
public int value(int key) {
	return data.get(key);
}

}
