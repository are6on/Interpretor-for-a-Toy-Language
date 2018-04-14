package model;

import java.io.Serializable;

import exceptions.ListIndexOutOfRange;

public interface MyIList<T> extends Serializable{
	void add(T obj);
	T pop() throws ListIndexOutOfRange;
	boolean isempty();
	String toString();
}
