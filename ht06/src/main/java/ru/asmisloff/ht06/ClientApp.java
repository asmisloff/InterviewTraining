package ru.asmisloff.ht06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientApp {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8080)) {
            try (PrintWriter writer = new PrintWriter(socket.getOutputStream())) {

                // create GET request
                writer.print("GET /?param=13 HTTP/1.1\r\n");
                writer.print("Host: localhost:8080\r\n");
                writer.print("\r\n");
                writer.flush();

                String outStr;

                try (var bufRead = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()))) {

                    while ((outStr = bufRead.readLine()) != null) {
                        System.out.println(outStr);
                    }

                }
            }
        }
    }

}
