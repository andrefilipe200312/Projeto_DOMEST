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

public class SensorC implements Sensor, Serializable {

    private float temp;
    private int id;
    private boolean isOn;

    /**
     * Construtor da classe SensorC.
     *
     * @param id Identificador do sensor.
     */
    public SensorC(int id) {
        this.temp = 0;
        this.id = id;
        this.isOn = false;
    }
    /**
     * 
     * @return se o sensor está ativo ou não
     */
    @Override
    public boolean getIsOn(){
        return isOn;
    }

    /**
     * Obtém a temperatura atual do sensor.
     *
     * @return Temperatura do sensor.
     */
    public float getTemp() {
        return temp;
    }

    /**
     * Obtém o identificador do sensor.
     *
     * @return Identificador do sensor.
     */
    @Override
    public int getid() {
        return id;
    }

    /**
     * Define a temperatura do sensor.
     *
     * @param temp Nova temperatura a ser definida.
     */
    public void setTemp(float temp) {
        this.temp = temp;
    }
    
    /**
     * 
     * @param isOn se o sensor esta ativo ou não
     */
    @Override
    public void setIsOn(boolean isOn){
        this.isOn=isOn;
    }

    /**
     * Define o identificador do sensor.
     *
     * @param id Novo identificador a ser definido.
     */
    @Override
    public void setid(int id) {
        this.id = id;
    }

    /**
     * Liga o sensor de temperatura.
     */
    public void turnOn() {
        if (!this.isOn) {
            this.isOn = true;
            System.out.println("O sensor de temperatura está agora ligado!");
        } else {
            System.out.println("O sensor de temperatura já se encontra ligado!");
        }
    }

    /**
     * Desliga o sensor de temperatura.
     */
    public void turnOff() {
        if (this.isOn) {
            this.isOn = false;
            System.out.println("O sensor de temperatura está desligado!");
        } else {
            System.out.println("O sensor de temperatura já se encontra desligado!");
        }
    }
}