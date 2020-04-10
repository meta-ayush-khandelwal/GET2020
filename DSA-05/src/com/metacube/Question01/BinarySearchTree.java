package com.metacube.Question01;

import java.util.LinkedHashMap;
import java.util.Map;

public class BinarySearchTree {
	BSTNode root;
	Map<String,String> keyValueList = new LinkedHashMap<String,String>();
	
	BinarySearchTree(){
		this.root = null;
	}
	
	/**
	 * add the key value pair to the BST
	 * @param key
	 * @param value
	 * @return true if added, else false`
	 */
	public boolean add(String key,String value){
		if(root == null){
			root = new BSTNode(null,key,value);
			return true;
		}
		else{
			return root.add(key,value);
		}
	}
	/**
	 * 
	 * @param key
	 * @return the value of a key, if found, else null
	 */
	public String get(String key){
		BSTNode node = this.root.get(key);
	    
	    return (node == null?null:node.getValue());
	}
	

	/**
     * @return the sorted list of entries in the dictionary 
     */
	public Map<String,String> getAll(){ 
	    this.treeToList(this.root);
        
	    Map<String,String> result = this.keyValueList;
        this.keyValueList = new LinkedHashMap<String,String>();
        return result;
	    
	}
    /**
     * @param key1
     * @param key2
     * @return the sorted list of entries in the dictionary in the range of key1 and key2
     */
	public Map<String,String> getRange(String key1,String key2){
	     this.treeToListRange(this.root, key1, key2);
	     Map<String,String> result = this.keyValueList;
	    this.keyValueList = new LinkedHashMap<String,String>();
	     return result;
	}
	// create a HashMap by traversing the tree inorder
	private void treeToList(BSTNode node){
	    
	    if(node == null) {
	        return;
	    }
	    treeToList(node.getLeft());
	    
	    this.keyValueList.put(node.getKey(),node.getValue());
	    treeToList(node.getRight());
	    
	}
	
	// create a HashMap by traversing the tree until key2 only put in map if if in range
	private void treeToListRange(BSTNode node,String key1,String key2){
        
        if(node == null || node.getKey().compareTo(key2)>0) {
            
            return;
        }
        treeToListRange(node.getLeft(),key1,key2);
        if((node.getKey().equals(key1)||node.getKey().compareTo(key1)>0 )&&
            (node.getKey().equals(key2)||node.getKey().compareTo(key2)<0)) {
                    
                    this.keyValueList.put(node.getKey(),node.getValue());  
        }
        treeToListRange(node.getRight(),key1,key2);
    }
	/**
     * remove the key value pair from dictionary
     * @param key   
     * @return  true, if removed
     *          false, if not found
     * @throws NullPointerException if key is null or Dictionary is empty
     */
	boolean remove(String key){
		if(this.root==null){
			throw new NullPointerException(" tree is empty");
		}
		BSTNode nodeToBeDeleted = this.root.get(key);
		if(nodeToBeDeleted == null){
			return false;
		}
		//node with 0 child
		if(nodeToBeDeleted.getLeft()==null && nodeToBeDeleted.getRight()==null){
			BSTNode parent = nodeToBeDeleted.getParent();
			if(parent.getKey().compareTo(nodeToBeDeleted.getKey())>0){			//key is small then parent
				parent.setLeft(null);
			}
			else{
				parent.setRight(null);
			}
		}
		// node with  child
		else if(nodeToBeDeleted.getRight() == null){
			BSTNode parent = nodeToBeDeleted.getParent();
			BSTNode leftChild = nodeToBeDeleted.getLeft();
			
			leftChild.setParent(parent);  // set the parent of left child
			
			if(parent.getKey().compareTo(nodeToBeDeleted.getKey())>0){			//key is small then parent
				parent.setLeft(leftChild);
			}
			else{
				parent.setRight(leftChild);
			}
		}
		else{
			BSTNode inOrderNode = nodeToBeDeleted.getRight().minNode();
			if(inOrderNode.getParent().getKey().compareTo(inOrderNode.getKey())>0){			//key is small then parent
				inOrderNode.getParent().setLeft(null);
			}
			else{
				inOrderNode.getParent().setRight(null);
			}
			inOrderNode.setParent(nodeToBeDeleted.getParent());
			inOrderNode.setLeft(nodeToBeDeleted.getLeft());
			inOrderNode.setRight(nodeToBeDeleted.getRight());
			BSTNode parent = nodeToBeDeleted.getParent();
			if(parent == null){
				this.root = inOrderNode;
			}
			else{
				if(parent.getKey().compareTo(nodeToBeDeleted.getKey())>0){			//key is small then parent
					parent.setLeft(inOrderNode);
				}
				else{
					parent.setRight(inOrderNode);
				}
			}
			if(nodeToBeDeleted.getLeft() != null){
				nodeToBeDeleted.getLeft().setParent(inOrderNode);
			}
			if(nodeToBeDeleted.getRight()!= null){
				nodeToBeDeleted.getRight().setParent(inOrderNode);
			}
		}
		return true;
	}
	
	
}
