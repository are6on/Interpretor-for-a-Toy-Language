package view;

import java.util.List;
import java.util.Scanner;

import controller.MyIController;
import exceptions.DivisionByZero;
import exceptions.EmptyStack;
import exceptions.Exceptons;
import exceptions.InvalidKey;
import model.PrgState;
import repository.MyIRepository;

public class Onestep extends Command {
    private MyIController ctr;
    private String file;
    private MyIRepository repo;
    public Onestep(String key, String desc,MyIController ctr,MyIRepository r,String f){
        super(key, desc);
        this.ctr=ctr;
        file=f;
        repo=r;
    }
    @Override
    public void execute() throws Exceptons {

    	Scanner input=new Scanner(System.in);
        try {
        	ctr.desirialize(file);
			ctr.prerequar();
			while(true){
		    	List<PrgState>  prgList = ctr.removeCompletedPrg(repo.getPrgList());
		    	for(PrgState p:prgList)
		    		System.out.println("\n--------------------------------------------------------------------------------------\n"
		    				+ p.tostring());
		    	if (prgList.size() == 0 ) 
		    		break;
		    	ctr.oneStepForAllPrg(prgList);
		    	input.nextLine();
		    }
			ctr.shut();
		} catch (DivisionByZero | InvalidKey | EmptyStack e) {
			System.out.println(e.getMessage());
		}
    }
}

