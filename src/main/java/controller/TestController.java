package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.annotation.MyController;

@MyController
public class TestController {

    @MyMapping(url = "/bonjour")
    public void direBonjour() {
        System.out.println("Bonjour depuis TestController !");
    }

    @MyMapping(url = "/aurevoir")
    public void direAurevoir() {
        System.out.println("Au revoir !");
    }

    @MyMapping(url = "/ecrire")
    public String ecrireChose() {
        String message = "Voici une chose écrite par TestController. (Vita sprint 4)";
        return message;
    }
    @MyMapping(url = "/hello")
    public ModelView ouverturePage() {
        ModelView mv = new ModelView();
        mv.setView("hello.jsp");
        return mv;
    }
}
