package model;

import exceptions.Exceptons;

public class WhileStmt implements IStmt{
	private Exp e;
	private IStmt st;
	public WhileStmt(Exp ex,IStmt s){
		e=ex;
		st=s;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		myistack<IStmt> stack=state.getstack();
		MyIDictionary<String,Integer> tbl = state.getdictionary();
		MyIHeap<Integer> heap=state.getheap();
		if(e.eval(tbl, heap) != 0)
			{
				stack.push(new WhileStmt(e,st));
				stack.push(st);
			}
		return null;
	}
	@Override
	public String toString() {
		return "WHILE("+e.toString()+") "+st.toString();
	}
	
}
