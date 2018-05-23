package it.polito.tdp.porto.model;

import java.util.HashMap;
import java.util.Map;

public class PaperIDMap {
	
	private Map<Integer, Paper> map;

	public PaperIDMap() {
		map = new HashMap<Integer, Paper>();
	}
	
	public void put(Paper p) {
		if(map.containsKey(p.getEprintid()))
			return;
		map.put(p.getEprintid(), p);
	}
	
	public Paper get(Paper p) {
		Paper old = map.get(p.getEprintid());
		if (old == null) {
			map.put(p.getEprintid(), p);
			return p;
		}
		return old;
	}
	
	public Paper get(int n) {
		return map.get(n);
	}

}
