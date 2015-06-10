package com.interview.evaluationproject.json;


import com.google.gson.annotations.Expose;

public class Document {

@Expose
private Object directionFacing;
@Expose
private Boolean primary;
@Expose
private String reference;
@Expose
private String text;
@Expose
private String type;

/**
*
* @return
* The directionFacing
*/
public Object getDirectionFacing() {
return directionFacing;
}

/**
*
* @param directionFacing
* The directionFacing
*/
public void setDirectionFacing(Object directionFacing) {
this.directionFacing = directionFacing;
}

/**
*
* @return
* The primary
*/
public Boolean getPrimary() {
return primary;
}

/**
*
* @param primary
* The primary
*/
public void setPrimary(Boolean primary) {
this.primary = primary;
}

/**
*
* @return
* The reference
*/
public String getReference() {
return reference;
}

/**
*
* @param reference
* The reference
*/
public void setReference(String reference) {
this.reference = reference;
}

/**
*
* @return
* The text
*/
public String getText() {
return text;
}

/**
*
* @param text
* The text
*/
public void setText(String text) {
this.text = text;
}

/**
*
* @return
* The type
*/
public String getType() {
return type;
}

/**
*
* @param type
* The type
*/
public void setType(String type) {
this.type = type;
}

}