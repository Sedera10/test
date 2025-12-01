package app;

import java.lang.reflect.Method;
import controller.TestController;
import myframework.annotation.MyMapping;

public class Main {
    public static void main(String[] args) {
        // On parcourt toutes les méthodes de la classe
        for (Method method : TestController.class.getDeclaredMethods()) {
            // Si la méthode a l'annotation UrlMapping
            if (method.isAnnotationPresent(MyMapping.class)) {
                // On récupère la valeur de l'URL
                MyMapping mapping = method.getAnnotation(MyMapping.class);
                System.out.println("Méthode : " + method.getName() + " | URL = " + mapping.value());
            }
        }
    }
}