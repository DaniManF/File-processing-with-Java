package com.mycompany.practica1_m6;


import java.io.*;
import java.util.Scanner;


public class banc_p2uf3 {
	public static void main(String[] args) throws IOException
	{
                                    //  Definicio de l'arxiu on s'ubicarà les dades del saldo del banc
                                   File FitxerDiners = new File("C:\\Users\\danim\\Desktop\\2n Dam\\M6 ACCES A DADES\\Banc.txt");                                    
                                   
                                   //   Crida el metode Emagatzematge per obtenir el saldo inicial
                                   int i_capital = Emmagatzematge(FitxerDiners);

                                  //    'inicialitza l'objecte Scanner per llegir les entrades del usuari 
                                   Scanner sc = new  Scanner(System.in);
                                   int i_opcio_escollida = 0;
                                   
                                   //Bucle per iterar fins que l'usuari no esculi sortir
                                   while (i_opcio_escollida != 3) {
                                        System.out.println("\n1-Afegir diners\n2-Treure diners\n3-Sortir del programa"); 	
                                        i_opcio_escollida = sc.nextInt();   //  Agafa l'opcio seleccionada
                                        int i_quantitat = 0;

                                                switch(i_opcio_escollida) {
                                                    case 1: 
                                                            System.out.println("Introdueix la quantitat a ingressar");
                                                            i_quantitat = sc.nextInt(); 
                                                            i_capital += i_quantitat;
                                                            System.out.println("Saldo disponible: " + i_capital + "€");
                                                            break;
                                                    case 2:
                                                            System.out.println("Introdueix la quantitat a extreure");
                                                            i_quantitat = sc.nextInt();
                                                            if (i_quantitat > i_capital) {
                                                                System.out.println("No té suficient capital");
                                                            }
                                                            else
                                                            {
                                                                    i_capital -= i_quantitat;
                                                                    System.out.println("Saldo disponible: " + i_capital + "€");
                                                            }
                                                            break;
                                                    case 3:
                                                            System.out.println("Sortint del programa. Fins aviat!");
                                                            break;
                                                    default:
                                                            System.out.println("Opció incorrecta. Sortint del programa.");
                                                            break;
                                                 }
                                                //  Despres de cada operacio, guardem el saldo actualitzat en l'arxiu
                                                DesaCodi(FitxerDiners, i_capital);                                             
                                     }
                    }
        

        //Metode per verificar si l'arxiu existeix i crear-ho si no   
        public static int Emmagatzematge(File file) throws IOException {
              if (!file.exists()) {
                  System.out.println("L'arxiu no existeix. Es creara amb un saldo inicial de 10000€. ");
                  //Crear l'arxiu amb un saldo inicial de 10000€
                  DesaCodi(file, 10000);    //Crida el metode DesaCodi per crear l'arxiu i desa el saldo inicial
                  return 10000;
        }  else {
                  //    Si l'arxiu existeix, llegir el saldo emmagatzemat en ell.
                  try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                      String saldoStr = bufferedReader.readLine();  //Llegir la primera linea del arxiu on te el saldo
                      if (saldoStr != null) {
                          return Integer.parseInt(saldoStr.trim()); //Conertir el String a un enter i retornar-lo
                      } else {
                    System.out.println("Error al llegir el saldo, establint el saldo a 10000€.");
                    return 10000;       //si no pot llegir el saldo, retorna el saldo per defecte
                }
                  } catch (IOException | NumberFormatException e)   {   //Captura excepcions si sorgeix algún error de lectura
                      System.out.print("Error en llegir el fitxer: " + e.getMessage());
                      return 10000;
                  }
              } 
        }

        //Metode per Desar el codi en el fitxer 
         public static void DesaCodi(File file, int saldo) throws IOException {
             // Utilitzem BufferedWriter per escriure el saldo en l'arxiu
           try( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
              bufferedWriter.write(String.valueOf(saldo));  //Escriu el saldo convertir a String
              bufferedWriter.newLine();   //Inserta una nova linea despres del saldo
               System.out.println("S'ha desat el codi correctament");    //Misatge de confirmació
          } catch (IOException e) { //Captura excepcions si tenim algún error en desà l'arxiu
              System.out.println("Hi ha hagut algún error al desar el fitxer: "+ e.getMessage());
          }
       }
       }
           
         
           

