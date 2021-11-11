package xyz.theprogramsrc.simplevpnblocker.managers;

import java.sql.SQLException;
import java.sql.Statement;

import xyz.theprogramsrc.supercoreapi.global.storage.DataBase;
import xyz.theprogramsrc.supercoreapi.global.storage.DataBaseStorage;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;

public class UserManager extends DataBaseStorage {
    
    private final String tableUsers;
    private final String tableIps;

    public UserManager(DataBase dataBase) {
        super(SpigotPlugin.i, dataBase);
        this.tableUsers = this.getTablePrefix() + "users";
        this.tableIps = this.getTablePrefix() + "ips";
        this.initDataBase();
    }

    public void initDataBase(){
        this.dataBase.connect(connection -> {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate(String.format("CREATE TABLE IF NOT EXISTS `%s` (uuid VARCHAR(36), PRIMARY KEY (uuid));", this.tableUsers));
                statement.executeUpdate(String.format("CREATE TABLE IF NOT EXISTS `%s` (ip VARCHAR(255), is_vpn TINYINT, is_whitelisted TINYINT, max_accounts INT, PRIMARY KEY (ip));", this.tableIps));
            }catch(SQLException e){
                e.printStackTrace();
            }
        });
    }
}
