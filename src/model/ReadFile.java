package model;

import java.io.BufferedReader;
import java.io.IOException;

import exceptions.Exceptons;
import exceptions.WrongFormat;

public class ReadFile implements IStmt{
	private String var_file_id;
	private String var_name;
	public ReadFile(String v,String n){
		var_file_id=v;
		var_name=n;
	}
	@Override
	public PrgState execute(PrgState state) throws Exceptons {
		MyIDictionary<String,Integer> d=state.getdictionary();
		int key=d.lookup(var_file_id);
		MyIFileTable<Integer,String,BufferedReader> t=state.getfilestable();
		BufferedReader buff=t.getbuff(key);
		try {
			String val=buff.readLine();
			if(val==null)
				d.add(var_name, 0);
			else
				if(d.isdefined(var_name))
					d.update(var_name, Integer.parseInt(val));
				else
					try{
						d.add(var_name, Integer.parseInt(val));
					}catch(NumberFormatException e){
						throw new WrongFormat();
					}
		} catch (IOException e) {}
		return null;
	}
	@Override
	public String toString() {
		return var_name+"=readline("+var_file_id+")";
	}

}
