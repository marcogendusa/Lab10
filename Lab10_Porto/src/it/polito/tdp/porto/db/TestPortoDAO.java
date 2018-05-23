package it.polito.tdp.porto.db;

import it.polito.tdp.porto.model.AuthorIDMap;

public class TestPortoDAO {
	
	public static void main(String args[]) {
		PortoDAO pd = new PortoDAO();
		System.out.println(pd.getAutore(85));
		System.out.println(pd.getArticolo(2293546));
		System.out.println(pd.getArticolo(1941144));
		
		System.out.println(pd.getCoauthors(719).size());
		
		AuthorIDMap authorMap = new AuthorIDMap();
		System.out.println(pd.getAllAuthors(authorMap).size());

	}

}
