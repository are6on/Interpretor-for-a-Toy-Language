package model;

import java.io.Serializable;

import exceptions.EmptyStack;

public interface myistack<T> extends Serializable{
	void push(T obj);
	T pop() throws EmptyStack;
	boolean isempty();
	String toString();
}

