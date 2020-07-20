package ir.ac.kntu.cs2d.model.network.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        ServerMain serverMain = new ServerMain();
    }

    ServerSocket serverSocket;
    InputStream inputStream;
    Socket socket;

    private ServerMain() throws IOException {
        setServerSocket(new ServerSocket(12000));
        setSocket(getServerSocket().accept());
        setInputStream(getSocket().getInputStream());
        System.out.println(getInputStream().read());
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
