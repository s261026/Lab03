package it.polito.tdp.spellchecker.model;



public class Parola {
	
	private String parola;
	private boolean corretto;
	public Parola(String parola, boolean corretto) {
		super();
		this.parola = parola;
		this.corretto = corretto;
		
		
		
	}
	
	
	
	
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isCorretto() {
		return corretto;
	}
	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

	
	/*@Override
	public String toString(Parola p) {
		return p.getParola()+"\n";
		
	}*/



	
	
	

}
