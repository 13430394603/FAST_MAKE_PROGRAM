package com.awt.domain;

import java.util.ArrayList;
import java.util.List;

import com.util.domain.DoMain;

/**
 * 
 * <b>xml导航对象实体类<b>
 * @see
 * 文本的规则树状导航对象
 * 解析xml的时候起着导航的作用
 * @author 威 
 * <br>2018年3月31日 下午10:28:28 
 *
 */
public class Navig extends DoMain{
	public String name;
	public List<Navig> next;
	
	public Navig(){
		this("");
	}
	public Navig (String name){
		this.name = name;
		next = new ArrayList<Navig>();
	}
	public Navig (String name, List<Navig> next){
		this.name = name;
		if(next != null)
			this.next = next;
	}
	@Override
	public void appendTo(StringBuilder sb){
		sb.append("name=").append(name);
		appendItem(sb, "next", next);
	}
	/**
	 * 获取特定名称的子导航对象
	 * <p>	 
	 * @param childName
	 * @return
	 * Navig
	 * @since 1.0
	 */
	public Navig getChildNode(String childName){
		for(Navig navi : this.next)
			if(navi.name.equals(childName))
				return navi;
		return null;
	}
	/**
	 * 将一个导航对象插入一个子导航对象
	 * <p>	 
	 * @param nowNavig	要插入的导航对象
	 * void
	 * @see
	 * @since 1.0
	 */
	public void insert(Navig nowNavig){
		next.add(nowNavig);
	}
	
}
