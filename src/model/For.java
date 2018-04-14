package model;

import exceptions.Exceptons;

public class For implements IStmt{
	IStmt e1;
	Exp e2;
	IStmt e3;
	IStmt t;
	public For(IStmt e4,Exp e5,IStmt e6,IStmt t1){
		e1=e4;
		e2=e5;
		e3=e6;
		t=t1;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		myistack<IStmt> stack=state.getstack();
		stack.push(new WhileStmt(e2,new CompStmt(t,e3)));
		stack.push(e1);
		return null;
	}
	@Override
	public String toString() {
		return "FOR("+e1.toString()+";"+e2.toString()+";"+e3.toString()+") "+t.toString();
	}
	

}
