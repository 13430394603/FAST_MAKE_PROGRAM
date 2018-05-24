package com.awt.util;

/**
 * 
 * <b>基本数组实现的顺序栈 -- 扩展<b>
 * @author 威 
 * <br>2017年9月30日 下午6:08:04 
 * 
 * @param <E> 
 * 
 */
public class ArrayStackEX<E> implements Stack<E>{
	private Object[] data = null ;
	private int maxSize = 0 ; /*栈容量*/
	private int top = -1 ; /*栈顶指针  会随着元素的插入二递增并且作为栈元素的下标*/
	
	/**
	 * 
	 * 构造函数：根据给定的size初始化栈
	 *
	 */
	public ArrayStackEX(){
		this(10) ;
	}
	public ArrayStackEX(int initialSize){
		if(initialSize >= 0){
			this.maxSize = initialSize ; 
			data = new Object[initialSize] ;
			top = -1 ;
		}else{
			throw new RuntimeException("初始化不能小于0:" +initialSize) ;
		}
	}
	
	/**
	 * 
	 * 判空 
	 * @see
	 * @return
	 * boolean
	 *
	 */
	public boolean isEmpty() {
		return this.top == -1 ? true : false ; 
	}
	public int size(){
		return this.top+1;
	}
	
	/**
	 * 
	 * 进栈，第一个元素top=0
	 * @see
	 * @param e
	 * @return
	 * boolean
	 *
	 */
	public boolean push(E e){
		if(this.top == maxSize - 1){
			throw new RuntimeException("栈已满，无法将元素入栈") ;
		}
		else{
			data[++this.top] = e ;
			return true ;
		}
	}
	
	/**
	 * 
	 * 调用栈顶元素但不删除 
	 * @see
	 * @return
	 * E
	 *
	 */
	@SuppressWarnings("unchecked")
	public E peek() {
		if(this.top == -1){
			throw new RuntimeException("栈为空") ;
		}
		else{
			return (E) data[this.top] ;
		}
	}
	
	/**
	 * 
	 * 从顶部弹出 
	 * @see
	 * @return
	 * E
	 *
	 */
	@SuppressWarnings("unchecked")
	public E pop(){
		if(this.top == -1){
			throw new RuntimeException("栈为空") ;
				
		}else{
			return (E) data[this.top --] ; // 通过top自减来去除顶部元素 
			
		}
			
	}
	
	/**
	 * 
	 * 返回对象在堆栈中的位置，以1为基数
	 * @see
	 * @param e
	 * @return
	 * int
	 *
	 */
	public int search(E e){
		int temp = this.top ;
		while(this.top != -1){
			if(peek() != e){
				this.top -- ;
			}else{
				break ;
			}
		}
		int result = this.top+1 ;
		this.top = temp ;
		return result ;
	}
	@Override
	public String toString(){
		StringBuilder sBuild = new StringBuilder();
		sBuild.append(this.getClass().getSimpleName()).append("[");
		for(int i=0;i<top+1;i++){
			sBuild.append(this.data[i]).append(",");
		}
		if(top != -1) sBuild.deleteCharAt(sBuild.length()-1).append("]");
		return sBuild.toString();
	}
	
}
