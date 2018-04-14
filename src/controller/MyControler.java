package controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import exceptions.Exceptons;
import exceptions.Interupted;
import model.PrgState;
import repository.MyIRepository;

public class MyControler implements MyIController {
	MyIRepository repo;
	int displayflag;
	 ExecutorService executor;
	public MyControler(MyIRepository r)
	{
		repo=r;
		displayflag=0;
	}
	@Override
	public void allsteps() throws Exceptons {
	    executor = Executors.newFixedThreadPool(2);
	    while(true){
	    	List<PrgState>  prgList = removeCompletedPrg(repo.getPrgList());
	    	if (prgList.size() == 0 ) 
	    		break;
	    	oneStepForAllPrg(prgList);
	    }
	    executor.shutdownNow();
	}
	@Override
	public String prgtostring() {
		return repo.prgtostring();
	}
	@Override
	public PrgState getcrtprg() {
		return repo.getctrprg();
	}
	@Override
	public void setdisplayflag(int i) {
		displayflag=i;		
	}
	@Override
	public int getdisplayflag() {
		return displayflag;
	}
	@Override
	public Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
		 return heap.entrySet().stream().filter(e->symTableValues.
				 contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}
	@Override
	public void desirialize(String file) throws Exceptons {
		repo.deserialize(file);
	}
	@Override
	public void serialize(String file) throws Exceptons {
		repo.serializeprg(file);
		
	}
	@Override
	public List<PrgState> removeCompletedPrg(List<PrgState> inPrgList) {
		return inPrgList.stream()
                .filter(p -> p.isNotCompleted())
                .collect(Collectors.toList());
	}
	@Override
	public void oneStepForAllPrg(List<PrgState> prgList) throws Exceptons {
		prgList.forEach(prg->{
			try {
				repo.logPrgStateExec(prg);
			} catch (Exceptons e) {
				e.printStackTrace();
				System.err.println(e.getMesage());
			}
		});
        List<Callable<PrgState>> callList = prgList.stream().map((PrgState p)->((Callable<PrgState>)()->{return p.onestep();})).collect(Collectors.toList());
        List<PrgState> newPrgList;
        try {
			newPrgList =executor.invokeAll(callList).stream().map(future->{try {return future.get();}
					catch (InterruptedException | ExecutionException e) {e.printStackTrace();
				System.err.println(e.getMessage());}return null;}).filter(p->p!=null).collect(Collectors.toList());
		} catch (InterruptedException e) {
			throw new Interupted();
		}
        prgList.addAll(newPrgList);
        prgList.forEach(prg->{
			try {
				repo.logPrgStateExec(prg);
			} catch (Exceptons e) {
				e.printStackTrace();
				System.err.println(e.getMesage());
			}
		});
        repo.setPrgList(prgList);
	}
	@Override
	public void prerequar() {
		 executor = Executors.newFixedThreadPool(2);
		
	}
	@Override
	public void shut() {
		 executor.shutdownNow();
		
	}
}
