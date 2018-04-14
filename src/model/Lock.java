package model;

import exceptions.Exceptons;

public class Lock implements IStmt{

	String var;
	public Lock(String v){
		var =v;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		myistack<IStmt> stack=state.getstack();
		MyILockTable t=state.getlocktable();
		MyIDictionary<String,Integer> table=state.getdictionary();
		int index = table.lookup(var);
		t.lock();
		if(t.value(index)==-1)
			t.change(index, state.getid());
		else
			stack.push(new Lock(var));
		t.unlock();
		return null;
	}
	
	@Override
	public String toString() {
		return "lock("+var+")";
	}

}
