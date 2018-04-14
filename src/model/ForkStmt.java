package model;

import java.io.BufferedReader;
import java.util.Map;

import exceptions.Exceptons;

public class ForkStmt implements IStmt{
	IStmt s;
	public ForkStmt(IStmt st) {
		s=st;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		int id=state.getid()*10;
		myistack<IStmt> stack=new Mystack<IStmt>();
		MyIDictionary<String,Integer> table=new MyDictionary<String,Integer>();
		for (Map.Entry<String, Integer> e : state.getdictionary().getContent().entrySet())
			table.add(e.getKey(), e.getValue());
		MyIList<Integer> out=state.getout();
		MyIFileTable<Integer,String,BufferedReader> files=state.getfilestable();
		MyIHeap<Integer>heap = state.getheap();
		MyILockTable t=state.getlocktable();
		PrgState ps=new PrgState(id,stack,table,out,files,heap,t,s);
		return ps;
	}
	@Override
	public String toString() {
		return "fork("+s.toString()+")";
	}
}
