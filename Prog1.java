/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.prog1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Luis Palma 13743
 * @author Francisco Pechirra 13748
 * @author Andre Ferreira 13741 compile: javac prog1.java run: java prog1.class
 */
public class Prog1 {
    /**
     * 
     * @param args argumentos
     */
    public static void main(String[] args) {
        int opcao;
        Scanner scanner = new Scanner(System.in);
        Consola consola = new Consola();
        consola.loadState("DOMEST.bin");
        try{
        while (true) {
            System.out.println("----------ESCOLHA MODO----------\n");
            System.out.println("-[1]Modo Manutenção            -\n");
            System.out.println("-[2]Modo Funcionamento         -\n");
            System.out.println("-[3]Sair                       -");
            System.out.println("--------------------------------\n");
            
            if(scanner.hasNextInt()){
                opcao = scanner.nextInt();
            }
            else{
                scanner.next();
                System.out.println("Insira um número válido.");
                continue;
            }
            

            if (opcao == 1) {
                System.out.println("----------MODO MANUTENÇÃO----------\n");
                System.out.println("-[1]Adicionar Sala                -\n");
                System.out.println("-[2]Adicionar Dispositivo a Sala  -\n");
                System.out.println("-[3]Remover Dispositivo da Sala   -\n");
                System.out.println("-[4]Remover Sala                  -\n");
                System.out.println("-[5]Reset                         -\n");
                System.out.println("-[6]Criar Relatório de texto      -\n");
                System.out.println("-[7]Voltar                        -\n");
                System.out.println("-----------------------------------\n");
                int opcaoManutencao;
                
                if(scanner.hasNextInt()){
                    opcaoManutencao = scanner.nextInt();
                }
                else{
                    scanner.next();
                    System.out.println("Insira um número válido...");
                    continue;
                }
                
                
                
                if (opcaoManutencao == 1) {
                    consola.adicionar_sala();
                } else if (opcaoManutencao == 2) {
                  consola.adicionar_dipositivo();
                } else if (opcaoManutencao == 3) {
                    consola.remover_sala();
                } else if (opcaoManutencao == 4) {
                    consola.remover_sala();
                }else if ( opcaoManutencao == 5){
                    consola.resetState("DOMEST.bin");
                }else if(opcaoManutencao == 6){
                    consola.saveStateToText("DOMEST.txt");
                }else if(opcaoManutencao == 7){
                    
                }else{
                    System.out.println("Escolha uma opcao valida!");
                }
            } else if (opcao == 2) {
                System.out.println("-------------------MODO FUNCIONAMENTO--------------------\n");
                System.out.println("-[1]Apresentar lista de salas                           -\n");
                System.out.println("-[2]Apresentar lista de dispositivos ordenado por Sala  -\n");
                System.out.println("-[3]Ligar dispositivo de uma das salas                  -\n");
                System.out.println("-[4]Desligar dispositivo de uma das salas               -\n");
                System.out.println("-[5]Definir a intensidade da luz                        -\n");
                System.out.println("-[6]Definir o valor da Temperatura                      -\n");
                System.out.println("-[7]Obter valor da intensidade da luz                   -\n");
                System.out.println("-[8]Obter o valor da Temperatura                        -\n");
                System.out.println("-[9]Armazenar estado do programa                        -\n");
                System.out.println("-[10]Apresentar lista de dispositivos ordenados Por tipo-\n");
                System.out.println("-[11]Voltar                                             -\n");
                System.out.println("---------------------------------------------------------\n");
                int opcaoFunc;
                
                if(scanner.hasNextInt()){
                    opcaoFunc = scanner.nextInt();
                }
                else{
                    scanner.next();
                    System.out.println("Insira um número válido.");
                    continue;
                }

                
                if (opcaoFunc == 1) {
                    consola.show_rooms();
                }else if(opcaoFunc == 2){
                    consola.apresentar_dis();
                }else if (opcaoFunc == 3) {
                    consola.ligar_disp();
                }else if (opcaoFunc == 4) {
                   consola.desligar_disp();
                }else if (opcaoFunc == 5){
                    consola.definir_intensidade();
                }else if(opcaoFunc == 6){
                    consola.definir_temperatura();
                }else if(opcaoFunc == 7){
                    consola.mostrar_intensidade();
                }else if(opcaoFunc == 8){
                    consola.mostrar_temperatura();
                }else if(opcaoFunc == 9){
                    consola.saveState("DOMEST.bin");
                }else if(opcaoFunc == 10){
                    consola.apresentar_dis_tipo();
                }else if(opcaoFunc == 11){
                    
                }else{
                    System.out.println("Escolha uma opcao valida");
                }
                
            }else if(opcao == 3){
                System.out.println("Guardando dados...");
                consola.saveState("DOMEST.bin");
                System.out.println("Terminando...");
                break;
            }
        }
        }
        
        catch(InputMismatchException e){
            System.out.println("Insira um número válido...");
        }
        
        
        finally{
            scanner.close();
        }
    }

}
