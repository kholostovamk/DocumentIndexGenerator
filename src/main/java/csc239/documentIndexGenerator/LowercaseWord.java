package csc239.documentIndexGenerator;


import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
class LowercaseWord  implements
Comparable<LowercaseWord> {

    private String lowerCaseText;
    private int occurenceCount = 1;
    private ArrayList<Occurence> refList;
    
    public LowercaseWord(String lowerCaseText) {
    this.lowerCaseText = lowerCaseText;
    this.occurenceCount = 1;
    refList = new ArrayList<>();
  }

    public String getLowerCaseText () 
    { return this.lowerCaseText;
    }
    
    

    LowercaseWord(String word, int lineNum, int wordNum) {
        
        this.lowerCaseText = word;
        
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

  
  public int compareTo(LowercaseWord word2) {
        return this.getWord().compareTo(word2.getWord());
    }

  
  
  @Override
  public String toString() {
    String string = lowerCaseText + "(" + occurenceCount + "): [";
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

