package model;

import exceptions.Exceptons;

public class New implements IStmt{
	private String var_name;
	private Exp exp;
	public New(String n, Exp e)
	{
		var_name = n;
		exp = e;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		MyIHeap<Integer> heap = state.getheap();
		MyIDictionary<String,Integer> table=state.getdictionary();
		int val=exp.eval(table,heap);
		int pos = heap.alocate(val);
		if(table.isdefined(var_name))
			table.update(var_name,pos);
		else
			table.add(var_name,pos);
		return null;
	}
	@Override
	public String toString() {
		return "new("+var_name+","+exp.toString()+')';
	}
}
