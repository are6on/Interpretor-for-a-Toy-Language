package model;

import exceptions.Exceptons;

public class AssignStmt implements IStmt {
	String id;
	Exp exp;
	public AssignStmt(String id,Exp exp)
	{
		this.id=id;
		this.exp=exp;
	}
	@Override
	public String toString() {
		return id+"="+ exp.toString();
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		MyIDictionary<String,Integer> table=state.getdictionary();
		MyIHeap<Integer> heap = state.getheap();
		int val=exp.eval(table,heap);
		if(table.isdefined(id))
			table.update(id,val);
		else
			table.add(id,val);
		return null;
	}
}
