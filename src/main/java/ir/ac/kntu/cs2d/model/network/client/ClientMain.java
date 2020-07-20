package ir.ac.kntu.cs2d.model.network.client;

import java.io.*;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        ClientMain clientMain = new ClientMain();
        clientMain.getDataOutputStream().write(25);
    }

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private ClientMain() throws IOException {
        setSocket(new Socket("localHost", 12000));
        setDataOutputStream(getSocket().getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public void setDataOutputStream(OutputStream dataOutputStream) {
        this.dataOutputStream = new DataOutputStream(dataOutputStream);
    }
}
