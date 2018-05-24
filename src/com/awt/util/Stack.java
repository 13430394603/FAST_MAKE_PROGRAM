package com.awt.util;

public interface Stack <E> {
	public abstract boolean isEmpty() ;
	public abstract boolean push(E e) ;
	public abstract E peek() ;
	public abstract E pop() ;
}
