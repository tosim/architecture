package com.tosim.learn.architecture;

/**
 * @author yaoyicheng
 * @data 2018/11/20 10:50
 */
public class VolatileApp {

    private ThreadLocal<String> tName = new ThreadLocal<>();

    public String gettName() {
        return tName.get();
    }

    public void settName(String tName) {
        this.tName.set(tName);
    }
}
