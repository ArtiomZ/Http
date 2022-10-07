package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Server {
    static Map<String, HTTPHandler> GETHandlers = new HashMap<>();
    static Map<String, HTTPHandler> POSTHandlers = new HashMap<>();

    private static ExecutorService start() {
        ExecutorService executorService = Executors.newFixedThreadPool(64);
        return executorService;
    }

    public void connectionHandler() {
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

    public void addHandler(String method, String path, HTTPHandler handler) {
        if (method.equals("GET")) {
            GETHandlers.put(method + path, handler);
        } else {
            POSTHandlers.put(method + path, handler);
        }

    }

}