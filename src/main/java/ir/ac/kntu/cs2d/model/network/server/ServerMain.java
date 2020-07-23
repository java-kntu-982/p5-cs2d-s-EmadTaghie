package ir.ac.kntu.cs2d.model.network.server;

import ir.ac.kntu.cs2d.control.sever.ServerController;
import ir.ac.kntu.cs2d.model.armory.gun.Gun;
import ir.ac.kntu.cs2d.model.network.PacketCoder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        ServerMain serverMain = new ServerMain();
        serverMain.run();
    }

    ServerSocket serverSocket;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    Socket socket;
    ServerController serverController;

    public ServerMain() throws IOException {
        setServerSocket(new ServerSocket(12000));
        serverController = new ServerController(this);
    }

    public void run() {
        new Thread() {
            @Override
            public void run() {
                try {
                    while(true){
                        serverOp();
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void serverOp() throws IOException, ClassNotFoundException, InterruptedException {
        setSocket(getServerSocket().accept());
        setObjectInputStream(getSocket().getInputStream());
        setObjectOutputStream(getSocket().getOutputStream());
        try {
            while (true) {
                System.out.println("request received");
                serverController.decoder((PacketCoder) getObjectInputStream().readObject());
            }
        } catch (SocketException e) {

        } finally {
            Thread.sleep(50);
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(InputStream inputStream) throws IOException{
        this.objectInputStream = new ObjectInputStream(inputStream);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(OutputStream outputStream) throws IOException{
        this.objectOutputStream = new ObjectOutputStream(outputStream);
    }

    public void sendPacket(PacketCoder packetCoder){
        try {
            getObjectOutputStream().writeObject(packetCoder);
            System.out.println("sended");
            getObjectOutputStream().flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ServerController getServerController() {
        return serverController;
    }
}
