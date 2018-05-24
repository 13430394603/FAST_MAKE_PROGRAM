package com.awt.util;

/**
 * 
 * <b>链式栈 -- 扩展<b>
 * @author 威 
 * <br>2017年9月30日 下午7:09:03 
 * @see
 * 	<p>通过一个内部节点类间接保存数据
 * 	<br>栈的容量不需要给定
 * @param <E>
 * 
 */
public class NodeStackEX<E> implements Stack<E>{
	private int size = 0 ;
	private Node<E> top ;
	
	public int length(){
		return size ;
	}
	
	public E pop(){
		if(isEmpty())
			throw new RuntimeException("栈为空！") ;
		else{
			Node<E> value = top ; 	/*将当前的节点赋值于value*/
			top = top.next ; 		/*将当前的节点指向下一个节点量*/
			value.next = null ; 	/*将当前的节点回收*/ 
			size-- ;
			return value.e ;	
		}
	}
	
	public boolean isEmpty(){
		return size == 0 ;
	}

	public boolean push(E e) {
		top = new Node<E>(e, top) ;
		size++ ;
		return true ;
	}

	public E peek() {
		if(isEmpty())
			throw new RuntimeException("栈为空！") ;
		else 
			return top.e ;
	}
	
	/**
	 * 
	 * <b>节点 间接保存数据<b>
	 * @author 威 
	 * <br>2017年9月30日 下午8:16:59 
	 * 
	 * @param <E>
	 * 
	 */
	@SuppressWarnings("hiding")
	class Node<E> {
		private E e ;
		private Node<E> next ;
		/**
		 * 
		 * Node构造方法 每次创建节点时传入上一个创建的节点
		 * @param e
		 * @param next
		 *
		 */
		public Node(E e, Node<E> next){
			this.e = e ;
			this.next = next ;
		}
	}

}
