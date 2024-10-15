/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SzabóRoland(SZF_2023
 */
public class GainsToFile {
    private static int[] kincsadatok; // osszescsere, ebbolkincs, osszesnemcsere, ebbolkincs
    public static enum kincsAdatok{
        osszescsere(0),
        osszescserekincs(1),
        osszesnemcsere(2),
        osszesnemcserekincs(3);
        
        private final int value;
        private kincsAdatok(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        
    }
    static Scanner sc;
    static String filepath;
    static String filename; 
    
    static {
        filepath = GainsToFile.class.getClassLoader().getResource("output").getPath();
        filename = "gains.txt";
        File file = new File(filename);
        boolean both = file.exists();
        if(both){
            try {
                file.createNewFile();
                sc = new Scanner(file);
            } catch (IOException ex) {
                Logger.getLogger(GainsToFile.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        String ssz=both ? sc.nextLine() : "";
        String[] adatok = both ? ssz.split(";") : new String[0];
        System.out.println(both);
        both=adatok.length>=4;
        System.out.println(ssz);
        kincsadatok = new int[]{
           both ? Integer.parseInt(adatok[0]) : 0,
           both ? Integer.parseInt(adatok[1]) : 0,
           both ? Integer.parseInt(adatok[2]) : 0,
           both ? Integer.parseInt(adatok[3]) : 0
       };
    }
    
    /**
     * 
     * @param csere Ha 0, hamis, ha több, mint 0, igaz.
     * @param kincs Ha 0, hamis, ha több, mint 0, igaz.
     */
    protected static void novel(byte csere, byte kincs){
       // System.out.println("1: " + Integer.toBinaryString(csere) + ";" + Integer.toBinaryString(kincs));
        csere = bitmuvelet(csere);
       // System.out.println("2: " + Integer.toBinaryString(csere) + ";" + Integer.toBinaryString(kincs));
        kincsadatok[csere * 2]++;
        kincsadatok[csere * 2 + 1]+=bitmuvelet(kincs);
        save();
    }
    
    public static byte bitmuvelet(byte ertek){
        return (byte)(((ertek * -1)&0b11111111)>>7);
    }
    
    protected static void save(){
        String inToFile = "";
        for (int i = 0; i < kincsadatok.length; i++) {
            inToFile+=kincsadatok[i]+";";
        }
       // System.out.println(inToFile);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
              new FileOutputStream(new File(filename)), "utf-8"))) {
            writer.write(inToFile);
            writer.flush();
            writer.close();
         } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GainsToFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GainsToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getValue(kincsAdatok ertek){
        return getValue(ertek.getValue());
    }
    
    public static int getValue(int ertek){
        return kincsadatok[ertek];
    }
}
