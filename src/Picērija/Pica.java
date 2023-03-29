package Picērija;

public class Pica {
	public String nosaukums;
	public int izmers;
	public boolean merce;
	public boolean biezaPamatne;
	public String sastavs;
	
	public Pica(String nosaukums, int izmers, boolean merce, boolean biezaPamatne, String sastavs) {
		this.nosaukums = nosaukums;
		this.izmers = izmers;
		this.merce = merce;
		this.biezaPamatne = biezaPamatne;
		this.sastavs = sastavs;
	}
	public String getNosaukums(){
		return nosaukums;
	}
	public int getIzmers(){
		return izmers;
	}
	public boolean getMerce(){
		return merce;
	}
	public boolean getBiezaPamatne(){
		return biezaPamatne;
	}
	public String getSastavs(){
		return sastavs;
		
	}
	
	
}

