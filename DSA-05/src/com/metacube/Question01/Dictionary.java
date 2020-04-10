package com.metacube.Question01;

import java.util.Map;

public interface Dictionary {

	boolean add(String key,String value);
	boolean delete(String key);
	String get(String key);
	Map<String,String> getAll();
	Map<String,String> getRange(String key1,String key2);
}
