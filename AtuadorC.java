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

public class AtuadorC implements Atuador,Serializable {
    /**
     * 
     */
    private SensorC sensortemp;
    /**
     * 
     */
    private boolean isOn;
    /**
     * 
     */
    private int id;

    /**
     *@param id do dispositivo
     *@param sensortemp  sensor de temperatura
     */
    public AtuadorC(int id, SensorC sensortemp) {
        this.id = id;
        this.isOn = false;
        this.sensortemp=sensortemp;

    }

    /**
     *
     * @return retorna se está ativo ou não
     */
    @Override
    public boolean getIsOn() {
        return isOn;
    }

    /**
     *
     * @return retorna o id do atuador
     */
    @Override
    public int getid() {
        return id;
    }

    /**
     *
     * @param isOn se está ativo ou não
     */
    @Override
    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }
    /**
     *
     * @param id do dispositivo
     */
    @Override
    public void setid(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @param temperatura pertendida
     */
    public void alterar_temperatura(float temperatura){
        if(temperatura >= 0 && temperatura<=30){
            this.sensortemp.setTemp(temperatura);
            System.out.println("A temperatura atual é de:" + this.sensortemp.getTemp());
        }else{
            System.out.println("Escolha uma temperatura valida!");
        }
    }
    /**
     * Mostrar a temperatura
     */
    
    public void mostrar_temperatura(){
        System.out.println("A temperatura atual da sala é de:" + this.sensortemp.getTemp());
    }

}
