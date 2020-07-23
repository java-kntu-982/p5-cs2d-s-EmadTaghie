package ir.ac.kntu.cs2d.model.network;

import ir.ac.kntu.cs2d.model.GameSide;
import ir.ac.kntu.cs2d.model.Gamer;

import java.io.Serializable;

public class PacketFactory {
    public static class Packet {
        public static PacketCoder addAgentAccepted(Gamer gamer){
            return new PacketCoder(Protocol.ADD_AGENT_ACCEPTED, gamer);
        }

        public static PacketCoder addAgentReq(GameSide gameSide, Gamer gamer){
            return new PacketCoder(Protocol.ADD_AGENT_REQ, new Serializable[]{gameSide, gamer});
        }

        public static PacketCoder deleteAgent(Gamer gamer){
            return new PacketCoder(Protocol.DELETE_AGENT, gamer);
        }
    }
}
