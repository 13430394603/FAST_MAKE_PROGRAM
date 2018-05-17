package com.awt.test;

import com.awt.domain.Navig;

public class Test {
	public static void main(String[] args){
		Navig pro = new Navig("program", null);
		Navig cnt1 = new Navig("container", null);
		Navig bt = new Navig("button", null);
		Navig la = new Navig("label", null);
		
		cnt1.next.add(bt);
		cnt1.next.add(la);
		
		
		pro.next.add(cnt1);
		
		System.out.println(pro);
	}
}	
