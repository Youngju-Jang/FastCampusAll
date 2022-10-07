package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {

    private final int port;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port. ", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");

                // 1. 사용자 요청을 메인 thread가 처리하도록 한다.
                // 2. 사용자 요청이 들어올때마다 thread 를 새로 생성하여 사용자 요청 처리함
                // new Thread(new ClientRequestHandler(clientSocket)).start();

                // 3. thread pool을 적용하여 안정적인 서비스가 가능하도록 한다.
                executorService.execute(new ClientRequestHandler(clientSocket));

                }

            }
        }
}
