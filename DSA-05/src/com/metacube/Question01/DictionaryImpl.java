package com.metacube.Question01;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DictionaryImpl implements Dictionary {

    BinarySearchTree tree;

    DictionaryImpl() {
        tree = new BinarySearchTree();
    }

    /**
     * constructor to initialize the dictionary
     * 
     * @param json JSON object
     */
    DictionaryImpl(JSONObject json) {
        this.tree = new BinarySearchTree();
        this.initialize(json);
    }

    // converts the json to hash map then insert into dictionary
    @SuppressWarnings("unchecked")
    private void initialize(JSONObject json) {
        Map<String, String> entries = new HashMap<String, String>();
        try {
            entries = new ObjectMapper().readValue(json.toJSONString(), HashMap.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : entries.keySet()) {

            this.add(key, entries.get(key));
        }

    }

    /**
     * insert a key value in dictionary
     * 
     * @param key
     * @param value
     * @return true , if inserted false, if key is not inserted because key is already present
     */
    @Override
    public boolean add(String key, String value) {
        if (key == null || value == null) {

            throw new NullPointerException("key or value should not be null");
        }
        return this.tree.add(key, value);
    }

    /**
     * remove the key value pair from dictionary
     * 
     * @param key
     * @return true, if removed false, if not found
     * @throws NullPointerException if key is null or Dictionary is empty
     */
    @Override
    public boolean delete(String key) {
        if (key == null) {
            throw new NullPointerException("key can't be null");
        }
        return this.tree.remove(key);
    }

    /**
     * get the value of key
     * 
     * @param key
     * @return value, if found null, if not found
     * @throws NullPointerException if the key is null
     */
    @Override
    public String get(String key) {
        if (key == null) {
            throw new NullPointerException("key can't be null");
        }
        return this.tree.get(key);
    }

    /**
     * @return the sorted list of entries in the dictionary
     */
    @Override
    public Map<String, String> getAll() {
        return this.tree.getAll();
    }

    /**
     * @param key1
     * @param key2
     * @return the sorted list of entries in the dictionary in the range of key1 and key2
     */
    @Override
    public Map<String, String> getRange(String key1, String key2) {
        return this.tree.getRange(key1, key2);
    }



}
