package repository;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import exceptions.CantClose;
import exceptions.ClassNotFound;
import exceptions.Exceptons;
import exceptions.FileNotFound;
import model.PrgState;

public class MyRepository implements MyIRepository{
	List<PrgState> data;
	String logFilePath;
	public MyRepository(String l)
	{
		data=new LinkedList<PrgState>();
		logFilePath=l;
	}
	public MyRepository(PrgState s,String l)
	{
		data=new LinkedList<PrgState>();
		data.add(s);
		logFilePath=l;
	}
	@Override
	public PrgState getctrprg() {
		return data.get(0);
	}
	@Override
	public String prgtostring() {
		return getctrprg().tostring();
	}
	@Override
	public void addprg(PrgState p)
	{
		data.add(p);
	}
	@Override
	public void logPrgStateExec(PrgState p) throws Exceptons {
		PrintWriter logFile=null;
		try{
			logFile= new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
			logFile.println(p.tostring());
		}catch(IOException e){
			throw new FileNotFound();
		}finally{
			if(logFile != null)
				logFile.close();
		}
	}
	@Override
	public void deserialize(String file) throws Exceptons {
		PrgState p=null;
		ObjectInputStream in=null;
		try{
			in=new ObjectInputStream(new FileInputStream(file));
			p=(PrgState)in.readObject();
			this.data.add(0, p);
		}catch(IOException e){
			throw new FileNotFound();
		} catch (ClassNotFoundException e) {
			throw new ClassNotFound();
		}finally{
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					throw new CantClose();
				}
		}
	}
	@Override
	public void serializeprg(String file)throws Exceptons {
		ObjectOutputStream out=null;
		try{
			out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(this.getctrprg());
		} catch (IOException e) {
			throw new FileNotFound(); 
		} finally {
		if (out!=null)
		try {
			out.close();
		} catch (IOException e) {
			throw new CantClose();
		}
		}
	}
	@Override
	public List<PrgState> getPrgList() {
		return data;
	}
	@Override
	public void setPrgList(List<PrgState> p) {
		data=p;
	}

}
