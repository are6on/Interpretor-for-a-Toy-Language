package model;

public class ConstExp extends Exp{
	int number;
	public ConstExp(int n)
	{
		number=n;
	}
	@Override
	int eval(MyIDictionary<String, Integer> tbl,MyIHeap<Integer> heap) {
		return number;
	}
	@Override
	public String toString() {
		return Integer.toString(number);
	}
	
}
