/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.prog1;

/**
 *
 * @author andre
 */
public interface Atuador {
    /**
     * 
     * @return se esta ativo ou nao
     */
    boolean getIsOn();
    /**
     * 
     * @param isOn se esta ativo ou nao
     */
    void setIsOn(boolean isOn);
    /**
     * 
     * @return id do dispositivo
     */
    int getid();
    /**
     * 
     * @param id do dispositivo
     */
    void setid(int id);
    
}
