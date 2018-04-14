package model;

import exceptions.Exceptons;

public class Unlock implements IStmt{
	String var;
	public Unlock(String v){
		var =v;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		MyILockTable t=state.getlocktable();
		MyIDictionary<String,Integer> table=state.getdictionary();
		int index = table.lookup(var);
		t.lock();
		try{
			if(t.value(index)==state.getid())
				t.change(index, -1);
		}
		catch(Exceptons e){}
		t.unlock();
		return null;
	}
	@Override
	public String toString() {
		return "unlock("+var+")";
	}
}
