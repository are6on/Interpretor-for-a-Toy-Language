package model;

import java.util.Stack;

import exceptions.EmptyStack;

public class Mystack<T> implements myistack<T>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2446887664557984347L;
	Stack<T> list;
	public Mystack()
	{
		list=new Stack<T>();
	}
	@Override
	public void push(T obj) {
		this.list.push(obj);
	}

	@Override
	public T pop() throws EmptyStack {
		if(list.empty())
			throw new EmptyStack();
		return list.pop();
	}
	@Override
	public boolean isempty()
	{
		return list.isEmpty();
	}
	@Override
	public String toString() {
		String msg="";
		for(int i=list.size()-1;i>=0;i--)
		{
			msg+=list.elementAt(i).toString()+'\n';
		}
		return msg;
	}
	
	
	
}