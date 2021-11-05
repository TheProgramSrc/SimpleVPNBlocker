package xyz.theprogramsrc.simplevpnblocker.utils;

import static xyz.theprogramsrc.simplevpnblocker.objects.VpnStatus.FOUND;
import static xyz.theprogramsrc.simplevpnblocker.objects.VpnStatus.NONE;
import static xyz.theprogramsrc.simplevpnblocker.objects.VpnStatus.UNKNOWN;

import java.io.IOException;

import xyz.theprogramsrc.simplevpnblocker.objects.VpnStatus;
import xyz.theprogramsrc.supercoreapi.global.networking.ConnectionBuilder;
import xyz.theprogramsrc.supercoreapi.global.networking.CustomConnection;

public class VpnBlockerApiClient {

    private static final String statusUrl = "http://api-v2.theprogramsrc.xyz/api/superauth/vpnip/status";
    private static final String checkUrl = "http://api-v2.theprogramsrc.xyz/api/superauth/vpnip/check/{ip}";

    public static String fetchStatus(){
        try{
            CustomConnection connection = ConnectionBuilder.connect(statusUrl);
            if(connection.isValidResponse() && connection.isResponseNotNull()){
                return connection.getResponseJson().get("data").getAsJsonObject().get("total").getAsString();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "Unknown";
    }

    public static VpnStatus checkStatus(String ip){
        try{
            CustomConnection connection = ConnectionBuilder.connect(checkUrl.replace("{ip}", ip));
            if(connection.isValidResponse() && connection.isResponseNotNull()){
                return connection.getResponseJson().get("data").getAsJsonObject().get("check").getAsBoolean() ? FOUND : NONE;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return UNKNOWN;
    }
}
