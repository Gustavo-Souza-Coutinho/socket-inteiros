package com.example.socketinteiros;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do Primeiro numero:"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do Segundo numero"));

        try (Socket conexao = new Socket("127.0.0.1", 40000)) {

            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());


            saida.writeInt((int) n1);
            saida.writeInt((int) n2);
            saida.flush();

            int maior = entrada.readInt();

            if(maior == 0){
                JOptionPane.showMessageDialog(null, "Os numeros são iguais ");
            }
            else{
                JOptionPane.showMessageDialog(null, "O maior numero é: " + maior);}


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

