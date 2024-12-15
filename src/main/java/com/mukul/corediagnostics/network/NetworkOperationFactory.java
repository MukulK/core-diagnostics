package com.mukul.corediagnostics.network;

public class NetworkOperationFactory {
    public static NetworkOperation getOperation(String type) {
        return switch (type.toLowerCase()) {
            case "ping" -> new PingOperation();
            case "nslookup" -> new NSLookupOperation();
            case "traceroute" -> new TracerouteOperation();
            case "tnsping" -> new TNSPingOperation();
            case "netstat" -> new NetstatOperation();
            default -> throw new IllegalArgumentException("Invalid operation type");
        };
    }
}