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

public class AtuadorL implements Atuador,Serializable {
    private boolean isOn;
    private int id;
    private SensorL sensorluz;
    /**
     * 
     * @param id do atuador
     * @param sensorluz sensor de luz
     */
    public AtuadorL(int id, SensorL sensorluz) {
        this.isOn = false;
        this.id=id;
        this.sensorluz=sensorluz;
        
    }
    /**
     * 
     * @param sensor_luz sensor de luz
     */
    public void setsensor_luz(SensorL sensor_luz){
        this.sensorluz=sensor_luz;
    }
    /**
     * 
     * @return sensor de luz 
     */
    public SensorL getSensorLuz() {
        return this.sensorluz;
        
    }
    /**
     * 
     * @return se está ativo 
     */
    @Override
    public boolean getIsOn() {
        return this.isOn;
    }
    /**
     * 
     * @return id do atuador
     */
    @Override
    public int getid(){
        return this.id;
    }
    
    /**
     * 
     * @param id  id do atuador
     */
    @Override
    public void setid(int id){
        this.id=id;
    }
    /**
     * 
     * @param isOn ativo ou nao
     */
    @Override
    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }
    /**
     * 
     * @param intensidadeLuz nova intensidade da luz
     */
    public void alterarIntensidadeLuz(int intensidadeLuz) {
        if (this.sensorluz.getIsOn() && this.isOn) {
            if (intensidadeLuz >= 0 && intensidadeLuz <= 100) {
                this.sensorluz.setIntensidadeluz(intensidadeLuz);
                System.out.println("A intensidade da luz atualmente é de: " + this.sensorluz.getIntensidadeluz());
            } else {
                System.out.println("A intensidade da luz deve estar na escala de (0-100)!");
            }
        } else {
            System.out.println("O sensor de luz e/ou o interruptor estão desligados!");
        }
    }
    /**
     * mostra o valor da intensidade da luz
     */
    public void mostrarIntensidadeLuz() {
        if (this.sensorluz.getIsOn() && this.isOn) {
            System.out.println("A intensidade da luz atualmente é de: " + this.sensorluz.getIntensidadeluz()+ " numa escala de (0-100)");
        } else {
            System.out.println("O sensor de luz e/ou o interruptor estão desligados!");
        }
    }
}
