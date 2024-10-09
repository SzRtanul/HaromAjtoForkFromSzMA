/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SzabóRoland(SZF_2023
 */
public class Jatek {
    byte ajtok;
    byte autohelye;
    byte valasztott;
    byte muveletsorrend;
    
    public Jatek(){
        this.ajtok=3;
        this.autohelye = (byte)(Math.random()*3);
        this.muveletsorrend = 0;
        this.valasztott = -1;
    }
    
    private byte getSzabad(){
        boolean both = false;
        byte i;
        for (i=0;i < ajtok && !both; i++) {
            both = i!= autohelye && i!= valasztott;
        }
        return i;
    }
    
    public boolean valaszt(byte melyik){
        muveletsorrend++;
        return muveletsorrend < 2;
    }
    
    public byte getFelkinal(){
        return muveletsorrend == 1 ? getSzabad() : -1;
    }
    
    public byte getKincs(){
        return muveletsorrend == 2 ? autohelye : -1;
    }
}
