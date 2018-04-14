package model;

import exceptions.Exceptons;

public class WriteHeap implements IStmt{
	private String var_name;
	private Exp exp;
	public WriteHeap(String n,Exp e){
		var_name = n;
		exp = e;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons  {
		MyIDictionary<String,Integer> table=state.getdictionary();
		MyIHeap<Integer> heap = state.getheap();
		int pos = table.lookup(var_name);
		int value = exp.eval(table, heap);
		heap.change(pos, value);
		return null;
	}
	@Override
	public String toString() {
		return "WH("+var_name+','+exp.toString()+')';
	}
	
	
}
