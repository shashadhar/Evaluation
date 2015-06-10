package com.interview.evaluationproject.json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Summary {

@Expose
private Integer area;
@Expose
private Object bathrooms;
@Expose
private String bedroom;
@Expose
private Object carParking;
@Expose
private List<String> floorPlans = new ArrayList<String>();
@Expose
private Object landArea;
@Expose
private Object noOfUnits;
@Expose
private Integer price;
@Expose
private String propertyType;

/**
*
* @return
* The area
*/
public Integer getArea() {
return area;
}

/**
*
* @param area
* The area
*/
public void setArea(Integer area) {
this.area = area;
}

/**
*
* @return
* The bathrooms
*/
public Object getBathrooms() {
return bathrooms;
}

/**
*
* @param bathrooms
* The bathrooms
*/
public void setBathrooms(Object bathrooms) {
this.bathrooms = bathrooms;
}

/**
*
* @return
* The bedroom
*/
public String getBedroom() {
return bedroom;
}

/**
*
* @param bedroom
* The bedroom
*/
public void setBedroom(String bedroom) {
this.bedroom = bedroom;
}

/**
*
* @return
* The carParking
*/
public Object getCarParking() {
return carParking;
}

/**
*
* @param carParking
* The carParking
*/
public void setCarParking(Object carParking) {
this.carParking = carParking;
}

/**
*
* @return
* The floorPlans
*/
public List<String> getFloorPlans() {
return floorPlans;
}

/**
*
* @param floorPlans
* The floorPlans
*/
public void setFloorPlans(List<String> floorPlans) {
this.floorPlans = floorPlans;
}

/**
*
* @return
* The landArea
*/
public Object getLandArea() {
return landArea;
}

/**
*
* @param landArea
* The landArea
*/
public void setLandArea(Object landArea) {
this.landArea = landArea;
}

/**
*
* @return
* The noOfUnits
*/
public Object getNoOfUnits() {
return noOfUnits;
}

/**
*
* @param noOfUnits
* The noOfUnits
*/
public void setNoOfUnits(Object noOfUnits) {
this.noOfUnits = noOfUnits;
}

/**
*
* @return
* The price
*/
public Integer getPrice() {
return price;
}

/**
*
* @param price
* The price
*/
public void setPrice(Integer price) {
this.price = price;
}

/**
*
* @return
* The propertyType
*/
public String getPropertyType() {
return propertyType;
}

/**
*
* @param propertyType
* The propertyType
*/
public void setPropertyType(String propertyType) {
this.propertyType = propertyType;
}

}
