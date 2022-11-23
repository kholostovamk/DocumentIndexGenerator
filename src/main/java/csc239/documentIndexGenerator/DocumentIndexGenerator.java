/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package csc239.documentIndexGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class DocumentIndexGenerator {

    private static String fileName;
    private static File docFile;
    
    private static ArrayList<LowercaseWord> wordList;

    public static void main(String[] args) throws FileNotFoundException, IOException {

    String line;
    int lineNum = 0;
    int wordNum = 0;
  
    String[] words = null;      
    //reads file
    System.out.println("Enter fileName: ");

    Scanner input = new Scanner(System.in);
    fileName = input.nextLine().trim(); 
    
    System.out.println(fileName); // - works
    
  //  docFile = new File(fileName);
    
  //array of strings -> object
  //create an object of lowercase word for a string
  //when processing keep a count of line for object
  //put in array/ compare
  //copy occurence object from loweredcase object 
  //built always sorted list? compare with item in the list

    }
}


