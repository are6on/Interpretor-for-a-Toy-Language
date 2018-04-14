package repository;

import java.util.List;

import exceptions.Exceptons;
import model.PrgState;

public interface MyIRepository {
	PrgState getctrprg();
	String prgtostring();
	void addprg(PrgState p);
	void logPrgStateExec(PrgState p) throws Exceptons;
	void serializeprg(String file) throws Exceptons;
	void deserialize(String file)throws Exceptons;
	List<PrgState> getPrgList();
	void setPrgList(List<PrgState> p);

}
