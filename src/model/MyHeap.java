package model;

import java.util.HashMap;
import java.util.Map;

import exceptions.Exceptons;
import exceptions.InvalidKey;

public class MyHeap<T2> implements MyIHeap<T2>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2780534716171094138L;
	private int free;
	private Map<Integer,T2> data;
	public MyHeap()
	{
		free = 1;
		data = new HashMap<Integer,T2>();
	}
	@Override
	public int alocate(T2 value) {
		int key = free;
		data.put(key, value);
		free=freepos();
		return key;
	}
	@Override
	public void change(int key, T2 value) throws Exceptons {
		if(data.containsKey(key))
			data.put(key, value);
		else
			throw new InvalidKey();
	}
	@Override
	public T2 lookup(int key) throws Exceptons {
		if(data.containsKey(key))
			return data.get(key);
		else
			throw new InvalidKey();
	}
	@Override
	public String toString() {
		//return dict.toString();
		String msg="";
		if(data.isEmpty())
			return "";
		else
			for (Map.Entry<Integer,T2> e : data.entrySet())
				msg+=e.getKey().toString()+"->"+e.getValue().toString()+'\n';
		return msg;
	}
	@Override
	public Map<Integer, T2> getContent() {
		return data;
	}
	@Override
	public void setContent(Map<Integer, T2> map) {
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
	
}
