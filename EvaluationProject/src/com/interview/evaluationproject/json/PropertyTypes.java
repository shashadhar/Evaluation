package com.interview.evaluationproject.json;


import com.google.gson.annotations.Expose;

public class PropertyTypes {

@Expose
private com.interview.evaluationproject.json.Apartments Apartments;

/**
*
* @return
* The Apartments
*/
public com.interview.evaluationproject.json.Apartments getApartments() {
return Apartments;
}

/**
*
* @param Apartments
* The Apartments
*/
public void setApartments(com.interview.evaluationproject.json.Apartments Apartments) {
this.Apartments = Apartments;
}

}