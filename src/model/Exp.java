package model;

import java.io.Serializable;

import exceptions.Exceptons;

public abstract class Exp implements Serializable{
	abstract int eval(MyIDictionary<String,Integer> tbl,MyIHeap<Integer> heap) throws Exceptons;
	public String toString(){return null;}
}
