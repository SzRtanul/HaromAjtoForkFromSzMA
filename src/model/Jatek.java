/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import eventinterfaces.EIs;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SzabóRoland(SZF_2023
 */
public class Jatek extends GainsToFile{
    private static final Set<EIs.JatekItfc> listeners = new HashSet<>();
    
    public static void addEventListener(EIs.JatekItfc listener){
        listeners.add(listener);
    }
    
    public static void removeEventListener(EIs.JatekItfc listener){
        listeners.remove(listener);
    }
    
    private static void broadcast(){
        for (EIs.JatekItfc item : listeners) {
            item.actionValueChanged();
        }
    }
    
    
    private byte ajtok;
    private byte autohelye;
    private byte valasztott;
    private byte muveletsorrend;
    
    public Jatek(){
        this.ajtok=3;
        this.autohelye = (byte)(Math.random()*3);
        this.muveletsorrend = 0;
        this.valasztott = -1;
    }
    
    private byte getSzabad(){
        boolean both = false;
        byte i;
        for (i = 0; i < ajtok && !both; i++) {
            both = i != autohelye && i!= valasztott;
        }
        return (byte)(i-1);
    }
    
    public boolean doValaszt(byte melyik){
        muveletsorrend++;
        if(muveletsorrend == 2) GainsToFile.doNovel(
                this.valasztott == melyik ? (byte)1 : (byte)0,
                melyik == this.autohelye ? (byte)1 : (byte)0);
        this.valasztott = melyik;
        Jatek.broadcast();
        return muveletsorrend < 2;
    }
    
    public byte getAjtok(){
        return ajtok;
    }
    
    public byte getFelkinal(){
        return muveletsorrend == 1 ? getSzabad() : -1;
    }
    
    public byte getKincs(){
        return muveletsorrend == 2 ? autohelye : -1;
    }
}
