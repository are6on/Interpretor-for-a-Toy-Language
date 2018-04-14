package model;

import exceptions.InvalidKey;

public class VarExp extends Exp{
	String id;
	public VarExp(String id)
	{
		this.id=id;
	}
	@Override
	int eval(MyIDictionary<String, Integer> tbl,MyIHeap<Integer> heap) throws InvalidKey {
		return tbl.lookup(id);
	}
	@Override
	public String toString() {
		return id;
	}
	
}
