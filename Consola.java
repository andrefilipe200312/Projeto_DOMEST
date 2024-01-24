/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Luis Palma 13743
 * @author Francisco Pechirra 13748
 * @author Andre Ferreira 13741 compile: javac prog1.java run: java prog1.class
 */
/**
 * Modo programador permite CRUDE de salas, sistemas , Acesso direto a
 * setter/getter
 */
/**
 * Modo utilizador permite apenas vizualizar e defenir alguns parametros
 */
/**
 * A Classe {Consola} permite ao utilizador vizualizar as salas. Caso o modo
 * programador seja ativado permite criar, remover, vizualizar salas , ligar e
 * desligar Consola. Caso o modo utilizador esteja activo permite vizualizar
 * todas salas ativas
 */
public class Consola implements Serializable {

    /**
     * lista de salas
     */
    private ArrayList<Sala> listaSalas;
    /**
     * inicialização do scanner
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * construtor da consola
     */
    public Consola() {
        this.listaSalas = new ArrayList<>();

    }

    /**
     *
     * @return lista de salas
     */
    public ArrayList<Sala> getListaSalas() {
        return listaSalas;
    }

    /**
     *
     * @param listaSalas lista de salas
     */
    public void setListaSalas(ArrayList<Sala> listaSalas) {
        this.listaSalas = listaSalas;
    }

    /**
     *
     * @param id do dispositivo
     */
    public void rmvRoom(int id) {
        int tamanho_listaSalas = listaSalas.size();
        for (int i = 0; i < tamanho_listaSalas; i++) {
            Sala sala = listaSalas.get(i);
            if (sala.getId() == id) {
                listaSalas.remove(i);
                System.out.println("Sala Removida com sucesso");
                return;
            }
        }

    }

    /**
     *
     * @param id do dispositivo
     * @param tipo tipo de sala
     */
    public void addRoom(int id, TipoSala tipo) {
        Sala novasala = new Sala(id, tipo);
        listaSalas.add(novasala);
        System.out.println("Sala adicionada com sucesso!");

    }

    /**
     *
     * @param listaSalas lista de salas
     * @param id do dispositivo
     * @param tipo tipo de sala
     */
    public void seeRoom(ArrayList<Sala> listaSalas, int id, TipoSala tipo) {
        int tamanhoListaSalas = listaSalas.size();
        for (int i = 0; i < tamanhoListaSalas; i++) {
            Sala sala = listaSalas.get(i);
            if (sala.getId() == id) {
                System.out.println(sala.getId());
                System.out.println(sala.getListaSistema());
                System.out.println(sala.getSala());
            }
        }

    }

