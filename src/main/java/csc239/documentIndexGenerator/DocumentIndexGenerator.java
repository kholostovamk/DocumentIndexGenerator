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


class Occurence {
 
    private int lineNum, wordNum;
    
  public Occurence(int lineNum, int wordNum) {
    this.lineNum = lineNum;
    this.wordNum = wordNum;
  }
  public int getLineNum() { return lineNum; }
  public int getWordNum() { return wordNum; }
}



public class DocumentIndexGenerator {

    private static String fileName;
    private static File docFile;
    private static ArrayList<LowercaseWord> wordList = new ArrayList<LowercaseWord>();

    public static void main(String[] args) throws FileNotFoundException, IOException {

 
  
    String[] words = {};      
    //reads file
    System.out.println("Enter fileName: ");

    Scanner input = new Scanner(System.in);
    fileName = input.nextLine().trim(); 
    
    System.out.println(fileName); // - works
   
   docFile = new File(fileName);
    
    readString(fileName, words);
    
   // String text = readString(fileName);
    //System.out.println(text);
   // System.out.println(lineNum);
    
   // String[] words = text.toLowerCase().split(" ");
   
    
  //array of strings -> object
  //create an object of lowercase word for a string
  //when processing keep a count of line for object
  //put in array/ compare
  //copy occurence object from loweredcase object 
  //built always sorted list? compare with item in the list

    }
    
    
    public static LowercaseWord getWordFromList(String word) {
    for(LowercaseWord lowerWord : wordList) {
      if(lowerWord.getWord().equalsIgnoreCase(word)) {
        return lowerWord;
      }
    }
    return null;
  }
    
    public static void  recordNewOccurence(String word, int lineNum, int wordNum) {
    
        LowercaseWord candidate = new LowercaseWord(word);
        
        for (int i=0; i <wordList.size(); i++) {
            
            int result = candidate.compareTo(wordList.get(i));
            
            if (result <0) {
                wordList.add(i, candidate);
                candidate.addOccurence(lineNum, wordNum);
                return;
            }
            
            if (result ==0) {
                wordList.get(i).addOccurence(lineNum, wordNum);
                return;
            } 
        }
        
    }
   
    
    public static void readString(String file, String[] words ) throws FileNotFoundException, IOException{
        
      
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
  
        String line;
        int lineNum = 0;
        
        
       
        while ((line = bufferedReader.readLine()) != null) {
           
         
                words = line.split(" ");
                lineNum++;
                int wordNum = 0;
                for (String word: words) {
                    wordNum++;
                    word = word.toLowerCase();
                    
                   LowercaseWord lowerWord= getWordFromList(word);
                  recordNewOccurence(word, lineNum, wordNum);
                    
                    if (lowerWord == null) {
                        lowerWord = new LowercaseWord (word);
                        wordList.add(lowerWord);
                    } 
                    
                    lowerWord.addOccurence(lineNum, wordNum);
                    System.out.println(lowerWord);
          
                
                }
        }
        bufferedReader.close();
        
    }
}
       
