package com.metacube.Question01;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

    JSONObject json;
    Dictionary dictionary ;
    
    @Before
    public void init() {
        JSONParser parser = new JSONParser();
        try {
            Object jsonObj = parser.parse(new FileReader("C:/Users/Ayush/meta-workspace/DSA-05/src/data.json"));
            json = (JSONObject)jsonObj;
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        dictionary = new DictionaryImpl(json);
    }
    
    
    @Test
    public void getTest() {
        String value = dictionary.get("cancel");
        assertEquals(value,"to decide or announce that a planned event will not take place; call off");
    }
    @Test
    public void getAllTest() {
        Map<String,String> entries = dictionary.getAll();
        Map<String,String> expected = new LinkedHashMap<String,String>();
        expected.put("ballonné","a broad leap with a battement to the front, side, or back.");
        expected.put("cancel","to decide or announce that a planned event will not take place; call off");
        expected.put("formula","a mathematical relationship or rule expressed in symbols.");
        expected.put("gainly","graceful");
        expected.put("kickball","a children's game, similar to baseball, in which a large inflated ball, as a soccer ball, is kicked instead of being batted.");
        expected.put("wagga","Australian a blanket or bed covering made out of sacks stitched together");
        
        assertEquals(expected,entries);
    }
    @Test
    public void getRangeTest() {
        Map<String,String> entries = dictionary.getRange("cancel","kickball");
        Map<String,String> expected = new LinkedHashMap<String,String>();
        expected.put("cancel","to decide or announce that a planned event will not take place; call off");
        expected.put("formula","a mathematical relationship or rule expressed in symbols.");
        expected.put("gainly","graceful");
        expected.put("kickball","a children's game, similar to baseball, in which a large inflated ball, as a soccer ball, is kicked instead of being batted.");
        assertEquals(expected,entries);
    }
    
    @Test
    public void removeTest() {
        dictionary.delete("cancel");
        Map<String,String> entries = dictionary.getAll();
            
            Map<String,String> expected = new LinkedHashMap<String,String>();
            expected.put("ballonné","a broad leap with a battement to the front, side, or back.");
            //expected.put("cancel","to decide or announce that a planned event will not take place; call off");
            expected.put("formula","a mathematical relationship or rule expressed in symbols.");
            expected.put("gainly","graceful");
            expected.put("kickball","a children's game, similar to baseball, in which a large inflated ball, as a soccer ball, is kicked instead of being batted.");
            expected.put("wagga","Australian a blanket or bed covering made out of sacks stitched together");
            
            assertEquals(expected,entries);
        
    }
    
    @Test(expected=NullPointerException.class)
    public void nullKey() {
        dictionary.add(null, "sadf");
    }
    @Test(expected=NullPointerException.class)
    public void nullValue() {
        dictionary.add("ads", null);
    }
    @Test(expected=NullPointerException.class)
    public void keyValueNull (){
        dictionary.add(null, null);
    }
    @Test(expected=NullPointerException.class)
    public void nullDelete(){
        dictionary.delete(null);
    }
    

}
