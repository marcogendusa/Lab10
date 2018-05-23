package it.polito.tdp.porto.model;

import it.polito.tdp.porto.db.PortoDAO;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		model.createGraph();
		
		PortoDAO porto = new PortoDAO();
		for(Paper p: model.trovaSequenza(porto.getAutore(719), porto.getAutore(132))) {
			System.out.println(p);
		}

	}

}
