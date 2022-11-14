package csc239.documentIndexGenerator;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
class LowercaseWord implements Comparable<LowercaseWord> {

    private String lowerCaseText;
    private int occurenceCount = 1;
    private ArrayList<Occurence> refList;

    public int compareTo(LowercaseWord w) {
        return 0;
    }
}
