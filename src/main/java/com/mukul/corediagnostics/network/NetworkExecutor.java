package com.mukul.corediagnostics.network;
import com.mukul.corediagnostics.network.models.NetworkResult;

import java.util.EnumMap;
import java.util.Map;

public class NetworkExecutor {
    private final Map<NetworkCommand, NetworkOperation> operationRegistry;

    public NetworkExecutor() {
        this.operationRegistry = new EnumMap<>(NetworkCommand.class);
        initializeOperations();
    }

    private void initializeOperations() {
        operationRegistry.put(NetworkCommand.PING, new PingOperation());
        operationRegistry.put(NetworkCommand.NSLOOKUP, new NSLookupOperation());
        operationRegistry.put(NetworkCommand.TRACEROUTE, new TracerouteOperation());
        operationRegistry.put(NetworkCommand.TNSPING, new TNSPingOperation());
        operationRegistry.put(NetworkCommand.NETSTAT, new NetstatOperation());
    }

    public NetworkResult execute(NetworkCommand command, String target) {
        NetworkOperation operation = operationRegistry.get(command);
        if (operation == null) {
            throw new UnsupportedOperationException("Operation not supported: " + command);
        }
        try {
            return operation.execute(target);
        } catch (Exception e) {
            return new NetworkResult(
                    command.name(),
                    target,
                    "Execution failed: " + e.getMessage(),
                    -1
            );
        }
    }
}