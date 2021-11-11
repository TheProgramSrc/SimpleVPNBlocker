package xyz.theprogramsrc.simplevpnblocker.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class IPAddress {

    private final String ip;
    private final boolean isVpn;
    private final boolean isWhitelisted;
    private final List<UUID> users;
    private final int maxAccounts;

    public IPAddress(String ip, boolean isVpn, boolean isWhitelisted, List<UUID> users, int maxAccounts) {
        this.ip = ip;
        this.isVpn = isVpn;
        this.isWhitelisted = isWhitelisted;
        this.users = users;
        this.maxAccounts = maxAccounts;
    }

    public IPAddress(String ip, boolean isVpn, boolean isWhitelisted, List<UUID> users) {
        this(ip, isVpn, isWhitelisted, users, 0);
    }

    public IPAddress(String ip, boolean isVpn, boolean isWhitelisted) {
        this(ip, isVpn, isWhitelisted, new LinkedList<>());
    }

    public IPAddress(String ip, boolean isVpn) {
        this(ip, isVpn, false);
    }

    public String getIp() {
        return ip;
    }

    public boolean isVpn() {
        return isVpn;
    }

    public boolean isWhitelisted() {
        return isWhitelisted;
    }

    public List<UUID> getUsers() {
        return users;
    }

    public int getMaxAccounts() {
        return maxAccounts;
    }
    
}
