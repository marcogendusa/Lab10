package it.polito.tdp.porto.model;

import java.util.*;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {
	
	private PortoDAO porto = new PortoDAO();
	private Graph<Author, DefaultEdge> graph;
	private List<Author> autori;
	private List<Paper> paper;

	
	public Model() {
		graph = new SimpleGraph<Author, DefaultEdge>(DefaultEdge.class);
		AuthorIDMap authorMap = new AuthorIDMap();
		autori = porto.getAllAuthors(authorMap);
		PaperIDMap paperMap = new PaperIDMap();
		paper = porto.getAllPapers(paperMap);
		
		this.createGraph();
		
	}
	
	public Graph<Author, DefaultEdge> createGraph() {
		
		Graphs.addAllVertices(graph, autori);
		
		for(Author a1: autori) {
			for(Author a2: porto.getCoauthors(a1.getId())) {
				if(!graph.containsEdge(a1, a2))
					Graphs.addEdgeWithVertices(this.graph, a1, a2);
			}
		}
		
		//System.out.println("Vertici: "+graph.vertexSet().size());
		//System.out.println("Archi: "+graph.edgeSet().size());
		
		return graph;
	}
	
	public List<Author> getCoautori(Author a) {
		return Graphs.neighborListOf(graph, a);
	}
	
	public List<Author> getNoCoauthors(Author a) {
		List<Author> coautori = Graphs.neighborListOf(graph, a);
		List<Author> l = new LinkedList<Author>();
		for(Author au: autori) {
			if(!coautori.contains(au) && !au.equals(a))
				l.add(au);
		}
		return l;
	}
	
	public List<Paper> trovaSequenza(Author a1, Author a2) {
		
		DijkstraShortestPath<Author, DefaultEdge> spa = new DijkstraShortestPath<Author, DefaultEdge>(graph, a1, a2);
		
		List<DefaultEdge> lista = spa.getPathEdgeList();
		List<Paper> l = new LinkedList<Paper>();
		
		for(DefaultEdge de: lista) {
			Author autore1 = graph.getEdgeSource(de);
			Author autore2 = graph.getEdgeTarget(de);
			Paper p = porto.getPaper(autore1.getId(), autore2.getId());
			l.add(p);

		}
		return l;
	}

	public List<Author> getAutori() {
		return autori;
	}


}
