package com.mukul.corediagnostics.diagnostics;

public class ThreadDiagnostics {
    public Thread[] fetchAllThreads() {
        return Thread.getAllStackTraces().keySet().toArray(new Thread[0]);
    }

//    public boolean findMatchingMethodInThreadStack(Thread thread, String methodName) {
//        return thread.getStackTrace().stream()
//                .anyMatch(stackTraceElement -> stackTraceElement.getMethodName().equals(methodName));
//    }
}