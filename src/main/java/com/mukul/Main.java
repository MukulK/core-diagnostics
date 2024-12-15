package com.mukul;

import com.mukul.corediagnostics.network.NetworkCommand;
import com.mukul.corediagnostics.network.NetworkExecutor;
import com.mukul.corediagnostics.network.models.NetworkResult;

public class Main {
    public static void main(String[] args) {
        NetworkExecutor executor = new NetworkExecutor();

        try {
            // Execute ping
            NetworkResult pingResult = executor.execute(NetworkCommand.PING, "google.com");
            System.out.println(pingResult);

            // Execute nslookup
            NetworkResult nslookupResult = executor.execute(NetworkCommand.NSLOOKUP, "google.com");
            System.out.println(nslookupResult);

            NetworkResult traceOutput = executor.execute(NetworkCommand.TRACEROUTE, "google.com");
            System.out.println(traceOutput);

        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}