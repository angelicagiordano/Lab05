package it.polito.anagrammi.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private int lunghezzaParola;
	private List <String> anagrammi;
	private List <Lettera> lettere;
	
	public Model() {
		lettere= new LinkedList <Lettera>();
		anagrammi = new LinkedList<String>();
		}
	
	
	public List<String> risolvi(String p){
		
		for(int i=0; i<p.length(); i++){
			lettere.add(new Lettera(p.charAt(i), i));
		}
		lunghezzaParola= lettere.size();
		LinkedList <Lettera> parziale= new LinkedList<Lettera>();
		
		calcolaAnagrammi(parziale, 0, anagrammi);
		
		return anagrammi;
		
	}


	private void calcolaAnagrammi(LinkedList<Lettera> parziale, int livello, List<String> anagrammi) {
		if(parziale.size()== lunghezzaParola){
			String s = "";
			for(int i=0; i<parziale.size(); i++){
				s+=parziale.get(i).getCarattere();
			}
			anagrammi.add(s);
		}
		
		for(Lettera l: lettere){
			if(!parziale.contains(l)){
			parziale.add(l);
			calcolaAnagrammi(parziale, livello+1, anagrammi);
			parziale.remove(l);
			}
		}
		
	}
	 
	public LinkedList<String> getAnagrammi (boolean correct){
		LinkedList <String> temp= new LinkedList<String>();
		AnagrammaDAO adao= new AnagrammaDAO();
		for(String s: anagrammi){
			if(adao.isCorrect(s)==correct){
				temp.add(s);
			}
		}
		return temp;
	}
	
	
}