    /**
     * metodo responsavel por adicionar uma nova sala
     */
    public void adicionar_sala() {
        System.out.println("Digite o id da sala:\n");
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            scanner.next();
            System.out.println("Insira um número válido para o ID...");
            return;
        }
        
        
        boolean flag_sala_rep = false;
        for (Sala sala : listaSalas) {
            if (sala.getId() == id) {
                flag_sala_rep = true;
            }
        }
        if (flag_sala_rep == false) {
            System.out.println("------------Escolha o tipo de sala----------\n");
            System.out.println("-[1]Escritório                             -\n");
            System.out.println("-[2]Sala de estar                          -\n");
            System.out.println("-[3]Quarto                                 -\n");
            System.out.println("-[4]Cozinha                                -\n");
            System.out.println("--------------------------------------------\n");
            int tiposala;
            
            if(scanner.hasNextInt()){
                tiposala = scanner.nextInt();
            } else {
                //limpar buffer;
                scanner.next();
                System.out.println("Insira um número válido para o tipo de sala");
                return;
            }

            switch (tiposala) {
                case 1 ->
                    addRoom(id, TipoSala.OFFICE);
                case 2 ->
                    addRoom(id, TipoSala.LIVROOM);
                case 3 ->
                    addRoom(id, TipoSala.BEDROOM);
                case 4 ->
                    addRoom(id, TipoSala.KITCHEN);
                default ->
                    System.out.println("Escolha uma opcao valida!");
            }
        } else if (flag_sala_rep == true) {
            System.out.println("Ja existe uma sala com esse id!");
        }

    }

    /**
     * metodo responsavel por adicionar um novo dispositivo
     */
    public void adicionar_dipositivo() {
        System.out.println("Digite o id da Sala a qual deseja adicionar um dispositivo:");
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        boolean flag_id_rep = false;
        for (Sala sala : listaSalas) {
            ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
            for (Dispositivo1 dispositivo : listaDispositivos) {
                if (dispositivo.getiD() == id) {
                    flag_id_rep = true;
                }
            }

        }
        if (flag_id_rep == false) {
            for (Sala sala : listaSalas) {

                if (sala.getId() == id) {
                    System.out.println("Sala encontrada!");

                    System.out.println("Digite o ID do dispositivo:");
                    int idDispositivo;
                    
                    //Tratar; caso o input seja mal introduzido....
                    if(scanner.hasNextInt()){
                        idDispositivo = scanner.nextInt();
                    } else {
                        //Limpar buffer;
                        scanner.next();
                        System.out.println("Insira um número válido...");
                        return;
                    }
                    
                    
                    System.out.println("Digite o ID do sensor:");
                    int idSensor;
                    
                    //Tratar; caso o input seja mal introduzido....
                    if(scanner.hasNextInt()){
                        idSensor = scanner.nextInt();
                    } else {
                        //Limpar buffer;
                        scanner.next();
                        System.out.println("Insira um número válido...");
                        return;
                    }
                    
                    System.out.println("Digite o ID do atuador:");
                    int idAtuador;
                    
                    //Tratar; caso o input seja mal introduzido....
                    if(scanner.hasNextInt()){
                        idAtuador = scanner.nextInt();
                    } else {
                        //Limpar buffer;
                        scanner.next();
                        System.out.println("Insira um número válido...");
                        return;
                    }
                    
                    
                    System.out.println("Escolha o tipo de dispositivo:");
                    System.out.println("[1] Ar condicionado");
                    System.out.println("[2] Lâmpada");
                    
                    
                    int tipoDispositivo;
                    
                    //Tratar; caso o input seja mal introduzido....
                    if(scanner.hasNextInt()){
                    tipoDispositivo = scanner.nextInt();
                    } else {
                        //Limpar buffer;
                        scanner.next();
                        System.out.println("Insira um número válido...");
                        return;
                    }

                    if (tipoDispositivo == 1) {
                        sala.addDispositivo(idDispositivo, TipoDispositivo.AC, idSensor, idAtuador);
                    } else if (tipoDispositivo == 2) {
                        sala.addDispositivo(idDispositivo, TipoDispositivo.LAMP, idSensor, idAtuador);
                    } else {
                        System.out.println("Selecione uma opcao valida!");
                    }
                }
            }
        } else {
            System.out.println("O id do dispositivo já existe!");
        }
    }

    /**
     * metodo responsavel por remover um dispositivo
     */
    public void remover_dispositivo() {
        boolean flag_sala_present = false;
        System.out.println("Digite o id da Sala a qual deseja remover um dispositivo:\n");
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        
        
        for (Sala sala : listaSalas) {
            if (sala.getId() == id) {
                System.out.println("Digite o id do dispositivo:\n");
                int idDispositivo;
                
                
                if(scanner.hasNextInt()){
                    idDispositivo = scanner.nextInt();
                } else {
                    //Limpar buffer;
                    scanner.next();
                    System.out.println("Insira um número válido...");
                    return;
                }
                
                
                sala.rmvDispositivo(idDispositivo);
                flag_sala_present = true;
            }
        }
        if (flag_sala_present == false) {
            System.out.println("A sala nao existe!");
        }

    }

    /**
     * metodo responsavel por remover uma sala
     */
    public void remover_sala() {
        System.out.println("Digite o id da sala:\n");
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        
        
        rmvRoom(id);
        System.out.println("Sala Removida");
    }

    /**
     * metodo responsavel por mostrar uma lista de salas
     */
    public void show_rooms() {
        for (Sala sala : listaSalas) {
            System.out.println("id:" + sala.getId() + "Divisao:" + sala.getSala());
        }
        if (listaSalas.isEmpty()) {
            System.out.println("Não existem Salas ainda!");
        }

    }

    /**
     * metodo responsavel por mostrar uma lista de dispositivo agrupado por sala
     */
    public void apresentar_dis() {
            for (Sala sala : listaSalas) {
                ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
                System.out.println("Sala:" + sala.getId() + "tipo:" + sala.getSala());
                for (Dispositivo1 dispositivo : listaDispositivos) {
                    System.out.println("Tipo:" + dispositivo.getTipo() + "id:" + dispositivo.getiD());
                }
            }
    }

    /**
     * metodo reponsavel por mostrar uma lista de dipositivos ordenados por tipo
     */
    public void apresentar_dis_tipo() {
        ArrayList<Dispositivo1> todosDispositivos = new ArrayList<>();

        for (Sala sala : listaSalas) {
            todosDispositivos.addAll(sala.getListaSistema());
        }
        if (!todosDispositivos.isEmpty()) {
            Collections.sort(todosDispositivos, Comparator.comparing(Dispositivo1::getTipo));
            System.out.println("Lista de Dispositivos Ordenada por Tipo:");
            for (Dispositivo1 dispositivo : todosDispositivos) {
                System.out.println("Tipo:" + dispositivo.getTipo() + " ID:" + dispositivo.getiD());
            }
        } else {
            System.out.println("A lista de dispositivos está vazia!!");
        }

    }

    /**
     * metodo responsavel por ligar o dispositivo de uma determinada sala
     */
    public void ligar_disp() {
        boolean flag_present = false;
        System.out.println("Digite o id da sala que deseja ligar o dispositivo:");
        
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        
        for (Sala sala : listaSalas) {
            if (sala.getId() == id) {
                System.out.println("Digite o id do dispositivo a ligar:");
                int idDispositivo = scanner.nextInt();
                ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
                for (Dispositivo1 dispositivo : listaDispositivos) {
                    if (dispositivo.getiD() == idDispositivo) {
                        dispositivo.turnOn();
                        flag_present = true;
                    }
                }
            }
        }
        if (flag_present == false) {
            System.out.println("O dipositivo ou a sala que procura nao esta na lista!");
        }

    }

    /**
     * metodo responsavel por deligar um dispositivo de uma determinada sala
     */
    public void desligar_disp() {
        boolean flag_present = false;
        System.out.println("Digite o id da sala que deseja desligar o dispositivo:");
        
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        
        for (Sala sala : listaSalas) {
            if (sala.getId() == id) {
                System.out.println("Digite o id do dispositivo a desligar:");
                int idDispositivo = scanner.nextInt();
                ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
                for (Dispositivo1 dispositivo : listaDispositivos) {
                    if (dispositivo.getiD() == idDispositivo) {
                        dispositivo.turnOff();
                        flag_present = true;
                    }
                }
            }
        }
        if (flag_present == false) {
            System.out.println("O dipositivo ou a sala que procura nao esta na lista!");
        }
    }

    /**
     * metodo responsavel por alterar a intensidade da luz
     */
    public void definir_intensidade() {
        boolean flag_present = false;
        System.out.println("Digite o id da sala em que deseja definir a intensidade da luz:");
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        
        
        for (Sala sala : listaSalas) {
            if (sala.getId() == id) {
                System.out.println("Digite o id do dispositivo:");
                int idDispositivo = scanner.nextInt();
                ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
                for (Dispositivo1 dispositivo : listaDispositivos) {
                    if (dispositivo.getiD() == idDispositivo) {
                        System.out.println("Defina o valor da intesidade da luz numa escala de (0,100)");
                        int intensidade = scanner.nextInt();
                        dispositivo.intensidade_luz(intensidade);
                        flag_present = true;
                    }
                }
            }
        }
        if (flag_present == false) {
            System.out.println("O dipositivo ou a sala que procura nao esta na lista!");
        }
    }

    /**
     * metodo responsavel por alterar a temperatua
     */
    public void definir_temperatura() {
        boolean flag_present = false;
        System.out.println("Digite o id da sala que deseja mudar a temperatura:");
        
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        
        
        for (Sala sala : listaSalas) {
            if (sala.getId() == id) {
                System.out.println("Digite o id do dispositivo:");
                int idDispositivo = scanner.nextInt();
                ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
                for (Dispositivo1 dispositivo : listaDispositivos) {
                    if (dispositivo.getiD() == idDispositivo) {
                        System.out.println("Defina o valor a temperatura numa escala de (0,30):");
                        float temperatura = Float.parseFloat(scanner.next());
                        dispositivo.mudar_temperatura(temperatura);
                        flag_present = true;
                    }
                }
            }
        }
        if (flag_present == false) {
            System.out.println("O dipositivo ou a sala que procura nao esta na lista!");
        }
    }

    /**
     * metodo responsavel por mostrar a intensidade da luz
     */
    public void mostrar_intensidade() {
        boolean flag_present = false;
        System.out.println("Digite o id da sala que deseja verifcar a intensidade da luz:");
        int id;
        
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        
        
        for (Sala sala : listaSalas) {
            if (sala.getId() == id) {
                System.out.println("Digite o id do dispositivo:");
                int idDispositivo = scanner.nextInt();
                ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
                for (Dispositivo1 dispositivo : listaDispositivos) {
                    if (dispositivo.getiD() == idDispositivo) {
                        dispositivo.mostrar_intensidade();
                        flag_present = true;
                    }
                }
            }
        }
        if (flag_present == false) {
            System.out.println("O dipositivo ou a sala que procura nao esta na lista!");
        }
    }

    /**
     * metodo responsavel por mostrar a temperatura
     */
    public void mostrar_temperatura() {
        boolean flag_present = false;
        System.out.println("Digite o id do sala que deseja ver a temperatura:");
        int id;
        
        if(scanner.hasNextInt()){
            id = scanner.nextInt();
        } else {
            //Limpar buffer;
            scanner.next();
            System.out.println("Insira um número válido...");
            return;
        }
        
        
        for (Sala sala : listaSalas) {
            if (sala.getId() == id) {
                System.out.println("Digite o id do dispositivo:");
                int idDispositivo = scanner.nextInt();
                ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
                for (Dispositivo1 dispositivo : listaDispositivos) {
                    if (dispositivo.getiD() == idDispositivo) {
                        dispositivo.mostrar_temperatura();
                        flag_present = true;
                    }
                }
            }
        }
        if (flag_present == false) {
            System.out.println("O dipositivo ou a sala que procura nao esta na lista!");
        }
    }

    /**
     *
     * @param fileName nome do ficheiro binario para guardar o estado do
     * programa
     */
    public void saveState(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(listaSalas);
            System.out.println("Domest guardado com sucesso!");
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }
    }

    /**
     *
     * @param fileName nome do ficheiro binário em que esta armazenado o
     * programa
     */
    public void loadState(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            listaSalas = (ArrayList<Sala>) ois.readObject();
            System.out.println("Domest Carregado!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading state: " + e.getMessage());
        }
    }

    /**
     *
     * @param fileName nome do ficheiro binario a fazer reset
     */
    public void resetState(String fileName) {
        try {
            // Verifica se o arquivo existe
            File file = new File(fileName);
            if (file.exists()) {
                // Exclui o arquivo existente
                if (file.delete()) {
                } else {
                    System.out.println("Erro ao excluir o arquivo existente.");
                    return;
                }
            }

            // Cria um novo arquivo
            file.createNewFile();
            System.out.println("Novo arquivo criado com sucesso!");

            // Limpa a lista de salas
            listaSalas.clear();
        } catch (IOException e) {
            System.err.println("Erro ao efetuar reset do arquivo: " + e.getMessage());
        }
    }

    /**
     *
     * @param fileName nome do ficheiro onde ira ser guardado o relatorio
     */
    public void saveStateToText(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Escreve as informações de cada sala no arquivo
            for (Sala sala : listaSalas) {
                writer.write("ID da Sala: " + sala.getId() + "\n");
                writer.write("Tipo de Sala: " + sala.getSala() + "\n");
                // Escreve as informações de cada dispositivo na sala
                ArrayList<Dispositivo1> listaDispositivos = sala.getListaSistema();
                for (Dispositivo1 dispositivo : listaDispositivos) {
                    writer.write("  ID do Dispositivo: " + dispositivo.getiD() + "\n");
                    writer.write("  Tipo de Dispositivo: " + dispositivo.getTipo() + "\n");
                    writer.write("\n");
                }

                // Adiciona uma linha em branco entre salas
                writer.write("\n");
            }

            System.out.println("Estado do projeto salvo com sucesso em arquivo de texto!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar estado do projeto em arquivo de texto: " + e.getMessage());
        }
    }

}
