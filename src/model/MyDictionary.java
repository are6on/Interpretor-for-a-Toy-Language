package model;

import java.util.HashMap;
import java.util.Map;

import exceptions.InvalidKey;

public class MyDictionary<T1,T2> implements MyIDictionary<T1,T2> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3610993632716046187L;
	Map<T1, T2> dict;
	public MyDictionary()
	{
		dict=new HashMap<T1,T2>();
	}
	@Override
	public T2 lookup(T1 id) throws InvalidKey {
		if(dict.containsKey(id))
			return dict.get(id);
		else
			throw new InvalidKey();
	}
	@Override
	public boolean isdefined(T1 id) {
		return dict.containsKey(id);
	}
	@Override
	public void add(T1 id, T2 value) {
		dict.put(id, value);
		
	}
	@Override
	public void update(T1 id, T2 value) {
		dict.put(id, value);
		
	}
	@Override
	public boolean isempty() {
		return dict.isEmpty();
	}
	@Override
	public String toString() {
		//return dict.toString();
		String msg="";
		if(dict.isEmpty())
			return "";
		else
			for (Map.Entry<T1,T2> e : dict.entrySet())
				msg+=e.getKey().toString()+"->"+e.getValue().toString()+'\n';
		return msg;
	}
	@Override
	public Map<T1, T2> getContent() {
		return dict;
	}
	
}
