package model;

import exceptions.Exceptons;

public class ReadHeap extends Exp{
	private String var_name;
	public ReadHeap(String n){
		var_name = n;
	}
	@Override
	int eval(MyIDictionary<String, Integer> tbl, MyIHeap<Integer> heap) throws Exceptons {
		int pos=tbl.lookup(var_name);
		return heap.lookup(pos);
	}
	@Override
	public String toString() {
		return "RH("+var_name+')';
	}
}
