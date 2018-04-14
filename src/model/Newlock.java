package model;

import exceptions.Exceptons;

public class Newlock implements IStmt{
	String var;
	public Newlock(String s)
	{
		var = s;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		MyIDictionary<String,Integer> table=state.getdictionary();
		MyILockTable lock = state.getlocktable();
		lock.lock();
		int i = lock.alocate();
		if(table.isdefined(var))
			table.update(var, i);
		else
			table.add(var, i);
		lock.unlock();
		return null;
	}
	@Override
	public String toString() {
		return "newlock("+var;
	}

}
