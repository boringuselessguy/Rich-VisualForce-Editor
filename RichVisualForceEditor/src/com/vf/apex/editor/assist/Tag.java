package com.vf.apex.editor.assist;

import java.util.ArrayList;
/**
 * 
 * @author eclipse and AjayHada
 *
 */
public class Tag {

	private String name;
	private boolean hasBody;
	private boolean simple;
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	
	public Tag(String tagName,boolean hasBody){
		this.name = tagName;
		this.hasBody = hasBody;
	}
	
	public Tag(String tagName,boolean hasBody,String[] attributeList){
		this.name = tagName;
		this.hasBody = hasBody;
		for (String attributeName : attributeList) {
			attributes.add(new Attribute(attributeName));
		}
	}
	
	public String getTagName(){
		return this.name;
	}
	
	public void setTagName(String tagName){
		this.name = tagName;
	}
	
	public boolean hasBody(){
		return this.hasBody;
	}
	
	public void addAttribute(String attribute){
		this.attributes.add(new Attribute(attribute));
	}
	
	public void addAttribute(Attribute attribute){
		this.attributes.add(attribute);
	}
	
	public Attribute[] getAttributes(){
		return (Attribute[])this.attributes.toArray(new Attribute[this.attributes.size()]);
	}

	public boolean getSimple() {
		return simple;
	}

	public void setSimple(boolean simple) {
		this.simple = simple;
	}
}
