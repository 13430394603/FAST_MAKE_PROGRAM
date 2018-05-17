package com.awt.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <b>适用于容器，Frame，JPanel<b>
 * @author 威 
 * <br>2018年4月10日 下午11:13:51 
 *
 */
public class ContainerBasiDoMain extends BasiDoMain {
	private List<ContainerDoMain> containers;
	private List<ButtonDoMain> buttons;
	private List<LabelDoMain> labels;
	private List<TextDoMain> texts;
	private List<TextAreaDoMain> textareas;
	private List<RadioDoMain> radios;

	public ContainerBasiDoMain(){
		super();
		containers = new ArrayList<ContainerDoMain>();
		buttons = new ArrayList<ButtonDoMain>();
		labels = new ArrayList<LabelDoMain>();
		texts = new ArrayList<TextDoMain>();
		textareas = new ArrayList<TextAreaDoMain>();
		radios = new ArrayList<RadioDoMain>();
	}
	
	public List<ContainerDoMain> getContainer() {
		return containers;
	}
	public void addContainer(ContainerDoMain container) {
		this.containers.add(container);
	}
	public List<ButtonDoMain> getButton() {
		return buttons;
	}
	public void addButton(ButtonDoMain button) {
		this.buttons.add(button);
	}
	public List<LabelDoMain> getLabel() {
		return labels;
	}
	public void addLabel(LabelDoMain label) {
		this.labels.add(label);
	}
	public List<TextDoMain> getText() {
		return texts;
	}
	public void addText(TextDoMain text) {
		this.texts.add(text);
	}
	
	public List<TextAreaDoMain> getTextarea() {
		return textareas;
	}
	public void addTextarea(TextAreaDoMain textArea) {
		this.textareas.add(textArea);
	}

	public List<RadioDoMain> getRadio() {
		return radios;
	}
	public void addRadio(RadioDoMain radio) {
		this.radios.add(radio);
	}

	protected void appendTo(StringBuilder sb){
		super.appendTo(sb);
		appendItem(sb, "containes", this.containers);
		appendItem(sb, "Buttons", this.buttons);
		appendItem(sb, "Labels", this.labels);
		appendItem(sb, "Texts", this.texts);
	}
}
