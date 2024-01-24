/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.prog1;

/**
 *
 * @author andre
 */
public interface Sensor {
    /**
     * 
     * @return estado do sensor
     */
    boolean getIsOn();
    /**
     * 
     * @param isOn estado do sensor
     */
    void setIsOn( boolean isOn);
    /**
     * 
     * @return id do sensor
     */
    int getid();
    /**
     * 
     * @param id id do sensor
     */
    void setid(int id);
}
