package com.mukul.corediagnostics.network;

import com.mukul.corediagnostics.network.models.NetworkResult;

public interface NetworkOperation {

    NetworkResult execute(String target) throws Exception;
}