package com.interview.evaluationproject.interfaces;

public interface ISqliteStorable {

	String createUID();
	String objectToJson();
	String className();
	ISqliteStorable jsonToObject(String json);
}
