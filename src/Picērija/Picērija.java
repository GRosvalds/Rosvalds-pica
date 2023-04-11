package Picērija;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class Picērija {

	
	public static int Spele(int nauda) {
		String[] jaunaIzvelne = {"Sākt strādāt", "Beigt strādāt", "Apskatīt picērijas informāciju"};
		String izvele;
		do {
			izvele= (String)JOptionPane.showInputDialog(null, "Izvēlies darbību \nJūsu nauda: "+nauda, "Izvēlne", JOptionPane.INFORMATION_MESSAGE, null, jaunaIzvelne, jaunaIzvelne[0]);
			switch(izvele) {
			case "Sākt strādāt":
				Random rand = new Random();
			    
				Object[] izmers = {20, 30, 50};
			    String[] klients = {"Pēteris", "Anna", "Samanta", "Ralfs", "Maksims", "Māris", "Matīss", "Keita", "Lidija", "Jānis", "Maikls" };
			   String[] pamatne = {"Bieza", "Plāna"};
			   String[] merces = {"Tomātu", "Bārbekjū", "Ķiploku", "Saldskābā"};
			   String[] piedevas = {"Peperoni", "Sēnes", "Ananasi", "Bekons", "Vista"};
			   String[] siers = {"Mocarellas", "Čedaras", "Parasts"};
			   
			   Object randIzmers = izmers[rand.nextInt(izmers.length)];
			   String randKlients = klients[rand.nextInt(klients.length)];
			   String randPamatne = pamatne[rand.nextInt(pamatne.length)];
			   String randMerce = merces[rand.nextInt(merces.length)];
			   String randPiedevas = piedevas[rand.nextInt(piedevas.length)];
			   String randSiers = siers[rand.nextInt(siers.length)];
			   
			   
//			   int izmers, String merce, String pamatne, String piedevas, String siers
			   Pica pica = new Pica(randIzmers, randMerce, randPamatne, randPiedevas, randSiers);
			    String pasutijums = "Klients: "+randKlients+" \npasūtija picu ar: \nPamatne: "+randPamatne+" \nIzmers: "+randIzmers+
			   " \nMērce: "+randMerce+" \nPiedevas: "+randPiedevas+" \nSiers: "+randSiers;
			    
			    JOptionPane.showMessageDialog(null, "Jūsu pasūtījums: \n"+pasutijums, "Pasūtījums", JOptionPane.INFORMATION_MESSAGE);
			    int pIzmers = (int) JOptionPane.showInputDialog(null,"Izmērs: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE, null, izmers, izmers[0]);
			    String pPamatne;
			    pPamatne = (String)JOptionPane.showInputDialog(null, "Pamatne: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,null, pamatne, pamatne[0]);
			    String pMerce = (String)JOptionPane.showInputDialog(null, "Merce: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,null, merces, merces[0]);
			    String pSiers = (String)JOptionPane.showInputDialog(null, "Siers: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,null, siers, siers[0]);
			    String pPiedevas = (String)JOptionPane.showInputDialog(null, "Piedevas: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,null, piedevas, piedevas[0]);
			    
			    
			    if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) && pMerce.equalsIgnoreCase(pica.getMerce()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())) {
			    	nauda += 20;
			    	int tips = rand.nextInt(10)+1;
			    	nauda +=tips;
			    	JOptionPane.showMessageDialog(null, randKlients+" samaksāja par picu, un atstāja "+tips+" dzeramnaudu", "pasūtījums", JOptionPane.INFORMATION_MESSAGE);
			    }
			    else {
			    	
			    }
			    break;
			    
				
			case "Apskatīt picērijas informāciju":
				
				break;
				
			case "Beigt strādāt":
				
				break;
			}
		}while(!izvele.equalsIgnoreCase("Beigt strādāt"));
		return nauda;
	    
	
	}
 
	public static void main(String[] args) {
	    int nauda = 0;
	    String izvele;
	    String[] izvelne = {"Sakt jaunu speli", "Ieladet speli", "Iziet"};
	    String[] jaunaIzvelne = {"Sākt strādāt", "Beigt strādāt", "Apskatīt picērijas informāciju"};
	    do {
	        izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēlne", JOptionPane.INFORMATION_MESSAGE, null, izvelne, izvelne[0]);
	        if (izvele.equalsIgnoreCase("Sakt jaunu speli")) {
	            String profilaVards = JOptionPane.showInputDialog(null, "Ievadi savu profilu vārdu:");
	            if (!profilaVards.trim().isEmpty()) {
	                try {
	                    File profilaFails = new File(System.getProperty("user.home") + "\\Desktop\\" + profilaVards + ".txt");
	                    if (profilaFails.createNewFile()) {
	                        JOptionPane.showMessageDialog(null, "Profilu veiksmīgi saglabāts!");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Profilu nevarēja saglabāt. Mēģini vēlreiz.");
	                    }
	                    nauda = Spele(nauda);
	                    FileWriter rakstits = new FileWriter(profilaFails);
	                    rakstits.write("Profila vārds: " + profilaVards + "\nNopelnita nauda: " + nauda);
	                    rakstits.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Profilu vārds nevar būt tukšs!");
	            }
	        } else if (izvele.equalsIgnoreCase("Ieladet speli")) {
	            String profilaVards = JOptionPane.showInputDialog(null, "Ievadi profilu vārdu, kuru vēlies ielādēt:");
	            String profilaCeļš = System.getProperty("user.home") + "\\Desktop\\" + profilaVards + ".txt";
	            if (new File(profilaCeļš).exists()) {
	                try {
	                    String saturaString = new String(Files.readAllBytes(Paths.get(profilaCeļš)));
	                    String[] lines = saturaString.split("\n");
	                    if (lines.length >= 2) {
	                        String[] moneyLineParts = lines[1].split(":");
	                      if (moneyLineParts.length >= 2) {
	                         try {
	                                nauda = Integer.parseInt(moneyLineParts[1].trim());
	                            } catch (NumberFormatException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                    }
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Profilam " + profilaVards + " ir sekojošs saturs:\n\n" + saturaString);
	                    Spele(nauda);
	                    FileWriter rakstits = new FileWriter(profilaVards);
	                    rakstits.write("Profila vārds: " + profilaVards + "\nNopelnita nauda: " + nauda);
	                    rakstits.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Nevarēja atrast profilu ar vārdu " + profilaVards + ". Mēģini vēlreiz.");
	            }
	        }
	    } while (!izvele.equalsIgnoreCase("Iziet"));
	}
}
 
