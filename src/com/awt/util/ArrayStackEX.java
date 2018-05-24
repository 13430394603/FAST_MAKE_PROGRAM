package com.awt.util;

/**
 * 
 * <b>��������ʵ�ֵ�˳��ջ -- ��չ<b>
 * @author �� 
 * <br>2017��9��30�� ����6:08:04 
 * 
 * @param <E> 
 * 
 */
public class ArrayStackEX<E> implements Stack<E>{
	private Object[] data = null ;
	private int maxSize = 0 ; /*ջ����*/
	private int top = -1 ; /*ջ��ָ��  ������Ԫ�صĲ��������������ΪջԪ�ص��±�*/
	
	/**
	 * 
	 * ���캯�������ݸ�����size��ʼ��ջ
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
			throw new RuntimeException("��ʼ������С��0:" +initialSize) ;
		}
	}
	
	/**
	 * 
	 * �п� 
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
	 * ��ջ����һ��Ԫ��top=0
	 * @see
	 * @param e
	 * @return
	 * boolean
	 *
	 */
	public boolean push(E e){
		if(this.top == maxSize - 1){
			throw new RuntimeException("ջ�������޷���Ԫ����ջ") ;
		}
		else{
			data[++this.top] = e ;
			return true ;
		}
	}
	
	/**
	 * 
	 * ����ջ��Ԫ�ص���ɾ�� 
	 * @see
	 * @return
	 * E
	 *
	 */
	@SuppressWarnings("unchecked")
	public E peek() {
		if(this.top == -1){
			throw new RuntimeException("ջΪ��") ;
		}
		else{
			return (E) data[this.top] ;
		}
	}
	
	/**
	 * 
	 * �Ӷ������� 
	 * @see
	 * @return
	 * E
	 *
	 */
	@SuppressWarnings("unchecked")
	public E pop(){
		if(this.top == -1){
			throw new RuntimeException("ջΪ��") ;
				
		}else{
			return (E) data[this.top --] ; // ͨ��top�Լ���ȥ������Ԫ�� 
			
		}
			
	}
	
	/**
	 * 
	 * ���ض����ڶ�ջ�е�λ�ã���1Ϊ����
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
