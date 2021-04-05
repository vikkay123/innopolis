package ru.innopolis.vikkay.stc.Part1.lesson11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Задание 1. Разработать приложение - многопользовательский чат, в котором участвует произвольное количество клиентов.
 * Каждый клиент после запуска отправляет свое имя серверу. После чего начинает отправлять ему сообщения.
 * Каждое сообщение сервер подписывает именем клиента и рассылает всем клиентам (broadcast).
 *
 * Задание 2.  Усовершенствовать задание 1:
 *
 * a. добавить возможность отправки личных сообщений (unicast).
 * b. добавить возможность выхода из чата с помощью написанной в чате команды «quit»
 *
 * Серверная часть. Запуск в классе Server
 *
 * @author Viktor Kochetkov
 * @version 1.0 (4.04.2021)
 */

class ServerSomthing extends Thread {

    private Socket socket;       // сокет, через который сервер общается с клиентом,
    private BufferedReader in;   // поток чтения из сокета
    private BufferedWriter out;  // поток записи в сокет


    public ServerSomthing(Socket socket) throws IOException {

        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        start(); // вызываем run()
    }

    @Override
    public String toString() {
        return "TCPconnection: " + this.socket.getInetAddress() + " : " + this.socket.getPort();
    }

    @Override
    public void run() {
        String str;

        try {
            while (true) {
                str = in.readLine();
                if (str.equals("quit")) {  // Если ввели quit - выходим из цикла прослушки
                    socket.close();
                    in.close();
                    out.close();
                    break;
                }
                System.out.println("Echo: " + str);

                for (ServerSomthing ss : Server.serverList) {
                    ss.send(str); // отослать принятое сообщение всем остальным
                }
            }


        } catch (NullPointerException err) {

        } catch (IOException e) {
            System.err.println("Что-то пошло не так. " + e.getMessage());
        }

    }


    private void send(String msg) {    //отсылка сообщения клиенту
        try {
            out.write(msg + "\r\n");
            out.flush();
        } catch (IOException e) {

        }
    }
}


public class Server {

    public static final int PORT = 24365;

    public static ArrayList<ServerSomthing> serverList = new ArrayList<>(); // список всех контактов


    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started...");

        try {
            while (true) {
                Socket socket = server.accept();                  // ждем подключение
                try {
                    serverList.add(new ServerSomthing(socket)); // добавить новое соединенние в список
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}