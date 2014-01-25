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
	
	public Attribute(String attributeName){
		this.name = attributeName;
		this.hasValue = true;
		this.attribType = "String";
		this.values = new ArrayList<String>();
	}
	
	public Attribute(String attributeName, ArrayList<String> values){
		this.name = attributeName;
		this.hasValue = true;
		this.attribType = "String";
		this.values = values;
	}
	
	public Attribute(String attributeName,boolean hasValue){
		this.name = attributeName;
		this.hasValue = hasValue;
		this.attribType = "String";
		this.values = new ArrayList<String>();
	}
	
	public Attribute(String attributeName,boolean hasValue, String attribType){
		this.name = attributeName;
		this.hasValue = hasValue;
		this.attribType = attribType;
		this.values = new ArrayList<String>();
	}
	
	public Attribute(String attributeName,boolean hasValue, ArrayList<String> values){
		this.name = attributeName;
		this.hasValue = hasValue;
		this.attribType = "String";
		this.values = values;
	}
	
	public Attribute(String attributeName,boolean hasValue, String attribType, ArrayList<String> values){
		this.name = attributeName;
		this.hasValue = hasValue;
		this.attribType = attribType;
		this.values = values;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean hasValue(){
		return this.hasValue;
	}
	
	public String getAttribType(){
		return this.attribType;
	}
	
	public ArrayList<String> getValues(){
		return this.values;
	}
}
