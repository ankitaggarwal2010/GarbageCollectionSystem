package com.accolite.gc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GC {

	private static HashMap<Integer,Reference> referenceMap=new HashMap<Integer,Reference>();
	private static Reference root=new Reference(new Object());
	private static Set<Integer> releaseObjects=new HashSet<Integer>();
	private static ExecutorService gcExecutor=Executors.newSingleThreadExecutor();
	
	public static void getReference(Object obj1) {
		// TODO Auto-generated method stub
	  createReference(obj1,0);	
	//System.out.println("In Getreference");
	}

	private static void createReference(Object obj1, int i) {
		// TODO Auto-generated method stub
		if(obj1 == null)
			 return ;
		int hashCode=obj1.hashCode();
		
		Reference reference= referenceMap.get(hashCode);
		if(reference == null)
		{
		 System.out.println("Create the references in Graph for object :"+obj1.getClass()+" , "+obj1.hashCode());	
		 reference=new Reference(obj1);	
		}	
		if(i==0)
		 root.addReference(reference);		
		
	}
// Loosing the connection by releasing the object
	@SuppressWarnings("unused")
	public static void releaseReference(Object obj1) {
		// TODO Auto-generated method stub
		System.out.println("Release the reference so that to make the object eligible for GC for objecty :"+obj1.getClass()+" , "+obj1.hashCode());
		if(obj1==null)
			return;
		releaseObjects.add(obj1.hashCode());		
	}
    
	// Call GC to reclaim the memory for the objects that had loose their connections
	public static void gc() throws InterruptedException {
		// TODO Auto-generated method stub
		Set<Integer> setReleaseObjects=new HashSet<Integer>(releaseObjects); 
		gcExecutor.submit(new GCtask(root,setReleaseObjects));
		
		Thread.sleep(10);
		System.out.println("Clean up process completed for :"+releaseObjects);
		//releaseObjects.forEach(obj->obj.hashCode());
		releaseObjects.clear();
	}

}
