package model;

import java.io.Serializable;

import exceptions.InvalidKey;

public interface MyIFileTable<T1,T2,T3> extends Serializable{
	boolean checkfilename(T2 filename);
	T1 getid(T2 filename) throws InvalidKey;
	T3 getbuff(T1 key) throws InvalidKey;
	void pop(T1 key) throws InvalidKey;
	String toString();
	void add(T1 key, T2 filename, T3 r);
	boolean isEpty();
	int uniqkey();
}
