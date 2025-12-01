package controller;

import myframework.annotation.MyMapping;
import myframework.fw.ModelView;
import myframework.annotation.GET;
import myframework.annotation.POST;
import myframework.annotation.MyController;
import myframework.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@MyController
public class FormController {

    @POST
    @MyMapping("/form/save")
    public String chercher(Map<String, Object> formData) {

        System.out.println("== Données reçues ==");
        for (String key : formData.keySet()) {
            System.out.println(key + " = " + formData.get(key));
        }

        return "OK";
    }

}
