package komputer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Phone implements Closeable {
    public void close() throws IOException {
    }
    private final Socket socket;
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Phone(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            this.reader = creatReader();
            this.writer = creatWriter();
        } catch ((IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Phone(ServerSocket server) {
        try {
            this.socket = server.accept();
            this.reader = creatReader();
            this.writer = creatWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeLine(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}