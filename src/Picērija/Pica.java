package Picçrija;

public class Pica {
	public Object izmers;
	public String merce;
	public String pamatne;
	public String piedevas;
	public String siers;
	
	
	public Pica(Object izmers, String merce, String pamatne, String piedevas, String siers) {
		
		this.izmers = izmers;
		this.merce = merce;
		this.pamatne = pamatne;
		this.piedevas = piedevas;
		this.siers = siers;
		
	
	}
	public String getPiedevas(){
		return piedevas;
	
	}
	public Object getIzmers(){
		return izmers;
	
	}
	public String getMerce(){
		return merce;
	
	}
	public String getPamatne(){
		return pamatne;
	
	}
	public String getSiers() {
		return siers;
	}

	
	
}

