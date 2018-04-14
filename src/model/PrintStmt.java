package model;

import exceptions.Exceptons;

public class PrintStmt implements IStmt {
	Exp exp;
	public PrintStmt(Exp e)
	{
		exp=e;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "print("+exp.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		MyIList<Integer> list=state.getout();
		MyIDictionary<String,Integer> table=state.getdictionary();
		MyIHeap<Integer> heap = state.getheap();
		list.add(exp.eval(table,heap));
		return null;
	}

}
