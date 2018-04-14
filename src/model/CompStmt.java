package model;

public class CompStmt implements IStmt {
	IStmt first;
	IStmt second;
	public CompStmt(IStmt first,IStmt second)
	{
		this.first=first;
		this.second=second;
	}
	@Override
	public String toString() {
		return "("+first.toString()+";"+second.toString()+")";
	}

	@Override
	public PrgState execute(PrgState state) {
		myistack<IStmt> s=state.getstack();
		s.push(second);
		s.push(first);
		return null;
	}

}
