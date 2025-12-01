package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.annotation.GET;
import myframework.annotation.POST;
import myframework.annotation.MyController;
import myframework.annotation.RequestParam;

import java.util.List;

@MyController
public class HomeController {

    @MyMapping("/form")
    public ModelView toForm() {
        ModelView mv = new ModelView();
        mv.addAttribute("message", "Teste du Sprint 8 !");
        mv.setView("pages/form.jsp");
        return mv;
    }

    @MyMapping("/hello")
    public ModelView toHello() {
        ModelView mv = new ModelView();
        mv.addAttribute("message", "Finalisation du Sprint 5 framework Java ");
        mv.addAttribute("nombre", 42);
        mv.addAttribute("produits", List.of("PC", "Souris", "Clavier"));
        mv.setView("hello.jsp");
        return mv;
    }
}
