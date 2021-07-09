package com.accolite.gc;

import java.util.*;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.*;
import com.accolite.gc.model.Book;
import com.accolite.gc.model.Library;
import com.accolite.gc.model.TestClass;

//Mark-Sweep Collector
public class GarbageCollectorMain {

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
    String packageName="com.accolite.gc.model";
		//
    Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
    Set<Object> set= reflections.getSubTypesOf(Object.class).stream().collect(Collectors.toSet());  
    System.out.println("All the available model classes :"+set);
    
    Iterator<Object> i = set.iterator();
    while (i.hasNext())
        {System.out.println(i.next());}
    
    System.out.println("\n**************\n");
    GarbageCollectordemo();
	}



	private static void GarbageCollectordemo() throws InterruptedException {
		// TODO Auto-generated method stub
		
	TestClass obj1=new TestClass();
	GC.getReference(obj1);
	//System.out.println("Release the reference");
	
	
	Book b=new Book();
	Library l1=new Library(b);
	Library l2=new Library(b);
	GC.getReference(b);
	GC.getReference(l1);
	GC.getReference(l2);
//	GC.getReference(l1);
	GC.releaseReference(obj1);
	GC.releaseReference(l1);
	GC.gc();
	
	}

}
