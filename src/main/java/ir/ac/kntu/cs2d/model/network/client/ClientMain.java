package ir.ac.kntu.cs2d.model.network.client;

import ir.ac.kntu.cs2d.control.client.ClientController;
import ir.ac.kntu.cs2d.model.armory.gun.Gun;
import ir.ac.kntu.cs2d.model.armory.gun.mainWeapon.MainWeaponFactory;
import ir.ac.kntu.cs2d.model.armory.gun.pistol.PistolFactory;
import ir.ac.kntu.cs2d.model.network.PacketCoder;

import java.io.*;
import java.net.Socket;

public class ClientMain {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private ClientController clientController;

    public ClientMain(ClientController clientController) throws IOException {
        setSocket(new Socket("localHost", 12000));
        setObjectOutputStream(getSocket().getOutputStream());
        setObjectInputStream(getSocket().getInputStream());
        setClientController(clientController);
        read();
    }

    public Socket getSocket() {
        return socket;
    }

    public void read(){
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        while (true) {
                            System.out.println("in here");
                            clientController.decode((PacketCoder) getObjectInputStream().readObject());
                            System.out.println("req accepted");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    private void setObjectOutputStream(OutputStream objectOutputStream) throws IOException {
        this.objectOutputStream = new ObjectOutputStream(objectOutputStream);
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(InputStream inputStream) throws IOException{
        this.objectInputStream = new ObjectInputStream(inputStream);
    }

    public void sendPacket(PacketCoder packetCoder){
        try {
            getObjectOutputStream().writeObject(packetCoder);
            getObjectOutputStream().flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ClientController getClientController() {
        return clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }
}
