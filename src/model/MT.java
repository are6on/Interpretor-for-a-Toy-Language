package model;

import exceptions.Exceptons;

public class MT  extends Exp{
	Exp e1;
	Exp e2;
	public MT(Exp e3,Exp e4){
		e1=e3;
		e2=e4;
	}
	@Override
	public int eval(MyIDictionary<String, Integer> tbl, MyIHeap<Integer> heap) throws Exceptons {
		if (e1.eval(tbl, heap) > e2.eval(tbl, heap))
			return 1;
		else
			return 0;
	}
	@Override
	public String toString() {
		return e1.toString()+" > "+e2.toString();
	}
}
