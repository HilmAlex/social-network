/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.messagesapp;
import java.util.Scanner;

/**
 *
 * @author Walter White
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int option = 0;
        do {
            System.out.println("-----------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1. crear mensaje");
            System.out.println(" 2. listar mensajes");
            System.out.println(" 3. eliminar mensaje");
            System.out.println(" 4. editar mensaje");
            System.out.println(" 5. salir");
            //leemos la opcion del usuario
            option = scanner.nextInt();

            switch (option){
                case 1:
                    MessagesService.createMessage();
                    break;
                case 2:
                    MessagesService.readMessages();
                    break;
                case 3:
                    MessagesService.deleteMessage();
                    break;
                case 4:
                    MessagesService.updateMessage();
                    break;
                default:
                    break;
            }
        } while (option != 5);

        MyConnection connection = new MyConnection();
        try {
            java.sql.Connection cnx = connection.getConnection();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
