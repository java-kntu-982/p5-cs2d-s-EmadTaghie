package ir.ac.kntu.cs2d.model.network;

import java.io.Serializable;

public class PacketCoder implements Serializable {
    private Protocol protocol;
    private Serializable[] obj;
    public PacketCoder(Protocol protocol, Serializable... obj) {
        this.protocol = protocol;
        this.obj = obj;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public Serializable[] getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "protocol: " + protocol + ", obj: " + obj;
    }
}
