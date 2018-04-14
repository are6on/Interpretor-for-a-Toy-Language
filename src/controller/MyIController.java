package controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import exceptions.Exceptons;
import model.PrgState;

public interface MyIController {
	void prerequar();
	void shut();
	void allsteps() throws Exceptons ;
	String prgtostring();
	PrgState getcrtprg();
	void setdisplayflag(int i);
	int getdisplayflag();
	Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer,Integer> heap);
	void desirialize(String file) throws Exceptons;
	void serialize(String file) throws Exceptons;
	List<PrgState> removeCompletedPrg(List<PrgState> inPrgList) ;
	void oneStepForAllPrg(List<PrgState> prgList) throws Exceptons;
}
