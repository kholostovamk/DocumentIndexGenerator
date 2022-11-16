/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package csc239.documentIndexGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class DocumentIndexGenerator {

    private static String fileName;
    private static File docFile;
    
    private static ArrayList<LowercaseWord> wordList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {

    String line;
    int lineNum = 0;
    int wordNum = 0;
  
          
    //reads file
    System.out.println("Enter fileName: ");

    Scanner input = new Scanner(System.in);
    fileName = input.nextLine().trim(); 
    
    docFile = new File(fileName);
    
    BufferedReader br = new BufferedReader(new FileReader(docFile));
    
    line = br.readLine();
    while(line!=null){
        String[] words = line.split(" ");
        lineNum++;
    }
   
        
        //converts words to lower case
        //report the presence of the word in output
    }
}