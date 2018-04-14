package model;

import java.io.Serializable;
import java.util.Map;

import exceptions.Exceptons;

public interface MyILockTable extends Serializable{
	int alocate();
	void change(int key, int value) throws Exceptons;
	int lookup(int key) throws Exceptons;
	String toString();
	Map<Integer, Integer> getContent();
	void setContent(Map<Integer, Integer> map);
	int freepos();
	void lock();
	void unlock();
	int value(int key);
}