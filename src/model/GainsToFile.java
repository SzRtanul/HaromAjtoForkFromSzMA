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
    private static Scanner sc;
    private static String filepath;
    private static String filename; 
    
    static {
        setFilename("gains.txt");
    }
    
    /**
     * 
     * @param csere Ha 0, hamis, ha több, mint 0, igaz.
     * @param kincs Ha 0, hamis, ha több, mint 0, igaz.
     */
    protected static void doNovel(byte csere, byte kincs){
       // System.out.println("1: " + Integer.toBinaryString(csere) + ";" + Integer.toBinaryString(kincs));
        csere = doBitMuvelet(csere);
       // System.out.println("2: " + Integer.toBinaryString(csere) + ";" + Integer.toBinaryString(kincs));
        kincsadatok[csere * 2]++;
        kincsadatok[csere * 2 + 1]+=doBitMuvelet(kincs);
        doSave();
    }
    
    public static byte doBitMuvelet(byte ertek){
        return (byte)(((ertek * -1)&0b11111111)>>7);
    }
    
    protected static void doSave(){
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
    
    public static void setFilename(String filename){
        GainsToFile.filename = filename;
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
        String[] adatok = both ? sc.nextLine().split(";") : new String[0];
        both=adatok.length>=4;
        kincsadatok = new int[]{
           both ? Integer.parseInt(adatok[0]) : 0,
           both ? Integer.parseInt(adatok[1]) : 0,
           both ? Integer.parseInt(adatok[2]) : 0,
           both ? Integer.parseInt(adatok[3]) : 0
       };
    }
    
    public static int getValue(kincsAdatok ertek){
        return getValue(ertek.getValue());
    }
    
    public static int getValue(int ertek){
        return kincsadatok[ertek];
    }
}
