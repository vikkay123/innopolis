package ru.innopolis.vikkay.stc.Part1.lesson11;

import java.io.*;
import java.net.Socket;

/**
 * Задание 1. Разработать приложение - многопользовательский чат, в котором участвует произвольное количество клиентов.
 *            Каждый клиент после запуска отправляет свое имя серверу. После чего начинает отправлять ему сообщения.
 *            Каждое сообщение сервер подписывает именем клиента и рассылает всем клиентам (broadcast).
 *
 * Задание 2.  Усовершенствовать задание 1:
 *
 *             a. добавить возможность отправки личных сообщений (unicast).
 *             b. добавить возможность выхода из чата с помощью написанной в чате команды «quit»
 *
 *
 *  Клиентская часть. Запуск в классе Client
 *
 *  @author Viktor Kochetkov
 *  @version 1.0 (4.04.2021)
 */

class ClientSomthing {

    private Socket socket;
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток чтения в сокет
    private BufferedReader inputUser; // поток чтения с консоли
    private String addr; // ip адрес клиента
    private int port; // порт соединения
    private String nickname; // имя клиента

    public ClientSomthing(String addr, int port) {
        this.addr = addr;
        this.port = port;

        try {
            this.socket = new Socket(addr, port);

            inputUser = new BufferedReader(new InputStreamReader(System.in));           // чтение с консоли
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    // поток чтения из сокета
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // поток записи в сокет


            pressNickname();         // вводим имя пользователя
            new ReadMsg().start();   // запускаем нить читающую сообщения из сокета в бесконечном цикле
            new WriteMsg().start(); // запускаем нить пишущую сообщения в сокет приходящие с консоли в бесконечном цикле

        } catch (IOException err) {
            System.err.println("Ошибка создания сокета");
            socetClosed();
        }
    }

    private void pressNickname() {                       // вводим имя пользователя
        System.out.print("Введите свой ник: ");
        try {
            nickname = inputUser.readLine();
            out.write("Привет " + nickname + "\r\n");
            out.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при вводе имени. " + e.getMessage());
        }

    }

    private void socetClosed() {                       // закрываем сокет
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException err) {
        }
    }


    private class ReadMsg extends Thread {               // нить чтения сообщений с сервера
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = in.readLine();                // ждем сообщения с сервера
                    if (str.equals("quit")) {
                        socetClosed();
                        break;                          // выходим из цикла если пришло "quit"
                    }
                    System.out.println(str);            // выводим сообщение с сервера на консоль
                }
            } catch (IOException e) {
                socetClosed();
            }
        }
    }


    public class WriteMsg extends Thread {               // нить отправляющая сообщения приходящие с консоли на сервер

        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine();      // сообщения с консоли
                    if (userWord.equals("quit")) {
                        out.write("quit" + "\r\n");
                        socetClosed();
                        break;
                    } else {
                        out.write(nickname + ": " + userWord + "\r\n"); // отправляем на сервер
                    }
                    out.flush();                          // выгружаем буфер
                } catch (IOException e) {
                    socetClosed();
                }
            }
        }
    }
}


public class Client {

    public static String ipAddr = "localhost";
    public static int port = 24365;

    public static void main(String[] args) throws IOException {

        new ClientSomthing(ipAddr, port);  // создание клиента

    }
}