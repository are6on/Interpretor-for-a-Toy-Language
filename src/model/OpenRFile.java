package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import exceptions.Exceptons;
import exceptions.FileAlreadyExists;
import exceptions.FileNotFound;

public class OpenRFile implements IStmt{
	private String var_file_id;
	private String filename;
	public OpenRFile(String v,String f){
		var_file_id=v;
		filename=f;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		MyIFileTable<Integer,String,BufferedReader> t=state.getfilestable();
		if(t.checkfilename(filename))
			throw new FileAlreadyExists();
		BufferedReader buff=null;
		try {
			buff=new BufferedReader(new FileReader(filename));
			int key=state.uniqkey();
			MyIDictionary<String,Integer> table=state.getdictionary();
			t.add(key, filename, buff);
			table.add(var_file_id, key);
		} catch (FileNotFoundException e) {
			throw new FileNotFound();
		}
		return null;
	}
	@Override
	public String toString() {
		return var_file_id+"=open("+ filename+")";
	}
}
