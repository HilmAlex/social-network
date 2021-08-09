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
public class MessagesService {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void createMessage() {
        
        System.out.println("Escriba un mensaje");
        String messageStr = scanner.nextLine();
        System.out.println("Escriba el autor");
        String author = scanner.nextLine();

        Message message = new Message();
        message.setMessage(messageStr);
        message.setAuthor(author);

        MessagesDAO.createMessageDB(message);
    }

    public static void readMessages() {       
        MessagesDAO.readMessagesDB();
    }

    public static void deleteMessage() {
        
        System.out.println("Ingrese el id del mensaje a borrar");
        int idMessage = scanner.nextInt();
        
        MessagesDAO.deleteMessageDB(idMessage);
    }

    public static void updateMessage() {
     
        System.out.println("Escriba un nuevo mensaje");
        String message = scanner.nextLine();
        
        System.out.println("Indica el id el mensaje a editar");
        int idMessage = scanner.nextInt();

        Message newMessage = new Message();
        newMessage.setMessage(message);
        newMessage.setIdMessage(idMessage);

        MessagesDAO.updateMessageDB(newMessage);
        
    }
}
