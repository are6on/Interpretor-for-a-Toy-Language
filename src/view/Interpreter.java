package view;

import controller.MyControler;
import controller.MyIController;
import exceptions.Exceptons;
import model.*;
import repository.MyIRepository;
import repository.MyRepository;

import java.io.BufferedReader;

public class Interpreter {
	public static void main(String[] args) {
		IStmt ex1=new CompStmt(new AssignStmt("v",new ConstExp(20)),new CompStmt(new For(
				new AssignStmt("v",new ConstExp(0)),new LT(new VarExp("v"),new ConstExp(3)),new AssignStmt("v",new
						ArithExp(0,new VarExp("v"),new ConstExp(1))),new ForkStmt(new CompStmt(
								new PrintStmt(new VarExp("v")), new AssignStmt("v",new
						ArithExp(0,new VarExp("v"),new ConstExp(1)))))),new PrintStmt(new ArithExp(2,new VarExp("v"),new ConstExp(10)))));
		PrgState prg1 = new PrgState(1,new Mystack<IStmt>(), new MyDictionary<String,Integer>(), new MyList<Integer>(),
				new MyFileTable<Integer,String,BufferedReader>(), new MyHeap<Integer>(),new MyLockTable(), ex1);
		MyIRepository repo1 = new MyRepository(prg1,"log1.txt");
		MyIController ctr1 = new MyControler(repo1);
		try {
			ctr1.serialize("prg1.txt");
		} catch (Exceptons e) {
			System.err.println(e.getMesage());
		}		
		IStmt ex2=new CompStmt(new New("v1",new ConstExp(20)),new CompStmt(new New("v2",new ConstExp(30)),new CompStmt(
				new Newlock("x"),new CompStmt(new ForkStmt(new CompStmt(new ForkStmt(new CompStmt(new Lock("x"),new CompStmt(new
						WriteHeap("v1",new ArithExp(1,new ReadHeap("v1"),new ConstExp(1))), new Unlock("x")))),
						new CompStmt(new Lock("x"),new CompStmt(new
						WriteHeap("v1",new ArithExp(0,new ReadHeap("v1"),new ConstExp(1))), new Unlock("x"))))),
						new CompStmt(new Newlock("q"),new CompStmt(new ForkStmt(new CompStmt(new ForkStmt(
								new CompStmt(new Lock("q"),new CompStmt(new
										WriteHeap("v2",new ArithExp(0,new ReadHeap("v2"),new ConstExp(5))), new Unlock("q"))
								)),new CompStmt(new AssignStmt("m",new ConstExp(100)),
										new CompStmt(new Lock("q"),new CompStmt(new
												WriteHeap("v2",new ArithExp(0,new ReadHeap("v2"),new ConstExp(1))), new Unlock("q")))
										))),new CompStmt(new AssignStmt("z",new ConstExp(200)),new CompStmt(new AssignStmt("z",new ConstExp(300))
												,new CompStmt(new AssignStmt("z",new ConstExp(400)),new CompStmt(new Lock("x"),
														new CompStmt(new PrintStmt(new ReadHeap("v1")),new CompStmt(new Unlock("x"),
									new CompStmt(new Lock("q"),new CompStmt(new PrintStmt(new ReadHeap("v2")),new Unlock("q")))))))))
						))))));
		PrgState prg2 = new PrgState(2,new Mystack<IStmt>(), new MyDictionary<String,Integer>(), new MyList<Integer>(),
				new MyFileTable<Integer,String,BufferedReader>(), new MyHeap<Integer>(),new MyLockTable(), ex2);
		MyIRepository repo2 = new MyRepository(prg2,"log2.txt");
		MyIController ctr2 = new MyControler(repo2);
		try {
			ctr2.serialize("prg2.txt");
		} catch (Exceptons e) {
			System.err.println(e.getMesage());
		}
		
		TextMenu menu = new TextMenu();
		menu.addCommand(new ExitCommand("0", "exit"));
		menu.addCommand(new RunExample("1",ex1.toString(),ctr1,"prg1.txt"));
		menu.addCommand(new RunExample("2",ex2.toString(),ctr2,"prg2.txt"));
		menu.addCommand(new Onestep("3",ex1.toString(),ctr1,repo1,"prg1.txt"));
		menu.addCommand(new Onestep("4",ex2.toString(),ctr2,repo2,"prg2.txt"));
		menu.show();
		}
}
