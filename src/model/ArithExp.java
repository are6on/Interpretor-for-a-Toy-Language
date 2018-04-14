package model;

import exceptions.DivisionByZero;
import exceptions.Exceptons;

public class ArithExp extends Exp {
	Exp e1;
	Exp e2;
	int op;
	public ArithExp(int op,Exp e1,Exp e2)
	{
		this.e1=e1;
		this.e2=e2;
		this.op=op;
	}
	@Override
	int eval(MyIDictionary<String,Integer> tbl,MyIHeap<Integer> heap) throws Exceptons {
		switch(op)
		{
		case 0:
			return e1.eval(tbl,heap)+e2.eval(tbl,heap);
		case 1:
			return e1.eval(tbl,heap)-e2.eval(tbl,heap);
		case 2:
			return e1.eval(tbl,heap)*e2.eval(tbl,heap);
		case 3:
			if(e2.eval(tbl,heap)==0)
				throw new DivisionByZero();
			return e1.eval(tbl,heap)/e2.eval(tbl,heap);
		}
		return 0;
	}
	@Override
	public String toString() {
		switch(op)
		{
		case 0:
			return e1.toString()+"+"+e2.toString();
		case 1:
			return e1.toString()+"-"+e2.toString();
		case 2:
			return e1.toString()+"*"+e2.toString();
		case 3:
			return e1.toString()+"/"+e2.toString();
		}
		return null;
	}
	
}
