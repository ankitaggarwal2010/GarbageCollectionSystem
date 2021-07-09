package com.accolite.gc;

import java.util.HashSet;
import java.util.Set;

public class Reference {
    private Object object; 
	private Set<Reference> references;
	
	public Reference(Object object) {
		super();
		this.object = object;
		this.references = new HashSet<>();
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Set<Reference> getReferences() {
		return references;
	}

	public void setReferences(Set<Reference> references) {
		this.references = references;
	}

	public void addReference(Reference reference) {
		// TODO Auto-generated method stub
		this.references.add(reference);
	}
	
	
	

}
