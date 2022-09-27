package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.*;

public class Server {

    private static ExecutorService start() {
        ExecutorService executorService = Executors.newFixedThreadPool(64);
        return executorService;
    }

    public static void connectionHandler() {
        ExecutorService es = start();
        try (final var serverSocket = new ServerSocket(9999)) {
            while (true) {
                MyRunnable myRunnable = new MyRunnable();
                final var socket = serverSocket.accept();
                myRunnable.setSocket(socket);
                es.submit(myRunnable);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}