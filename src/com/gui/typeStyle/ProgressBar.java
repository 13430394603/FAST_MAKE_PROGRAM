package com.gui.typeStyle;

import javax.swing.ImageIcon;

public class ProgressBar extends AbstaractDefaultPanel {
	private static final long serialVersionUID = -3315051541973397583L;
	
	DefaultJLabel label;
	
	public ProgressBar(){
		this(null);
	}
	public ProgressBar(ImageIcon image){
		super();
		this.setLayout(null);
		this.setVisible(true);
		label = new DefaultJLabel();
		label.setBackgroundImage(image);
		this.add(label);
	}
	public void setBackgroundImage(ImageIcon backgroundImage) {
		label.setBackgroundImage(backgroundImage);
	}
	public ImageIcon getBackgroundImage(){
		return label.getBackgroundImage();
	}
	public void setOrigSize(int width, int height){
		label.setSize(width, height);
	}
	public int getOrigWidth(){
		return label.getWidth();
	}
	public int getOrigHeight(){
		return label.getHeight();
	}
	public void slideInit(){
		this.setSize(0, 0);
	}
	public void slideTo(int val){
		System.out.println(val+"-"+this.getOrigHeight());
		this.setSize(val, this.getOrigHeight());
	}
}

