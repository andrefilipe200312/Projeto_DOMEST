/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog1;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * @author Luis Palma 13743
 * @author Francisco Pechirra 13748
 * @author Andre Ferreira 13741 compile: javac prog1.java run: java prog1.class
 */

public class Sala implements Serializable {
    /**
     * 
     */
    private ArrayList<Dispositivo1> listaSistema;
    /**
     * 
     */
    private int id;
    /**
     * 
     */
    private TipoSala sala;
    /**
     * 
     * @param id da sala
     * @param sala tipo de sala
     */
    public Sala(int id, TipoSala sala) {
        this.id = id;
        this.sala = sala;
        this.listaSistema = new ArrayList<>();
    }
    /**
     * 
     * @return lista de dispositivos da sala
     */
    public ArrayList<Dispositivo1> getListaSistema() {
        return listaSistema;
    }
    /**
     * 
     * @return id da sala
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @return tipo da sala
     */
    public TipoSala getSala() {
        return sala;
    }
    /**
     * 
     * @param listaSistema lista de dispositivos
     */
    public void setListaSistema(ArrayList<Dispositivo1> listaSistema) {
        this.listaSistema = listaSistema;
    }
    /**
     * 
     * @param id da sala
     */
    private void setId(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @param sala tipo de sala
     */
    private void setSala(TipoSala sala) {
        this.sala = sala;
    }
    /**
     * 
     * @param id do dispositivo
     * @param tipoDis tipo de dispositivo
     * @param id_sensor id do sensor
     * @param id_atuador id do atuador
     */
    public void addDispositivo(int id, TipoDispositivo tipoDis, int id_sensor, int id_atuador) {
        Dispositivo1 dispositivo = new Dispositivo1(tipoDis, id, id_atuador, id_sensor);
        listaSistema.add(dispositivo);
        System.out.println("Dispositivo adicionado com sucesso!");
    }
    /**
     * 
     * @param id id do dispositivo
     */
    public void rmvDispositivo(int id) {
        for (int i = 0; i < listaSistema.size(); i++) {
            Dispositivo1 dispositivo = listaSistema.get(i);
            if (dispositivo.getiD() == id) {
                listaSistema.remove(i);
                System.out.println("Dispositivo removido com sucesso!");
                return;
            }
        }
        System.out.println("Dispositivo não encontrado na lista!");
    }
    /**
     * 
     * @param id do dispositivo
     */
    public void readSistem(int id) {
        for (Dispositivo1 dispositivo : listaSistema) {
            if (dispositivo.getiD() == id) {
                System.out.println("Tipo: " + dispositivo.getTipo());
                if (dispositivo.isIsActive()) {
                    System.out.println("O dispositivo está ligado");
                } else {
                    System.out.println("O dispositivo está desligado");
                }
                System.out.println("Id: " + dispositivo.getiD());
                return;
            }
        }
        System.out.println("Dispositivo não encontrado na lista!");
    }

}
