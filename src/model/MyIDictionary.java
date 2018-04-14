package model;

import java.io.Serializable;
import java.util.Map;

import exceptions.InvalidKey;

public interface MyIDictionary<T1,T2> extends Serializable{
	T2 lookup(T1 id) throws InvalidKey;
	boolean isdefined(T1 id);
	void add(T1 id,T2 value);
	void update(T1 id,T2 value);
	boolean isempty();
	
	String toString();
	Map<T1, T2> getContent();
}
