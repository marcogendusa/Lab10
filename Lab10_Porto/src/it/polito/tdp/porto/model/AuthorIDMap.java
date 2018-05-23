package it.polito.tdp.porto.model;

import java.util.*;

public class AuthorIDMap {
	
	private Map<Integer, Author> map;

	public AuthorIDMap() {
		map = new HashMap<Integer, Author>();
	}
	
	public void put(Author a) {
		if(map.containsKey(a.getId()))
			return;
		map.put(a.getId(), a);
	}
	
	public Author get(Author a) {
		Author old = map.get(a.getId());
		if (old == null) {
			map.put(a.getId(), a);
			return a;
		}
		return old;
	}
	
	public Author get(int n) {
		return map.get(n);
	}
	

}
