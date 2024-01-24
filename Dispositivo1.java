/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog1;
import java.io.Serializable;

/**
 *
 * @author luisc
 */public class Dispositivo1 implements Serializable{
     /**
      * estado do dispositivo
      */
    private boolean isActive;
    /**
     * id do dispositivo
     */
    private int iD;
    /**
     * tipo do dispositivo
     */
    private TipoDispositivo tipo;
    /**
     * sensor
     */
    private Sensor sensor;
    /**
     * atuador
     */
    private Atuador atuador;
    /**
     * 
     * @param tipo tipo do dispositivo
     * @param iD id do dispositivo
     * @param id_atuador id do atuador
     * @param id_sensor id do sensor
     */
    public Dispositivo1(TipoDispositivo tipo, int iD, int id_atuador, int id_sensor) {
        this.iD = iD;
        this.isActive = false;
        this.tipo = tipo;

        if (tipo == TipoDispositivo.AC) {
            this.sensor = new SensorC(id_sensor);
            this.atuador= new AtuadorC(id_atuador, (SensorC)sensor);
        } else if (tipo == TipoDispositivo.LAMP) {
            this.sensor = new SensorL(id_sensor);
            this.atuador = new AtuadorL(id_atuador,(SensorL)sensor);
        }
    }
    /**
     * 
     * @param intensity valor da intensidade da luz
     */
    public void intensidade_luz(int intensity) {
        if (tipo == TipoDispositivo.LAMP) {
            ((AtuadorL) atuador).alterarIntensidadeLuz(intensity);
        }else{
            System.out.println("Neste dispositivo nao é possivel definir a intensidade da luz!");
        }
    }
    /**
     * 
     * @param temperatura valor da temperatura na sala
     */
    public void mudar_temperatura(float temperatura){
       if(tipo == TipoDispositivo.AC){
           ((AtuadorC) atuador).alterar_temperatura(temperatura);
       }else{
           System.out.println("Neste dispositivo nao e possivel alterar a temperatura!");
       }
    }
    /**
     * 
     */
    public void mostrar_temperatura(){
        if(tipo == TipoDispositivo.AC){
            ((AtuadorC)atuador).mostrar_temperatura();
        }else{
            System.out.println("Neste dispostivo nao é possivel apresentar a temperatura!");
        }
    }
    /**
     * 
     */
    public void mostrar_intensidade(){
        if(tipo == TipoDispositivo.LAMP){
            ((AtuadorL) atuador).mostrarIntensidadeLuz();
        }else{
            System.out.println("Neste dispositivo nao é possivel mostrar o valor da intensidade da luz!");
        }
    }
    

    /**
     * 
     * @return tipo do dispositivo
     */
    public TipoDispositivo getTipo() {
        return tipo;
    }
    /**
     * 
     * @return estado atual do dispositivo
     */
    public boolean isIsActive() {
        return isActive;
    }
    /**
     * 
     * @return id do dispositivo
     */
    public int getiD() {
        return iD;
    }
    /**
     * 
     * @param tipo do dispositivo
     */
    public void setTipo(TipoDispositivo tipo) {
        this.tipo = tipo;
    }
    /**
     * 
     * @param isActive se esta ativo ou nao
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    /**
     * 
     * @param iD do dispositivo
     */
    public void setiD(int iD) {
        this.iD = iD;
    }
    /**
     * 
     */
    public void turnOn() {
        if (!isActive) {
             this.sensor.setIsOn(true);
             this.atuador.setIsOn(true);
             this.isActive = true;
             System.out.println("Dispositivo ligado com sucesso");
        } else {
            System.out.println("O Dispositivo já se encontra ligado!");
        }
    }
    /**
     * 
     */
    public void turnOff() {
        if (isActive) {
            this.sensor.setIsOn(false);
            this.atuador.setIsOn(false);
            this.isActive = false;
            System.out.println("O dispositivo está agora desligado!");
        } else {
            System.out.println("O dispositivo já se encontrava desligado!");
        }
    }

}

