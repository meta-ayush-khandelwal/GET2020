package com.metacube.Question01;

public class BSTNode {
	private String key,value;
	private BSTNode left,right,parent;
	
	BSTNode(BSTNode parent,String key,String value){
		this.parent = parent;
	    this.key = key;
		this.value = value;
	}
	
	
	public void setKey(String key) {
        this.key = key;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public void setLeft(BSTNode left) {
        this.left = left;
    }


    public void setRight(BSTNode right) {
        this.right = right;
    }


    public void setParent(BSTNode parent) {
        this.parent = parent;
    }


    public String getKey() {
        return key;
    }


    public String getValue() {
        return value;
    }


    public BSTNode getLeft() {
        return left;
    }


    public BSTNode getRight() {
        return right;
    }


    public BSTNode getParent() {
        return parent;
    }


    /**
	 * add the key value pair to the BST
	 * @param key
	 * @param value
	 * @return true if added, else false`
	 */
	public boolean add(String key,String value){
		if(this.key.compareTo(key)>0){
			if(left == null){
				left = new BSTNode(this,key,value);
				return true;
			}
			else{
				left.add(key, value);
			}
		}
		else if(this.key.compareTo(key)<0){
			if(right == null){
				right = new BSTNode(this,key, value);
				return true;
			}
			else{
				right.add(key, value);
			}
		}
		else{
			return false;
		}
		return false;
	}
	
	/**
	 * find a key in the BST
	 * @param key
	 * @return	node containing key, if found 
	 * 			else null
	 */
	public BSTNode get( String key ){
        if ( this.key.equals( key ) ){
            return this;
        }
        if ( key.compareTo( this.key ) < 0 ){
            return left == null ? null : left.get( key );
        }
        else{
            return right == null ? null : right.get( key );
        }
    }
	
	/**
	 * find the minimum node from a node
	 * @return
	 */
	public BSTNode minNode() {
		while(this.left != null) {
	    	return this.left.minNode();
	    }
	    return this;
	}
}
