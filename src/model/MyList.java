package model;
import exceptions.ListIndexOutOfRange;

import java.util.Iterator;
import java.util.LinkedList;

public class MyList<T> implements MyIList<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4780284553440621897L;
	LinkedList<T> list;
	public MyList()
	{
		list=new LinkedList<T>();
	}
	@Override
	public void add(T obj) {
		list.add(obj);
	}
	@Override
	public T pop() throws ListIndexOutOfRange {
		if(list.isEmpty())
			throw new ListIndexOutOfRange();
		return list.removeFirst();
	}
	@Override
	public boolean isempty() {
		return list.isEmpty();
	}
	@Override
	public String toString() {
		Iterator<T> i=list.iterator();
		String msg="";
		while(i.hasNext())
		{
			T s=i.next();
			msg+=s.toString()+'\n';
		}
		return msg;
	}
	
}
