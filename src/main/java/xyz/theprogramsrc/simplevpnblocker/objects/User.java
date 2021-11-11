package xyz.theprogramsrc.simplevpnblocker.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class User {

    private final UUID uuid;
    public final List<String> ipAddresses;

    public User(UUID uuid, List<String> ipAddresses){
        this.uuid = uuid;
        this.ipAddresses = ipAddresses;
    }

    public User(UUID uuid){
        this(uuid, new LinkedList<>());
    }

    public UUID getUuid() {
        return uuid;
    }
    
    public List<String> getIpAddresses() {
        return ipAddresses;
    }
}
