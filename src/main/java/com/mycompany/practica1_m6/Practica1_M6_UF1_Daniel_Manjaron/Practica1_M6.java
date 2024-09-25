
package com.mycompany.practica1_m6;
/**
 *
 * @author danim
 */

import java.io.*;
import java.util.Scanner;



public class Practica1_M6 {
    
    public static void main(String[] args) throws IOException { 
        // Es declaren dos objectes File: un per a un fitxer existent i un per a un fitxer no existent.
         File fitxerexistent = new File("C:\\Users\\danim\\Desktop\\2n Dam\\M6 ACCES A DADES\\FITXER1.txt");
         File fitxerNoExistent = new File("C:\\Users\\danim\\Desktop\\2n Dam\\M6 ACCES A DADES\\FITXER2.txt");
       
        //Comprovem i creem arxius si no exiteixen
          crearFitxerSiNoExisteis(fitxerexistent);
          crearFitxerSiNoExisteis(fitxerNoExistent);
          
          /// Realitzem la lectura del fitxer existent usant tres mètodes diferents:
          System.out.println("----- Lectura amb els diferents metodes: -----");
          LlegirFitxerScanner(fitxerexistent);
          LlegirFitxerFileReader(fitxerexistent);
          LlegirFitxerBufferedReader(fitxerexistent);
          
          // Sobreescrivim el contingut del fitxer existent amb nou text.
          System.out.println("\n ----- Sobreescribeix l'arxiu amb nou contigut: ----- ");
          EscriureBufferedWriter(fitxerexistent, "Text nou que sobrescriu el contingut.\n", false); //Com a tercer parametre li diem flase, el que indica que volem sobreescriure 
          // Mostrem el contingut del fitxer després de la sobrescritura.
          LlegirFitxerScanner(fitxerexistent);
         
          // Afegim text al final del fitxer existent sense esborrar el contingut anterior.
          System.out.println("\n----- Afegim text al final del arxiu: -----");
          EscriureBufferedWriter(fitxerexistent, "Aquest text s'ha afegit al final del fitxer.\n", true);   //Com a tercer parametre li diem flase, el que indica que volem afegir text sense borrrar l'anterior 
          // Mostrem el contingut del fitxer després d'afegir text al final.
          LlegirFitxerScanner(fitxerexistent);
          
   }
          /**
     * Mètode que comprova si un fitxer existeix. Si no existeix, el crea.
     * @param file L'objecte File que representa el fitxer a comprovar o crear.
     * @throws IOException Si ocurre un error d'entrada.
     */
         public static void crearFitxerSiNoExisteis(File file) throws IOException {
             // Si el fitxer no existeix, es crea i es mostra un missatge indicant-ho.
              if (file.createNewFile()) {
              System.out.println("L'arxiu " + file.getName() + " no existia i s'ha creat. ");
          } else {
                  // Si el fitxer ja existeix, es mostra un missatge indicant que ja existeix.
                  System.out.println("L'arxiu " + file.getName() + " ja existeix.");
              }
          }
          
          
        /**
     * Mètode per llegir un fitxer usant la classe Scanner.
     * @param file L'objecte File que representa el fitxer a llegir.
     * @throws FileNotFoundException Si el fitxer no es troba.
     */
          public static void LlegirFitxerScanner(File file) throws FileNotFoundException {
              // Creem un objecte Scanner per llegir el fitxer
              Scanner scanner = new Scanner(file);
              System.out.println("Lectura amb Scanner:");
              // Llegim i imprimim línia per línia del fitxer.
              while (scanner.hasNextLine()) {
                  System.out.println(scanner.nextLine());
              }
              // Tanquem l'scanner després de la lectura.
              scanner.close();
          }
          
          
                /**
          * Mètode per llegir un fitxer usant la classe FileReader.
          * @param file L'objecte File que representa el fitxer a llegir.
          * @throws IOException Si ocorre un error d'entrada/sortida.
          */
          public static void LlegirFitxerFileReader(File file) throws IOException {
              // Creem un objecte FileReader per llegir el fitxer caràcter per caràcter.
              FileReader fileReader = new FileReader(file);
              System.out.println("Lectura amb FileReader: ");
              int caracterCode;
              // Llegim i imprimim cada caràcter del fitxer.
              while ((caracterCode = fileReader.read()) != -1) {
                  System.out.print((char)caracterCode);
              }
              // Tanquem el FileReader després de la lectura.
              fileReader.close();
              System.out.println();
          }
          
          
           /**
     * Mètode per llegir un fitxer usant la classe BufferedReader.
     * @param file L'objecte File que representa el fitxer a llegir.
     * @throws IOException Si ocorre un error d'entrada/sortida.
     */
        public static void LlegirFitxerBufferedReader(File file) throws IOException {
            // Creem un objecte BufferedReader per llegir el fitxer línia per línia.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            System.out.println("Lectura amb BufferedReader:");
            String line;
            // Llegim i imprimim cada línia del fitxer.
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            // Tanquem el BufferedReader després de la lectura.
            bufferedReader.close();
        }
         
          
       /**
     * Mètode per escriure o afegir text a un fitxer usant BufferedWriter.
     * @param file L'objecte File que representa el fitxer en què s'escriurà.
     * @param content El contingut que s'escriurà al fitxer.
     * @param append Si és true, el contingut s'afegirà al final; si és false, es sobreescriurà.
     * @throws IOException Si ocorre un error d'entrada/sortida.
     */
        public static void EscriureBufferedWriter(File file, String content, boolean append) throws IOException {
            // Creem un BufferedWriter per escriure o afegir contingut al fitxer.
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append));
            // Escrivim el contingut especificat al fitxer.
            bufferedWriter.write(content);
            // Tanquem el BufferedWriter després de l'escriptura.
            bufferedWriter.close();
        }
        
}
      


    
   



