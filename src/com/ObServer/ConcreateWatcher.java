package com.ObServer;

public class ConcreateWatcher implements Watcher{
    @Override
    public void update(String str) {
        System.out.println(str);
    }
}
