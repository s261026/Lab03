package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;


public class Dizionario {

	LinkedList<Parola> paroleI;
	LinkedList<Parola> paroleE;

	public Dizionario() {
		paroleI = new LinkedList<Parola>();
		paroleE = new LinkedList<Parola>();

	}

	public void loadDictionary(String language) {

		try {
			//language = "English.txt";
			FileReader fr = new FileReader(language);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				// Aggiungere parola alla struttura dati
				Parola p = new Parola (word, true);
				paroleE.add(p);
				System.out.println("EVVIVA");
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file inglese");
		}
	}
	
	public void caricaDizionario(String language) {

		try {
			FileReader fr = new FileReader(language);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				// Aggiungere parola alla struttura dati
				Parola p = new Parola (word, true);
				paroleI.add(p);
				System.out.println("EVVIVA");
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file italiano");
		}
	}
	
	
	public List<Parola> spellCheckText(List<String> inputTextList){
		
		LinkedList <Parola> scorretteE = new LinkedList <Parola>(); 
		for(String s: inputTextList)
			for(Parola p: paroleE)
				if(!s.equals(p.getParola())) {
					p.setCorretto(false);
					scorretteE.add(p);
				}
		return scorretteE;
					
		
	}

	public List<Parola> spellCheckTextItaliano (List<String> inputTextList){
		
		LinkedList <Parola> scorretteI = new LinkedList <Parola>(); 
		for(String s: inputTextList)
			for(Parola p: paroleI)
				if(s.equals(p.getParola())) {
					p.setCorretto(false);
					scorretteI.add(p);
				}
		return scorretteI;
					
		
	}
}
