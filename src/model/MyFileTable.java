package model;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidKey;


public class MyFileTable<T1,T2,T3> implements MyIFileTable<T1,T2,T3>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4377936715446105372L;
	Map<T1,Object[]> table;
	int count;
	public MyFileTable(){
		table=new HashMap<T1,Object[]>();
		count=0;
	}
	@Override
	public void add(T1 key,T2 filename, T3 r) {
		Object o[]=new Object[2];
		o[0]=filename;
		o[1]=r;
		table.put(key, o);
	}

	@Override
	public boolean checkfilename(T2 filename) {
		Collection<Object[]> c=table.values();
		for(Object[] e:c)
			if((String)e[0]==filename)
				return true;
		return false;
	}

	@Override
	public T1 getid(T2 filename) throws InvalidKey {
		java.util.Iterator<T1> e=table.keySet().iterator();
		while(e.hasNext())
		{
			T1 key=e.next();
			if((String)table.get(key)[0]==filename)
				return key;
		}
		throw new InvalidKey();
	}

	@Override
	public T3 getbuff(T1 key) throws InvalidKey {
		if(table.containsKey(key))
		return (T3)table.get(key)[1];
		else throw new InvalidKey();
	}

	@Override
	public void pop(T1 key) throws InvalidKey {
		if(table.containsKey(key))
		table.remove(key);
		else throw new InvalidKey();
	}
	@Override
	public String toString(){
		String msg="";
		if(table.isEmpty())
			return "";
		else
			for (Map.Entry<T1, Object[]> e : table.entrySet())
				msg+=e.getKey().toString()+"->"+(T2)e.getValue()[0].toString();
		return msg;
	}
	@Override
	public boolean isEpty() {
		return table.isEmpty();
	}
	@Override
	public int uniqkey() {
		count++;
		return count;
	}

}
