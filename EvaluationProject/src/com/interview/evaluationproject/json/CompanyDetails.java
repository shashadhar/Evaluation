package com.interview.evaluationproject.json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class CompanyDetails {
private String id;
@Expose
private String addressLine1;
@Expose
private String addressLine2;
@Expose
private Object brochure;
@Expose
private String city;
@Expose
private String description;
@Expose
private List<Document> documents = new ArrayList<Document>();
@Expose
private Boolean hidePrice;
@Expose
private String landmark;
@Expose
private String listingId;
@Expose
private String listingName;
@Expose
private String locality;
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
private String otherInfo;
@Expose
private String packageId;
@Expose
private long posessionDate;
@Expose
private String projectType;
@Expose
private PropertyTypes propertyTypes;
@Expose
private String status;
@Expose
private List<Summary> summary = new ArrayList<Summary>();
@Expose
private String url;
@Expose
private List<Object> videoLinks = new ArrayList<Object>();
@Expose
private List<String> amenities = new ArrayList<String>();
@Expose
private String approvalNumber;
@Expose
private Object approvedBy;
@Expose
private Object bankApprovals;
@Expose
private Object builderCredaiStatus;
@Expose
private String builderDescription;
@Expose
private String builderId;
@Expose
private String builderLogo;
@Expose
private String builderName;
@Expose
private String builderUrl;
@Expose
private String electricityConnection;
@Expose
private Object lastMileLandmark;
@Expose
private Object lastMileLat;
@Expose
private Object lastMileLon;
@Expose
private Double lat;
@Expose
private Double lon;
@Expose
private String otherAmenities;
@Expose
private String otherBanks;
@Expose
private String specification;
@Expose
private String waterTypes;

public String getId() {
return id;
}
public void setId(String Id) {
this.id = Id;
}

/**
*
* @return
* The addressLine1
*/
public String getAddressLine1() {
return addressLine1;
}

/**
*
* @param addressLine1
* The addressLine1
*/
public void setAddressLine1(String addressLine1) {
this.addressLine1 = addressLine1;
}

/**
*
* @return
* The addressLine2
*/
public String getAddressLine2() {
return addressLine2;
}

/**
*
* @param addressLine2
* The addressLine2
*/
public void setAddressLine2(String addressLine2) {
this.addressLine2 = addressLine2;
}

/**
*
* @return
* The brochure
*/
public Object getBrochure() {
return brochure;
}

/**
*
* @param brochure
* The brochure
*/
public void setBrochure(Object brochure) {
this.brochure = brochure;
}

/**
*
* @return
* The city
*/
public String getCity() {
return city;
}

/**
*
* @param city
* The city
*/
public void setCity(String city) {
this.city = city;
}

/**
*
* @return
* The description
*/
public String getDescription() {
return description;
}

/**
*
* @param description
* The description
*/
public void setDescription(String description) {
this.description = description;
}

/**
*
* @return
* The documents
*/
public List<Document> getDocuments() {
return documents;
}

/**
*
* @param documents
* The documents
*/
public void setDocuments(List<Document> documents) {
this.documents = documents;
}

/**
*
* @return
* The hidePrice
*/
public Boolean getHidePrice() {
return hidePrice;
}

/**
*
* @param hidePrice
* The hidePrice
*/
public void setHidePrice(Boolean hidePrice) {
this.hidePrice = hidePrice;
}

/**
*
* @return
* The landmark
*/
public String getLandmark() {
return landmark;
}

/**
*
* @param landmark
* The landmark
*/
public void setLandmark(String landmark) {
this.landmark = landmark;
}

/**
*
* @return
* The listingId
*/
public String getListingId() {
return listingId;
}

/**
*
* @param listingId
* The listingId
*/
public void setListingId(String listingId) {
this.listingId = listingId;
}

/**
*
* @return
* The listingName
*/
public String getListingName() {
return listingName;
}

/**
*
* @param listingName
* The listingName
*/
public void setListingName(String listingName) {
this.listingName = listingName;
}

/**
*
* @return
* The locality
*/
public String getLocality() {
return locality;
}

/**
*
* @param locality
* The locality
*/
public void setLocality(String locality) {
this.locality = locality;
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
* The otherInfo
*/
public String getOtherInfo() {
return otherInfo;
}

/**
*
* @param otherInfo
* The otherInfo
*/
public void setOtherInfo(String otherInfo) {
this.otherInfo = otherInfo;
}

/**
*
* @return
* The packageId
*/
public String getPackageId() {
return packageId;
}

/**
*
* @param packageId
* The packageId
*/
public void setPackageId(String packageId) {
this.packageId = packageId;
}

/**
*
* @return
* The posessionDate
*/
public long getPosessionDate() {
return posessionDate;
}

/**
*
* @param posessionDate
* The posessionDate
*/
public void setPosessionDate(Integer posessionDate) {
this.posessionDate = posessionDate;
}

/**
*
* @return
* The projectType
*/
public String getProjectType() {
return projectType;
}

/**
*
* @param projectType
* The projectType
*/
public void setProjectType(String projectType) {
this.projectType = projectType;
}

/**
*
* @return
* The propertyTypes
*/
public PropertyTypes getPropertyTypes() {
return propertyTypes;
}

/**
*
* @param propertyTypes
* The propertyTypes
*/
public void setPropertyTypes(PropertyTypes propertyTypes) {
this.propertyTypes = propertyTypes;
}

/**
*
* @return
* The status
*/
public String getStatus() {
return status;
}

/**
*
* @param status
* The status
*/
public void setStatus(String status) {
this.status = status;
}

/**
*
* @return
* The summary
*/
public List<Summary> getSummary() {
return summary;
}

/**
*
* @param summary
* The summary
*/
public void setSummary(List<Summary> summary) {
this.summary = summary;
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

/**
*
* @return
* The videoLinks
*/
public List<Object> getVideoLinks() {
return videoLinks;
}

/**
*
* @param videoLinks
* The videoLinks
*/
public void setVideoLinks(List<Object> videoLinks) {
this.videoLinks = videoLinks;
}

/**
*
* @return
* The amenities
*/
public List<String> getAmenities() {
return amenities;
}

/**
*
* @param amenities
* The amenities
*/
public void setAmenities(List<String> amenities) {
this.amenities = amenities;
}

/**
*
* @return
* The approvalNumber
*/
public String getApprovalNumber() {
return approvalNumber;
}

/**
*
* @param approvalNumber
* The approvalNumber
*/
public void setApprovalNumber(String approvalNumber) {
this.approvalNumber = approvalNumber;
}

/**
*
* @return
* The approvedBy
*/
public Object getApprovedBy() {
return approvedBy;
}

/**
*
* @param approvedBy
* The approvedBy
*/
public void setApprovedBy(Object approvedBy) {
this.approvedBy = approvedBy;
}

/**
*
* @return
* The bankApprovals
*/
public Object getBankApprovals() {
return bankApprovals;
}

/**
*
* @param bankApprovals
* The bankApprovals
*/
public void setBankApprovals(Object bankApprovals) {
this.bankApprovals = bankApprovals;
}

/**
*
* @return
* The builderCredaiStatus
*/
public Object getBuilderCredaiStatus() {
return builderCredaiStatus;
}

/**
*
* @param builderCredaiStatus
* The builderCredaiStatus
*/
public void setBuilderCredaiStatus(Object builderCredaiStatus) {
this.builderCredaiStatus = builderCredaiStatus;
}

/**
*
* @return
* The builderDescription
*/
public String getBuilderDescription() {
return builderDescription;
}

/**
*
* @param builderDescription
* The builderDescription
*/
public void setBuilderDescription(String builderDescription) {
this.builderDescription = builderDescription;
}

/**
*
* @return
* The builderId
*/
public String getBuilderId() {
return builderId;
}

/**
*
* @param builderId
* The builderId
*/
public void setBuilderId(String builderId) {
this.builderId = builderId;
}

/**
*
* @return
* The builderLogo
*/
public String getBuilderLogo() {
return builderLogo;
}

/**
*
* @param builderLogo
* The builderLogo
*/
public void setBuilderLogo(String builderLogo) {
this.builderLogo = builderLogo;
}

/**
*
* @return
* The builderName
*/
public String getBuilderName() {
return builderName;
}

/**
*
* @param builderName
* The builderName
*/
public void setBuilderName(String builderName) {
this.builderName = builderName;
}

/**
*
* @return
* The builderUrl
*/
public String getBuilderUrl() {
return builderUrl;
}

/**
*
* @param builderUrl
* The builderUrl
*/
public void setBuilderUrl(String builderUrl) {
this.builderUrl = builderUrl;
}

/**
*
* @return
* The electricityConnection
*/
public String getElectricityConnection() {
return electricityConnection;
}

/**
*
* @param electricityConnection
* The electricityConnection
*/
public void setElectricityConnection(String electricityConnection) {
this.electricityConnection = electricityConnection;
}

/**
*
* @return
* The lastMileLandmark
*/
public Object getLastMileLandmark() {
return lastMileLandmark;
}

/**
*
* @param lastMileLandmark
* The lastMileLandmark
*/
public void setLastMileLandmark(Object lastMileLandmark) {
this.lastMileLandmark = lastMileLandmark;
}

/**
*
* @return
* The lastMileLat
*/
public Object getLastMileLat() {
return lastMileLat;
}

/**
*
* @param lastMileLat
* The lastMileLat
*/
public void setLastMileLat(Object lastMileLat) {
this.lastMileLat = lastMileLat;
}

/**
*
* @return
* The lastMileLon
*/
public Object getLastMileLon() {
return lastMileLon;
}

/**
*
* @param lastMileLon
* The lastMileLon
*/
public void setLastMileLon(Object lastMileLon) {
this.lastMileLon = lastMileLon;
}

/**
*
* @return
* The lat
*/
public Double getLat() {
return lat;
}

/**
*
* @param lat
* The lat
*/
public void setLat(Double lat) {
this.lat = lat;
}

/**
*
* @return
* The lon
*/
public Double getLon() {
return lon;
}

/**
*
* @param lon
* The lon
*/
public void setLon(Double lon) {
this.lon = lon;
}

/**
*
* @return
* The otherAmenities
*/
public String getOtherAmenities() {
return otherAmenities;
}

/**
*
* @param otherAmenities
* The otherAmenities
*/
public void setOtherAmenities(String otherAmenities) {
this.otherAmenities = otherAmenities;
}

/**
*
* @return
* The otherBanks
*/
public String getOtherBanks() {
return otherBanks;
}

/**
*
* @param otherBanks
* The otherBanks
*/
public void setOtherBanks(String otherBanks) {
this.otherBanks = otherBanks;
}

/**
*
* @return
* The specification
*/
public String getSpecification() {
return specification;
}

/**
*
* @param specification
* The specification
*/
public void setSpecification(String specification) {
this.specification = specification;
}

/**
*
* @return
* The waterTypes
*/
public String getWaterTypes() {
return waterTypes;
}

/**
*
* @param waterTypes
* The waterTypes
*/
public void setWaterTypes(String waterTypes) {
this.waterTypes = waterTypes;
}

}