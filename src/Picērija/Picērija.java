package Pic�rija;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Pic�rija {

	
	public static int Spele(int nauda) {
		ImageIcon logo = new ImageIcon("logo.jpg");
		ImageIcon cheese = new ImageIcon("cheese.jpg");
		ImageIcon souce = new ImageIcon("souce.png");
		ImageIcon dislike = new ImageIcon("dislike.png");
		ImageIcon like = new ImageIcon("like.png");
		ImageIcon toppings = new ImageIcon("toppings.jpg");
		ImageIcon dough = new ImageIcon("dough.png");
		ImageIcon oven = new ImageIcon("oven.png");
		String[] jaunaIzvelne = {"S�kt str�d�t", "Beigt str�d�t", "Apskat�t pic�rijas inform�ciju"};
		String izvele;
		int Klienti = 0;
		int apmierKlienti = 0;
		int neapmierKlienti = 0;
		do {
			izvele= (String)JOptionPane.showInputDialog(null, "Izv�lies darb�bu \nJ�su nauda: "+nauda+" euro", "PaprikaPizza", JOptionPane.INFORMATION_MESSAGE, logo, jaunaIzvelne, jaunaIzvelne[0]);
			switch(izvele) {
			case "S�kt str�d�t":
				Random rand = new Random();
			    Klienti+=1;
				Object[] izmers = {20, 30, 50};
			    String[] klients = {"P�teris", "Anna", "Samanta", "Ralfs", "Maksims", "M�ris", "Mat�ss", "Keita", "Lidija", "J�nis", "Maikls"};
			   String[] pamatne = {"Bieza", "Pl�na", "Ar Sieru"};
			   String[] merces = {"Tom�tu", "B�rbekj�", "�iploku", "Saldsk�b�", "Karija", "As�"};
			   String[] piedevas = {"Peperoni", "S�nes", "Ananasi", "Bekons", "Vista", "Malt� ga�a"};
			   String[] siers = {"Mocarellas", "�edaras", "Parasts", "Kamamb�ras"};
			   
			   Object randIzmers = izmers[rand.nextInt(izmers.length)];
			   String randKlients = klients[rand.nextInt(klients.length)];
			   String randPamatne = pamatne[rand.nextInt(pamatne.length)];
			   String randMerce = merces[rand.nextInt(merces.length)];
			   String randPiedevas = piedevas[rand.nextInt(piedevas.length)];
			   String randSiers = siers[rand.nextInt(siers.length)];
			   
			   
//			   int izmers, String merce, String pamatne, String piedevas, String siers
			   Pica pica = new Pica(randIzmers, randMerce, randPamatne, randPiedevas, randSiers);
			    String pasutijums = "Klients: "+randKlients+" \npas�tija picu ar: \nPamatne: "+randPamatne+" \nIzmers: "+randIzmers+
			   "cm \nM�rce: "+randMerce+" \nPiedevas: "+randPiedevas+" \nSiers: "+randSiers;
			    
			    JOptionPane.showMessageDialog(null, "J�su pas�t�jums: \n"+pasutijums, "Pas�t�jums", JOptionPane.INFORMATION_MESSAGE);
			    int pIzmers = (int) JOptionPane.showInputDialog(null,"Izm�rs: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE, null, izmers, izmers[0]);
			    String pPamatne;
			    pPamatne = (String)JOptionPane.showInputDialog(null, "Pamatne: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,dough, pamatne, pamatne[0]);
			    String pMerce = (String)JOptionPane.showInputDialog(null, "Merce: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,souce, merces, merces[0]);
			    String pSiers = (String)JOptionPane.showInputDialog(null, "Siers: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,cheese, siers, siers[0]);
			    String pPiedevas = (String)JOptionPane.showInputDialog(null, "Piedevas: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,toppings, piedevas, piedevas[0]);
			    int kludas = 0;
			    JOptionPane.showMessageDialog(null, "Pica ielikta kr�sn�!", "Kr�sns", JOptionPane.INFORMATION_MESSAGE, oven);
			    int seconds = 10; 
		        for (int i = seconds; i >= 0; i--) {
		           System.out.println("Atliku�ais laiks: "+ i + " sekundes");
		            try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					} 
		        }
		        JOptionPane.showMessageDialog(null, "Pica gatava un tika nodota klientam!");
			    
			    if(pIzmers != (int)pica.getIzmers()) {
			    	kludas+=1;
			    }
			    if(!pPamatne.equalsIgnoreCase(pica.getPamatne())) {
			    	kludas+=1;
			    }
			    if(!pMerce.equalsIgnoreCase(pica.getMerce())) {
			    	kludas+=1;
			    }
			    if(!pSiers.equalsIgnoreCase(pica.getSiers())) {
			    	kludas+=1;
			    }
			    if(!pPiedevas.equalsIgnoreCase(pica.getPiedevas())) {
			    	kludas+=1;
			    }
			    
			    if(kludas>=2) {
			    	JOptionPane.showMessageDialog(null, randKlients+" nesamaks�ja par picu, un neatst�ja dzeramnaudu, jo\npie��v�t p�r�k daudz k��du picas pagatavo�an�!", "pas�t�jums", JOptionPane.INFORMATION_MESSAGE, dislike);
			    	neapmierKlienti+=1;
			    }else {
			    if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) && pMerce.equalsIgnoreCase(pica.getMerce()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())) {
			    	apmierKlienti+=1;
			    	nauda += 20;
			    	int tips = rand.nextInt(10)+0;
			    	nauda +=tips;
			    	JOptionPane.showMessageDialog(null, randKlients+" samaks�ja par picu "+20+" euro, un atst�ja "+tips+" euro dzeramnaudu", "pas�t�jums", JOptionPane.INFORMATION_MESSAGE, like);
			    }
			    
			    else if(pPamatne.equalsIgnoreCase(pica.getPamatne()) && pMerce.equalsIgnoreCase(pica.getMerce()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())){
			    	nauda+=20;
			    	apmierKlienti+=1;
			    	JOptionPane.showMessageDialog(null, randKlients+" samaks�ja par picu "+20+" euro, un atst�ja "+0+" euro dzeramnaudu, jo\nuztaisij�t picu ar nepareizu izm�ru!", "pas�t�jums", JOptionPane.INFORMATION_MESSAGE, like);

			    }
			    else if(pIzmers == (int)pica.getIzmers() && pMerce.equalsIgnoreCase(pica.getMerce()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())){
			    	nauda+=20;
			    	int tips = rand.nextInt(7)+0;
			    	apmierKlienti+=1;
			    	JOptionPane.showMessageDialog(null, randKlients+" samaks�ja par picu "+20+" euro, un atst�ja "+tips+" euro dzeramnaudu.\nJ�s uztaisij�t picu ar nepareizu pamatni, l�dzu piev�rsiet uzman�bu!", "pas�t�jums", JOptionPane.WARNING_MESSAGE, like);

			    }
			    else if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())){
			    	nauda+=15;
			    	neapmierKlienti+=1;
			    	
			    	JOptionPane.showMessageDialog(null, randKlients+" samaks�ja par picu "+15+" euro, un atst�ja "+0+" euro dzeramnaudu.\nJ�s uztaisij�t picu ar nepareizu m�rci, l�dzu piev�rsiet uzman�bu!", "pas�t�jums", JOptionPane.WARNING_MESSAGE, dislike);

			    }
			    else if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) &&pMerce.equalsIgnoreCase(pica.getMerce()) &&pPiedevas.equalsIgnoreCase(pica.getPiedevas())){
			    	nauda+=10;
			    	neapmierKlienti+=1;
			    	
			    	JOptionPane.showMessageDialog(null, randKlients+" samaks�ja par picu "+10+" euro, un atst�ja "+0+" euro dzeramnaudu.\nJ�s uztaisij�t picu ar nepareizu sieru, l�dzu piev�rsiet uzman�bu!", "pas�t�jums", JOptionPane.WARNING_MESSAGE,dislike);

			    }
			    else if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pMerce.equalsIgnoreCase(pica.getMerce())){
			    	nauda+=5;
			    	neapmierKlienti+=1;
			    	
			    	JOptionPane.showMessageDialog(null, randKlients+" samaks�ja par picu "+5+" euro, un atst�ja "+0+" euro dzeramnaudu.\nJ�s uztaisij�t picu ar nepareiz�m piedev�m, l�dzu piev�rsiet uzman�bu!", "pas�t�jums", JOptionPane.WARNING_MESSAGE, dislike);

			    }
			    }
			    break;
			    
				
			case "Apskat�t pic�rijas inform�ciju":
				JOptionPane.showMessageDialog(null, "�odien j�su pic�riju apmekl�ja "+Klienti+" klients/i\n"+apmierKlienti+" no tiem bija apmierin�ts/i, bet "+neapmierKlienti+" neapmierin�ts/i");
				break;
				
			case "Beigt str�d�t":
				
				break;
			}
		}while(!izvele.equalsIgnoreCase("Beigt str�d�t"));
		return nauda;
	    
	
	}
 
	public static void main(String[] args) {
		ImageIcon logo = new ImageIcon("logo.jpg");

	    int nauda = 0;
	    String izvele;
	    String[] izvelne = {"Sakt jaunu speli", "Ieladet speli", "Iziet"};
	    String[] jaunaIzvelne = {"S�kt str�d�t", "Beigt str�d�t", "Apskat�t pic�rijas inform�ciju"};
	    do {
	        izvele = (String) JOptionPane.showInputDialog(null, "Izv�lies darb�bu", "PaprikaPizza", JOptionPane.INFORMATION_MESSAGE, logo, izvelne, izvelne[0]);
	        switch(izvele) {
	        case "Sakt jaunu speli":
	            String profilaVards = JOptionPane.showInputDialog(null, "Ievadi savu profilu v�rdu:");
	            nauda = 0;
	            if (!profilaVards.trim().isEmpty()) {
	                try {
	                    File profilaFails = new File(System.getProperty("user.home") + "\\Desktop\\" + profilaVards + ".txt");
	                    if (profilaFails.createNewFile()) {
	                        JOptionPane.showMessageDialog(null, "Profilu veiksm�gi saglab�ts!");
	                        nauda = Spele(nauda);
		                    FileWriter rakstits = new FileWriter(profilaFails);
		                    rakstits.write("Profila v�rds: " + profilaVards + "\nNopelnita nauda: " + nauda);
		                    rakstits.close();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Profilu nevar�ja saglab�t. M��ini v�lreiz.");
	                    }
	                    
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Profilu v�rds nevar b�t tuk�s!");
	            }
	            break;
	        case "Ieladet speli":
	            String profilaVards2 = JOptionPane.showInputDialog(null, "Ievadi profilu v�rdu, kuru v�lies iel�d�t:");
	            String profilaCe�� = System.getProperty("user.home") + "\\Desktop\\" + profilaVards2 + ".txt";
	            if (new File(profilaCe��).exists()) {
	                try {
	                    String saturaString = new String(Files.readAllBytes(Paths.get(profilaCe��)));
	                    String[] lines = saturaString.split("\n");
	                    if (lines.length >= 2) {
	                        String[] moneyLineParts = lines[1].split(":");
	                        if (moneyLineParts.length >= 2) {
	                            try {
	                                nauda = Integer.parseInt(moneyLineParts[1].trim());
	                                System.out.println(nauda);
	                            } catch (NumberFormatException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                    }
	                    JOptionPane.showMessageDialog(null, "Profilam " + profilaVards2 + " ir sekojo�s saturs:\n\n" + saturaString);
	                    nauda =Spele(nauda);
	                    System.out.println(nauda);
	                    FileWriter rakstits = new FileWriter(profilaCe��, false);
	                    rakstits.write("Profila v�rds: " + profilaVards2 + "\nNopelnta nauda: " + nauda);
	                    rakstits.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Nevar�ja atrast profilu ar v�rdu " + profilaVards2 + ". M��ini v�lreiz.");
	            }
	        }
	    } while (!izvele.equalsIgnoreCase("Iziet"));
	}
}
 
