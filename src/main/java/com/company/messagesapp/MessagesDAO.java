/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.messagesapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Walter White
 */
public class MessagesDAO {

    public static void createMessageDB(Message message) {
        try {
            PreparedStatement ps = null;

            String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, message.getMessage());
            ps.setString(2, message.getAuthor());
            ps.executeUpdate();
            System.out.println("Mensaje Creado Correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readMessagesDB() {
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String query = "SELECT * FROM mensajes";
            ps = MyConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Message: " + rs.getString("mensaje"));
                System.out.println("Author: " + rs.getString("autor_mensaje"));
                System.out.println("Date: " + rs.getString("fecha_mensaje") + "\n");
            }

        } catch (SQLException e) {
            System.out.println("No se pudo recuperar los mensajes");
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMessageDB(int idMessage) {
        try {
            PreparedStatement ps = null;

            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
            ps = MyConnection.getConnection().prepareStatement(query);

            ps.setInt(1, idMessage);

            ps.executeUpdate();

            System.out.println("Mensaje Borrado Correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo borrar el mensaje");
            System.out.println(e.getMessage());
        }
    }

    public static void updateMessageDB(Message message) {
        try {
            PreparedStatement ps = null;

            String query = "UPDATE mensajes SET mensaje = ? WHERE mensajes.id_mensaje = ?";
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, message.getMessage());
            ps.setInt(2, message.getIdMessage());

            ps.executeUpdate();

            System.out.println("Mensaje Actualizado Correctamente");
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el mensaje");
            System.out.println(e.getMessage());
        }
    }
}
