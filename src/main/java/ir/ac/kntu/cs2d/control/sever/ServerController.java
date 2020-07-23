package ir.ac.kntu.cs2d.control.sever;

import ir.ac.kntu.cs2d.model.AgentManager;
import ir.ac.kntu.cs2d.model.GameSide;
import ir.ac.kntu.cs2d.model.Gamer;
import ir.ac.kntu.cs2d.model.network.PacketCoder;
import ir.ac.kntu.cs2d.model.network.PacketFactory;
import ir.ac.kntu.cs2d.model.network.server.ServerMain;
import ir.ac.kntu.cs2d.model.person.Person;
import ir.ac.kntu.cs2d.model.person.PersonFactory;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.HashMap;

public class ServerController {
    private AgentManager agents;
    private Image baseImage;
    private HashMap<Person, Image> views;
    private ServerMain serverMain;

    public ServerController(ServerMain serverMain) {
        agents = new AgentManager();
        this.serverMain = serverMain;
    }

    public void addAgent(Serializable... data) {
        try {
            getAgents().removeAgent(((Gamer)data[1]));
        } catch (NullPointerException e) {
        } finally {
            System.out.println("sed add accepted");
            ((Gamer)data[1]).setAgent(data[0].equals(GameSide.CT) ? PersonFactory.MakePerson.makeCT() :
                    PersonFactory.MakePerson.makeTerror());
            getServer().sendPacket(PacketFactory.Packet.addAgentAccepted((Gamer) data[1]));
        }
    }

    public void decoder(PacketCoder packetCoder){
        switch (packetCoder.getProtocol()) {
            case ADD_AGENT_REQ:
                System.out.println("agent req");
                addAgent(packetCoder.getObj());
                break;
            default:
                break;
        }
    }

    public AgentManager getAgents() {
        return agents;
    }

    public ServerMain getServer() {
        return serverMain;
    }
}
