package Picērija;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import javax.swing.JOptionPane;

public class Picērija {
	public static void Spele() {
		   String[] picasSastavdali = {"Siers", "Tomāti", "Sēnes", "Ananāsi", "Oliņas"};
	        double[] picasCenas = {1.50, 0.75, 0.90, 1.25, 0.50};

	        // Pajautā, kuru picu vēlas klienta
	        Random rand = new Random();
	        int randomPica = rand.nextInt(3);
	        String izvele;
	        switch (randomPica) {
	            case 0:
	                izvele = "Siers,Tomāti,Sēnes,Pamatne";
	                break;
	            case 1:
	                izvele = "Siers,Ananāsi,Oliņas,Pamatne";
	                break;
	            case 2:
	                izvele = "Siers,Tomāti,Sēnes,Ananāsi,Oliņas,Pamatne";
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Kļūda: Nepareiza picas izvēle");
	                return;
	        }
	}
 
    public static void main(String[] args) {
        String izvele;
        String[] izvelne = {"Sakt jaunu speli", "Ieladet speli", "Iziet"};
        String[] jaunaIzvelne = {"Sākt strādāt", "Beigt strādāt", "Apskatīt picērijas informāciju"};
        do {
        	izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēlne", JOptionPane.INFORMATION_MESSAGE, null, izvelne, izvelne[0]);
        if(izvele.equalsIgnoreCase("Sakt jaunu speli")) {
            String profilaVards = JOptionPane.showInputDialog(null, "Ievadi savu profilu vārdu:");
            try {
                File profilaFails = new File(System.getProperty("user.home") + "\\Desktop\\" + profilaVards + ".txt");
                if(profilaFails.createNewFile()) {
                    JOptionPane.showMessageDialog(null, "Profilu veiksmīgi saglabāts!");
                }else {
                    JOptionPane.showMessageDialog(null, "Profilu nevarēja saglabāt. Mēģini vēlreiz.");
                }
                FileWriter rakstits = new FileWriter(profilaFails);
                rakstits.write("Profila vārds: " + profilaVards);
                rakstits.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
            Spele();
        }
         
        
        else if(izvele.equalsIgnoreCase("Ieladet speli")) {
                String profilaVards = JOptionPane.showInputDialog(null, "Ievadi profilu vārdu, kuru vēlies ielādēt:");
                String profilaCeļš = System.getProperty("user.home") + "\\Desktop\\" + profilaVards + ".txt";
                if(new File(profilaCeļš).exists()) {
                    try {
                        String saturaString = new String(Files.readAllBytes(Paths.get(profilaCeļš)));
                        JOptionPane.showMessageDialog(null, "Profilam " + profilaVards + " ir sekojošs saturs:\n\n" + saturaString);
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                    Spele();
                }else {
                    JOptionPane.showMessageDialog(null, "Nevarēja atrast profilu ar vārdu " + profilaVards + ". Mēģini vēlreiz.");
                }
            }
        }while(!izvele.equalsIgnoreCase("Iziet"));
    
}
}
 
