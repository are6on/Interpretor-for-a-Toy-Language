package model;

import java.io.Serializable;

import exceptions.Exceptons;

public interface IStmt extends Serializable{
	PrgState execute(PrgState state) throws Exceptons;
	String toString();
}
