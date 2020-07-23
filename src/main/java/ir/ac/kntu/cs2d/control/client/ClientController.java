package ir.ac.kntu.cs2d.control.client;

import ir.ac.kntu.cs2d.model.GameSide;
import ir.ac.kntu.cs2d.model.Gamer;
import ir.ac.kntu.cs2d.model.network.PacketCoder;
import ir.ac.kntu.cs2d.model.network.PacketFactory;
import ir.ac.kntu.cs2d.model.network.client.ClientMain;

import java.io.IOException;

public class ClientController {
    Gamer gamer;
    ClientMain clientMain;

    public ClientController() {
        gamer = new Gamer(0);
        try {
            clientMain = new ClientMain(this);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void AgentReq(GameSide gameSide) {
        getClientMain().sendPacket(PacketFactory.Packet.addAgentReq(gameSide, getGamer()));
        System.out.println("request sended");
    }

    public void decode(PacketCoder packetCoder){
        switch (packetCoder.getProtocol()) {
            case ADD_AGENT_ACCEPTED:
                getGamer().setAgent(((Gamer) packetCoder.getObj()[0]).getAgent());
        }
    }

    private Gamer getGamer() {
        return gamer;
    }

    private ClientMain getClientMain() {
        return clientMain;
    }
}
