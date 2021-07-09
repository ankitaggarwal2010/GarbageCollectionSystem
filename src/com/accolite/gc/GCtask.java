package com.accolite.gc;

import java.util.HashSet;
import java.util.Set;

public class GCtask implements Runnable {

	private Reference root;
	private Set<Integer> setReleaseObjects;
	
	public GCtask(Reference root, Set<Integer> setReleaseObjects) {
		// TODO Auto-generated constructor stub
	this.root=root;
	this.setReleaseObjects=setReleaseObjects;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Clean up activity started using Mark and Sweep algorithm");
		Set<Integer> markSet=new HashSet<Integer>();
		
		mark(root,markSet);
		sweep(root,markSet);

	}
   
	// This method will add all the references i.e. that are in use in a set named makSetBit 
	private void mark(Reference root, Set<Integer> markSet) {
		// TODO Auto-generated method stub
		Object obj=root.getObject();
		if(setReleaseObjects.contains(obj.hashCode()))
			return;
		else
			markSet.add(obj.hashCode());
		
		for(Reference ref : root.getReferences())
		{
			mark(ref,markSet);
		}
				
	}
	// This will remove the unused references
	private Reference sweep(Reference root, Set<Integer> markSet) {
		// TODO Auto-generated method stub
		Object obj=root.getObject();
		
		Set<Integer> deleteReferences=new HashSet<Integer>();
		
		for(Reference ref: root.getReferences()) {
			if(sweep(ref,markSet) == null)
				deleteReferences.add(obj.hashCode()); }	 
			
		if(markSet.contains(obj.hashCode()))
			return root; 
		 return null;
	}

}
