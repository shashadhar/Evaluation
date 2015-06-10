package com.interview.evaluationproject.json;

import com.google.gson.annotations.Expose;

public class Apartments {

@Expose
private Bedrooms bedrooms;
@Expose
private Integer maxArea;
@Expose
private Integer maxPrice;
@Expose
private Integer maxPricePerSqft;
@Expose
private Integer minArea;
@Expose
private Integer minPrice;
@Expose
private Integer minPricePerSqft;
@Expose
private Object noOfAvailableUnits;
@Expose
private Object noOfBlocks;
@Expose
private Object noOfUnits;
@Expose
private String url;

/**
*
* @return
* The bedrooms
*/
public Bedrooms getBedrooms() {
return bedrooms;
}

/**
*
* @param bedrooms
* The bedrooms
*/
public void setBedrooms(Bedrooms bedrooms) {
this.bedrooms = bedrooms;
}

/**
*
* @return
* The maxArea
*/
public Integer getMaxArea() {
return maxArea;
}

/**
*
* @param maxArea
* The maxArea
*/
public void setMaxArea(Integer maxArea) {
this.maxArea = maxArea;
}

/**
*
* @return
* The maxPrice
*/
public Integer getMaxPrice() {
return maxPrice;
}

/**
*
* @param maxPrice
* The maxPrice
*/
public void setMaxPrice(Integer maxPrice) {
this.maxPrice = maxPrice;
}

/**
*
* @return
* The maxPricePerSqft
*/
public Integer getMaxPricePerSqft() {
return maxPricePerSqft;
}

/**
*
* @param maxPricePerSqft
* The maxPricePerSqft
*/
public void setMaxPricePerSqft(Integer maxPricePerSqft) {
this.maxPricePerSqft = maxPricePerSqft;
}

/**
*
* @return
* The minArea
*/
public Integer getMinArea() {
return minArea;
}

/**
*
* @param minArea
* The minArea
*/
public void setMinArea(Integer minArea) {
this.minArea = minArea;
}

/**
*
* @return
* The minPrice
*/
public Integer getMinPrice() {
return minPrice;
}

/**
*
* @param minPrice
* The minPrice
*/
public void setMinPrice(Integer minPrice) {
this.minPrice = minPrice;
}

/**
*
* @return
* The minPricePerSqft
*/
public Integer getMinPricePerSqft() {
return minPricePerSqft;
}

/**
*
* @param minPricePerSqft
* The minPricePerSqft
*/
public void setMinPricePerSqft(Integer minPricePerSqft) {
this.minPricePerSqft = minPricePerSqft;
}

/**
*
* @return
* The noOfAvailableUnits
*/
public Object getNoOfAvailableUnits() {
return noOfAvailableUnits;
}

/**
*
* @param noOfAvailableUnits
* The noOfAvailableUnits
*/
public void setNoOfAvailableUnits(Object noOfAvailableUnits) {
this.noOfAvailableUnits = noOfAvailableUnits;
}

/**
*
* @return
* The noOfBlocks
*/
public Object getNoOfBlocks() {
return noOfBlocks;
}

/**
*
* @param noOfBlocks
* The noOfBlocks
*/
public void setNoOfBlocks(Object noOfBlocks) {
this.noOfBlocks = noOfBlocks;
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
* The url
*/
public String getUrl() {
return url;
}

/**
*
* @param url
* The url
*/
public void setUrl(String url) {
this.url = url;
}

}