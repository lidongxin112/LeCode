package com.ObServer;

public class test {
    public static void main(String[] args) {
        Watched girl = new ConcreateWatched();
        Watcher watcher1 = new ConcreateWatcher();
        Watcher watcher2 = new ConcreateWatcher();
        Watcher watcher3 = new ConcreateWatcher();
        girl.addWatcher(watcher1);
        girl.addWatcher(watcher2);
        girl.addWatcher(watcher3);

        girl.notifyWatchers("开心");
    }
}
