package controller;

import myframework.annotation.MyMapping;

public class TestController {

    @MyMapping(url = "/bonjour")
    public void direBonjour() {
        System.out.println("Bonjour depuis TestController !");
    }

    @MyMapping(url = "/aurevoir")
    public void direAurevoir() {
        System.out.println("Au revoir !");
    }
}
