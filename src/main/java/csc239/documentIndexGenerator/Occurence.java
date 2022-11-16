package csc239.documentIndexGenerator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
class Occurence {

   private int lineNum;
   private int wordNum;

//setters
public void setLineNum(int lineNum){
    this.lineNum = lineNum;
}

public void setwordNum(int wordNum){
    this.wordNum = wordNum;
}

//getters

public int getLineNum() {
    return this.lineNum;
}

public int getWordNum() {
    return this.wordNum;
}

//The Occurrence class has a constructor that takes two int parameters: lineNum and wordNum.

    public Occurence(int lineNum, int wordNum){
        this.lineNum = lineNum;
        this.wordNum = wordNum;
}
//The Occurrence class also has a toString() method that returns a String object in thefollowing format:(lineNum, wordNum)*/

public String toString() {
    
    return null;
}
    
    
    
}