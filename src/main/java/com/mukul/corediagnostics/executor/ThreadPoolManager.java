package com.mukul.corediagnostics.executor;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;

public class ThreadPoolManager {

    private static ThreadPoolManager instance;

    private ThreadPoolManager() {}

    public static ThreadPoolManager getInstance() {
        if (instance == null) {
            synchronized (ThreadPoolManager.class) {
                if (instance == null) {
                    instance = new ThreadPoolManager();
                }
            }
        }
        return instance;
    }

    public void resetThreadPoolByName(String name) {
        ExecutorService executor = findExecutorByName(name);
        if (executor != null) {
            executor.shutdownNow();
            System.out.println("Thread pool with name '" + name + "' has been reset.");
        } else {
            System.out.println("No thread pool found with name: " + name);
        }
    }

    public void resetThreadPoolById(String id) {
        ExecutorService executor = findExecutorById(id);
        if (executor != null) {
            executor.shutdownNow();
            System.out.println("Thread pool with ID '" + id + "' has been reset.");
        } else {
            System.out.println("No thread pool found with ID: " + id);
        }
    }

    private ExecutorService findExecutorByName(String name) {
        // Use reflection to search for thread pools by name in all loaded classes
        try {
            for (Field field : getAllFields()) {
                if (field.getName().equals(name) && ExecutorService.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    return (ExecutorService) field.get(null);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ExecutorService findExecutorById(String id) {
        // Use reflection to search for thread pools by ID in all loaded classes
        try {
            for (Field field : getAllFields()) {
                if (ExecutorService.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    ExecutorService executor = (ExecutorService) field.get(null);
                    if (executor != null && String.valueOf(executor.hashCode()).equals(id)) {
                        return executor;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Field[] getAllFields() {
        try {
            // Iterate over all loaded classes and gather fields
            return ClassLoader.getSystemClassLoader().loadClass(Thread.currentThread().getStackTrace()[1].getClassName()).getDeclaredFields();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new Field[0];
        }
    }
}