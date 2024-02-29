package com.example.socketinteiros;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(40000)) {
            while (true) {
                try (Socket conexao = servidor.accept();
                     ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
                     ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream())) {

                    int n1 = entrada.readInt();
                    int n2 = entrada.readInt();
                    int maior = 0;

                    if(n1 > n2){
                      maior = n1;
                    }
                    if(n1 < n2){
                        maior = n2;
                    }
                    if(n1 == n2){
                       maior = 0;
                    }

                    saida.writeInt(maior);
                    saida.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


