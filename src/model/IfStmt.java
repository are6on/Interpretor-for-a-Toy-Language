package model;

import exceptions.Exceptons;

public class IfStmt implements IStmt {
	Exp exp;
	IStmt thenS;
	IStmt elseS;
	public IfStmt(Exp e,IStmt t,IStmt l)
	{
		exp=e;
		thenS=t;
		elseS=l;
	}
	@Override
	public String toString() {
		return "IF("+exp.toString()+")THEN("+thenS.toString()+")ELSE("+elseS.toString()+")";
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		myistack<IStmt> s=state.getstack();
		MyIDictionary<String,Integer> table=state.getdictionary();
		MyIHeap<Integer> heap = state.getheap();
		if(exp.eval(table,heap)!=0)
			s.push(thenS);
		else
			s.push(elseS);
		return null;
	}
	
}
