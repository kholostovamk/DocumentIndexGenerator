/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csc239.indexgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*  CSC-239 Project 3:   Text Document Index Generator
* Student: Margarita Kholostova
* Date: December 14
* Description: This program reads a text file and produces a display
*               for all distinct words in file, along with the line number,
*               and word number values for each location where the word
* appears. */

class Occurence {
 
    private int lineNum, wordNum;
    
  public Occurence(int lineNum, int wordNum) {
    this.lineNum = lineNum;
    this.wordNum = wordNum;
  }
  public int getLineNum() { return lineNum; }
  public int getWordNum() { return wordNum; }
}


public class IndexGenerator {

    private static String fileName;
    private static File docFile;
    private static ArrayList<LowercaseWord> wordList = new ArrayList<LowercaseWord>();

    public static void main(String[] args) throws FileNotFoundException, IOException {

 
  
    String[] words = {};      
    
//reads file
    System.out.println("Enter fileName: ");

    Scanner input = new Scanner(System.in);
    fileName = input.nextLine().trim(); 

   
    docFile = new File(fileName);
    
    readString(fileName, words);
    


    }
    
    //method to compare words from list
    public static LowercaseWord getWordFromList(String word) {
    for(LowercaseWord lowerWord : wordList) {
      if(lowerWord.getWord().equalsIgnoreCase(word)) {
        return lowerWord;
      }
    }
    return null;
  }
    //method adds first met word or adds occurence to previously seen word
    public static void  recordNewOccurence(String word, int lineNum, int wordNum) {
    
        LowercaseWord candidate = new LowercaseWord(word);
        
        for (int i=1; i <wordList.size(); i++) {
            
            int result = candidate.compareTo(wordList.get(i));
            
            if (result <0) {
                wordList.add(i, candidate);
                candidate.addOccurence(lineNum, wordNum);
                return;
            }
            
        }
        
    }
   
    //makes words lowercase + records an occurence
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
       
//Start of LowerCaseWord class
class LowercaseWord  implements
Comparable<LowercaseWord> {

    private String lowerCaseText;
    private int occurenceCount = 1;
    private final ArrayList<Occurence> refList;
    
    public LowercaseWord(String lowerCaseText) {
    this.lowerCaseText = lowerCaseText;
    this.occurenceCount = 0;
    refList = new ArrayList<>();
  }

    public String getLowerCaseText () 
    { return this.lowerCaseText;
    }
    
    
  // adding occurence of a word
  public void addOccurence(int lineNum, int wordNum) {
    Occurence occurence = new Occurence(lineNum,wordNum);
    refList.add(occurence);
    occurenceCount++;
  }
  
  public List<Occurence> getOccurences() {
    return refList;
  }
  
  public String getWord() { return lowerCaseText; }

  
  @Override
  public int compareTo(LowercaseWord word2) {
        return this.getWord().compareTo(word2.getWord());
    }
 
 
  @Override
  public String toString() {
    String string = lowerCaseText.replaceAll(",", " ").trim() + "(" + occurenceCount + "): [";
    int count = 0;
    for (Occurence occurence : refList) {
      string += "(" + occurence.getLineNum() + ", " + occurence.getWordNum() + ")";
      count++;
      if(count == occurenceCount) {
      } else {
          string += ",";
        }
    }
    string += "]";
    return string;
  }
}



