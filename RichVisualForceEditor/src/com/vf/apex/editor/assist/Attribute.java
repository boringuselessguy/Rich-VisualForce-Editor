/**
 * 
 */
package com.vf.apex.editor.assist;

import java.util.ArrayList;

/**
 * 
 * @author eclipse and AjayHada
 *
 */
public class Attribute {

	private String name;
	private String attribType;
	private boolean hasValue;
	private ArrayList<String> values;
	
	public Attribute(){
		this.setName("");
		this.setHasValue(true);
		this.setAttribType("String");
		this.setValues(new ArrayList<String>());
	}
	
	public Attribute(String attributeName){
		this.setName(attributeName);
		this.setHasValue(true);
		this.setAttribType("String");
		this.setValues(new ArrayList<String>());
	}
	
	public Attribute(String attributeName, ArrayList<String> values){
		this.setName(attributeName);
		this.setHasValue(true);
		this.setAttribType("String");
		this.setValues(values);
	}
	
	public Attribute(String attributeName,boolean hasValue){
		this.setName(attributeName);
		this.setHasValue(hasValue);
		this.setAttribType("String");
		this.setValues(new ArrayList<String>());
	}
	
	public Attribute(String attributeName,boolean hasValue, String attribType){
		this.setName(attributeName);
		this.setHasValue(hasValue);
		this.setAttribType(attribType);
		this.setValues(new ArrayList<String>());
	}
	
	public Attribute(String attributeName,boolean hasValue, ArrayList<String> values){
		this.setName(attributeName);
		this.setHasValue(hasValue);
		this.setAttribType("String");
		this.setValues(values);
	}
	
	public Attribute(String attributeName,boolean hasValue, String attribType, ArrayList<String> values){
		this.setName(attributeName);
		this.setHasValue(hasValue);
		this.setAttribType(attribType);
		this.setValues(values);
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAttribType(){
		return this.attribType;
	}
	
	public void setAttribType(String attribType) {
		this.attribType = attribType;
	}

	public boolean hasValue(){
		return this.hasValue;
	}

	public void setHasValue(boolean hasValue) {
		this.hasValue = hasValue;
	}
	
	public ArrayList<String> getValues(){
		return this.values;
	}

	public void setValues(ArrayList<String> values) {
		this.values = values;
	}
}
