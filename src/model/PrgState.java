package model;

import java.io.BufferedReader;
import java.io.Serializable;

import exceptions.EmptyStack;
import exceptions.Exceptons;

public class PrgState implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6190764839169998950L;
	myistack<IStmt> stack;
	MyIDictionary<String,Integer> table;
	MyIList<Integer> out;
	MyIFileTable<Integer,String,BufferedReader> files;
	MyIHeap<Integer> heap;
	MyILockTable lock ;
	int id;
	public PrgState()
	{
		id=0;
		stack=new Mystack<IStmt>();
		table=new MyDictionary<String,Integer>();
		out=new MyList<Integer>();
		files=new MyFileTable<Integer,String,BufferedReader>();
		heap = new MyHeap<Integer>();
		lock = new MyLockTable();
	}
	 public Boolean isNotCompleted(){
		if(stack.isempty())
			return false;
		else return true;
	 }
	 public PrgState onestep() throws Exceptons {
			if(stack.isempty()) throw new EmptyStack();
			IStmt crtStmt = stack.pop();
			return crtStmt.execute(this);
		}
	public PrgState(int i,myistack<IStmt> s,MyIDictionary<String,Integer> t,MyIList<Integer> o,MyIFileTable<Integer,String,BufferedReader> f,
			MyIHeap<Integer> h,MyILockTable l,IStmt st)
	{
		id=i;
		stack=s;
		table=t;
		out=o;
		files=f;
		heap = h;
		stack.push(st);
		lock = l;
		
	}
	public myistack<IStmt> getstack()
	{
		return stack;
	}
	public MyIDictionary<String,Integer> getdictionary()
	{
		return table;
	}
	public MyIList<Integer> getout()
	{
		return out;
	}
	public void setstack(myistack<IStmt> stk)
	{
		stack=stk;
	}
	public void setdictionary(MyIDictionary<String,Integer> d)
	{
		table=d;
	}
	public void setout(MyIList<Integer> o)
	{
		out=o;
	}
	public MyIHeap<Integer> getheap()
	{
		return heap;
	}
	public String tostring()
	{
		return Integer.toString(id)+"\nExeStack:\n"+stack.toString()+"SymTable:\n"+table.toString()+"Out:\n"+out.toString()+"File Table:\n"+files.toString()+
				"Heap:\n"+heap.toString()+"LockTable:"+lock.toString();
	}
	public MyIFileTable<Integer,String,BufferedReader> getfilestable()
	{
		return files;
	}
	public int uniqkey(){
		return files.uniqkey();
	}
	public int getid(){
		return id;
	}
	public MyILockTable getlocktable()
	{
		return lock;
	}
	
}
