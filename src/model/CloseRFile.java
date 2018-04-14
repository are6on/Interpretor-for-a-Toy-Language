package model;

import java.io.BufferedReader;
import java.io.IOException;

import exceptions.CantClose;
import exceptions.Exceptons;

public class CloseRFile implements IStmt{

	private String var_file_id;
	public CloseRFile(String v){
		var_file_id=v;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		MyIDictionary<String,Integer> table=state.getdictionary();
		MyIHeap<Integer> heap = state.getheap();
		int key=new VarExp(var_file_id).eval(table,heap);
		MyIFileTable<Integer,String,BufferedReader> t=state.getfilestable();
		try {
			t.getbuff(key).close();
			t.pop(key);
		} catch (IOException e) {
			throw new CantClose();
		}
		return null;
	}
	@Override
	public String toString() {
		return var_file_id+".close()";
	}
}
