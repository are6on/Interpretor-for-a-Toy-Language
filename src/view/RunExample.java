package view;

import controller.MyIController;
import exceptions.DivisionByZero;
import exceptions.EmptyStack;
import exceptions.Exceptons;
import exceptions.InvalidKey;

public class RunExample extends Command {
    private MyIController ctr;
    private String file;
    public RunExample(String key, String desc,MyIController ctr,String f){
        super(key, desc);
        this.ctr=ctr;
        file=f;
    }
    @Override
    public void execute() throws Exceptons {

        try {
        	ctr.desirialize(file);
			ctr.allsteps();
		} catch (DivisionByZero | InvalidKey | EmptyStack e) {
			System.out.println(e.getMessage());
		}

       
    }
}
