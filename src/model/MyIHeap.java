package model;

import java.io.Serializable;
import java.util.Map;

import exceptions.Exceptons;

public interface MyIHeap<T2> extends Serializable{
	int alocate(T2 value);
	void change(int key, T2 value) throws Exceptons;
	T2 lookup(int key) throws Exceptons;
	String toString();
	Map<Integer, T2> getContent();
	void setContent(Map<Integer, T2> map);
	int freepos();
}
