package Picērija;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Picērija {

	
	public static int Spele(int nauda) {
		ImageIcon logo = new ImageIcon("logo.jpg");
		ImageIcon cheese = new ImageIcon("cheese.jpg");
		ImageIcon souce = new ImageIcon("souce.png");
		ImageIcon dislike = new ImageIcon("dislike.png");
		ImageIcon like = new ImageIcon("like.png");
		ImageIcon toppings = new ImageIcon("toppings.jpg");
		ImageIcon dough = new ImageIcon("dough.png");
		ImageIcon oven = new ImageIcon("oven.png");
		String[] jaunaIzvelne = {"Sākt strādāt", "Beigt strādāt", "Apskatīt picērijas informāciju"};
		String izvele;
		int Klienti = 0;
		int apmierKlienti = 0;
		int neapmierKlienti = 0;
		do {
			izvele= (String)JOptionPane.showInputDialog(null, "Izvēlies darbību \nJūsu nauda: "+nauda+" euro", "PaprikaPizza", JOptionPane.INFORMATION_MESSAGE, logo, jaunaIzvelne, jaunaIzvelne[0]);
			switch(izvele) {
			case "Sākt strādāt":
				Random rand = new Random();
			    Klienti+=1;
				Object[] izmers = {20, 30, 50};
			    String[] klients = {"Pēteris", "Anna", "Samanta", "Ralfs", "Maksims", "Māris", "Matīss", "Keita", "Lidija", "Jānis", "Maikls"};
			   String[] pamatne = {"Bieza", "Plāna", "Ar Sieru"};
			   String[] merces = {"Tomātu", "Bārbekjū", "Ķiploku", "Saldskābā", "Karija", "Asā"};
			   String[] piedevas = {"Peperoni", "Sēnes", "Ananasi", "Bekons", "Vista", "Maltā gaļa"};
			   String[] siers = {"Mocarellas", "Čedaras", "Parasts", "Kamambēras"};
			   
			   Object randIzmers = izmers[rand.nextInt(izmers.length)];
			   String randKlients = klients[rand.nextInt(klients.length)];
			   String randPamatne = pamatne[rand.nextInt(pamatne.length)];
			   String randMerce = merces[rand.nextInt(merces.length)];
			   String randPiedevas = piedevas[rand.nextInt(piedevas.length)];
			   String randSiers = siers[rand.nextInt(siers.length)];
			   
			   
//			   int izmers, String merce, String pamatne, String piedevas, String siers
			   Pica pica = new Pica(randIzmers, randMerce, randPamatne, randPiedevas, randSiers);
			    String pasutijums = "Klients: "+randKlients+" \npasūtija picu ar: \nPamatne: "+randPamatne+" \nIzmers: "+randIzmers+
			   "cm \nMērce: "+randMerce+" \nPiedevas: "+randPiedevas+" \nSiers: "+randSiers;
			    
			    JOptionPane.showMessageDialog(null, "Jūsu pasūtījums: \n"+pasutijums, "Pasūtījums", JOptionPane.INFORMATION_MESSAGE);
			    int pIzmers = (int) JOptionPane.showInputDialog(null,"Izmērs: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE, null, izmers, izmers[0]);
			    String pPamatne;
			    pPamatne = (String)JOptionPane.showInputDialog(null, "Pamatne: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,dough, pamatne, pamatne[0]);
			    String pMerce = (String)JOptionPane.showInputDialog(null, "Merce: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,souce, merces, merces[0]);
			    String pSiers = (String)JOptionPane.showInputDialog(null, "Siers: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,cheese, siers, siers[0]);
			    String pPiedevas = (String)JOptionPane.showInputDialog(null, "Piedevas: ", "Ceptuve", JOptionPane.INFORMATION_MESSAGE,toppings, piedevas, piedevas[0]);
			    int kludas = 0;
			    JOptionPane.showMessageDialog(null, "Pica ielikta krāsnī!", "Krāsns", JOptionPane.INFORMATION_MESSAGE, oven);
			    int seconds = 10; 
		        for (int i = seconds; i >= 0; i--) {
		           System.out.println("Atlikušais laiks: "+ i + " sekundes");
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
			    	JOptionPane.showMessageDialog(null, randKlients+" nesamaksāja par picu, un neatstāja dzeramnaudu, jo\npieļāvāt pārāk daudz kļūdu picas pagatavošanā!", "pasūtījums", JOptionPane.INFORMATION_MESSAGE, dislike);
			    	neapmierKlienti+=1;
			    }else {
			    if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) && pMerce.equalsIgnoreCase(pica.getMerce()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())) {
			    	apmierKlienti+=1;
			    	nauda += 20;
			    	int tips = rand.nextInt(10)+0;
			    	nauda +=tips;
			    	JOptionPane.showMessageDialog(null, randKlients+" samaksāja par picu "+20+" euro, un atstāja "+tips+" euro dzeramnaudu", "pasūtījums", JOptionPane.INFORMATION_MESSAGE, like);
			    }
			    
			    else if(pPamatne.equalsIgnoreCase(pica.getPamatne()) && pMerce.equalsIgnoreCase(pica.getMerce()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())){
			    	nauda+=20;
			    	apmierKlienti+=1;
			    	JOptionPane.showMessageDialog(null, randKlients+" samaksāja par picu "+20+" euro, un atstāja "+0+" euro dzeramnaudu, jo\nuztaisijāt picu ar nepareizu izmēru!", "pasūtījums", JOptionPane.INFORMATION_MESSAGE, like);

			    }
			    else if(pIzmers == (int)pica.getIzmers() && pMerce.equalsIgnoreCase(pica.getMerce()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())){
			    	nauda+=20;
			    	int tips = rand.nextInt(7)+0;
			    	apmierKlienti+=1;
			    	JOptionPane.showMessageDialog(null, randKlients+" samaksāja par picu "+20+" euro, un atstāja "+tips+" euro dzeramnaudu.\nJūs uztaisijāt picu ar nepareizu pamatni, lūdzu pievērsiet uzmanību!", "pasūtījums", JOptionPane.WARNING_MESSAGE, like);

			    }
			    else if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pPiedevas.equalsIgnoreCase(pica.getPiedevas())){
			    	nauda+=15;
			    	neapmierKlienti+=1;
			    	
			    	JOptionPane.showMessageDialog(null, randKlients+" samaksāja par picu "+15+" euro, un atstāja "+0+" euro dzeramnaudu.\nJūs uztaisijāt picu ar nepareizu mērci, lūdzu pievērsiet uzmanību!", "pasūtījums", JOptionPane.WARNING_MESSAGE, dislike);

			    }
			    else if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) &&pMerce.equalsIgnoreCase(pica.getMerce()) &&pPiedevas.equalsIgnoreCase(pica.getPiedevas())){
			    	nauda+=10;
			    	neapmierKlienti+=1;
			    	
			    	JOptionPane.showMessageDialog(null, randKlients+" samaksāja par picu "+10+" euro, un atstāja "+0+" euro dzeramnaudu.\nJūs uztaisijāt picu ar nepareizu sieru, lūdzu pievērsiet uzmanību!", "pasūtījums", JOptionPane.WARNING_MESSAGE,dislike);

			    }
			    else if(pIzmers == (int)pica.getIzmers() && pPamatne.equalsIgnoreCase(pica.getPamatne()) && pSiers.equalsIgnoreCase(pica.getSiers()) && pMerce.equalsIgnoreCase(pica.getMerce())){
			    	nauda+=5;
			    	neapmierKlienti+=1;
			    	
			    	JOptionPane.showMessageDialog(null, randKlients+" samaksāja par picu "+5+" euro, un atstāja "+0+" euro dzeramnaudu.\nJūs uztaisijāt picu ar nepareizām piedevām, lūdzu pievērsiet uzmanību!", "pasūtījums", JOptionPane.WARNING_MESSAGE, dislike);

			    }
			    }
			    break;
			    
				
			case "Apskatīt picērijas informāciju":
				JOptionPane.showMessageDialog(null, "Šodien jūsu picēriju apmeklēja "+Klienti+" klients/i\n"+apmierKlienti+" no tiem bija apmierināts/i, bet "+neapmierKlienti+" neapmierināts/i");
				break;
				
			case "Beigt strādāt":
				
				break;
			}
		}while(!izvele.equalsIgnoreCase("Beigt strādāt"));
		return nauda;
	    
	
	}
 
	public static void main(String[] args) {
		ImageIcon logo = new ImageIcon("logo.jpg");

	    int nauda = 0;
	    String izvele;
	    String[] izvelne = {"Sakt jaunu speli", "Ieladet speli", "Iziet"};
	    String[] jaunaIzvelne = {"Sākt strādāt", "Beigt strādāt", "Apskatīt picērijas informāciju"};
	    do {
	        izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "PaprikaPizza", JOptionPane.INFORMATION_MESSAGE, logo, izvelne, izvelne[0]);
	        switch(izvele) {
	        case "Sakt jaunu speli":
	            String profilaVards = JOptionPane.showInputDialog(null, "Ievadi savu profilu vārdu:", "Registrācija");
	            if (!profilaVards.trim().isEmpty()) {
	                try {
	                    File profilaFails = new File(System.getProperty("user.home") + "\\Desktop\\" + profilaVards + ".txt");
	                    if (profilaFails.createNewFile()) {
	                        JOptionPane.showMessageDialog(null, "Profilu veiksmīgi saglabāts!");
	                        nauda = Spele(nauda);
		                    FileWriter rakstits = new FileWriter(profilaFails);
		                    rakstits.write("Profila vārds: " + profilaVards + "\nNopelnita nauda: " + nauda);
		                    rakstits.close();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Profilu nevarēja saglabāt. Mēģini vēlreiz.");
	                    }
	                    
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Profilu vārds nevar būt tukšs!");
	            }
	            break;
	        case "Ieladet speli":
	            String profilaVards2 = JOptionPane.showInputDialog(null, "Ievadi profilu vārdu, kuru vēlies ielādēt:", "Profils");
	            String profilaCeļš = System.getProperty("user.home") + "\\Desktop\\" + profilaVards2 + ".txt";
	            if (new File(profilaCeļš).exists()) {
	                try {
	                    String saturaString = new String(Files.readAllBytes(Paths.get(profilaCeļš)));
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
	                    JOptionPane.showMessageDialog(null, "Profilam " + profilaVards2 + " ir sekojošs saturs:\n\n" + saturaString);
	                    nauda =Spele(nauda);
	                    System.out.println(nauda);
	                    FileWriter rakstits = new FileWriter(profilaCeļš, false);
	                    rakstits.write("Profila vārds: " + profilaVards2 + "\nNopelnta nauda: " + nauda);
	                    rakstits.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Nevarēja atrast profilu ar vārdu " + profilaVards2 + ". Mēģini vēlreiz.");
	            }
	        }
	    } while (!izvele.equalsIgnoreCase("Iziet"));
	}
}
 
