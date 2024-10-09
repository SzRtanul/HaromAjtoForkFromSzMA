/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;

/**
 *
 * @author SzabóRoland(SZF_2023
 */
public class GainsToFile {
    private static int osszesCsere;
    private static int csereNyert;
    private static int osszesNemcsere;
    private static int nemcsereNyert;
    // Scanner sc = new Scanner();
   
    
    static {
        String filename = "gains.txt";
       boolean both = new File(filename).exists();
        String[] adatok = both ? "".split(";") : new String[0];
       
       osszesCsere = both ? Integer.parseInt(adatok[0]) : 0;
       csereNyert = both ? Integer.parseInt(adatok[1]) : 0;
       osszesNemcsere = both ? Integer.parseInt(adatok[2]) : 0;
       nemcsereNyert = both ? Integer.parseInt(adatok[3]) : 0;
    }
    
    public boolean novel(){
        return true;
    }
}
