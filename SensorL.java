/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog1;
import java.io.Serializable;
/**
 * 
 * @author Luis Palma 13743
 * @author Francisco Pechirra 13748
 * @author Andre Ferreira 13741
 * compile: javac prog1.java 
 * run: java prog1.class
 */

public class SensorL implements Sensor, Serializable {
    private boolean isOn;
    private float intensidadeluz;
    private int id;

    /**
     * @param id do sensor
     */
    public SensorL(int id) {
        this.intensidadeluz = 0;
        this.isOn = false;
        this.id = id;
    }

    /**
     * @return isOn se está ativo ou não
     */
    @Override
    public boolean getIsOn() {
        return isOn;
    }
    @Override
    public int getid() {
        return id;
    }

    /**
     * @return intensity retorna o nivel de intensidade da luz
     */
    public float getIntensidadeluz() {
        return intensidadeluz;
    }
    @Override
    public void setid(int id) {
        this.id = id;
    }

    /**
     * @param isOn se o sensor está ativo ou não
     */
    @Override
    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    /**
     * @param intensidadeLuz a intensidade da luz
     */
    public void setIntensidadeluz(float intensidadeLuz) {
        if (intensidadeLuz >= 0 && intensidadeLuz <= 100) {
            this.intensidadeluz = intensidadeLuz;
        }
    }
    
    /**
     * 
     */
    public void turnOn() {
        if (!this.isOn) {
            this.isOn = true;
            System.out.println("O sensor de Luz encontra-se agora ligado!");
        } else {
            System.out.println("O sensor de Luz já se encontra ligado!");
        }
    }
    /**
     * 
     */
    public void turnOff() {
        if (this.isOn) {
            this.isOn = false;
            System.out.println("O sensor de Luz encontra-se desligado!");
        } else {
            System.out.println("O sensor de Luz já se encontra desligado!");
        }
    }
}
