package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller

@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "! - path parameter";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) { return "Hello, " + name + "!"; }

    @GetMapping("form")
    public String helloForm() {
        return "form";
//        return "<html>" +
//                "<body>" +
//                "<form action = '/hello/hello' method = 'post'>" + // submit a request to /hello
//                "<input type = 'text' name = 'name' >" +
//                "<select name='language'>" +
//                "<option value='1'>English</option>" +
//                "<option value='2'>French</option>" +
//                "<option value='3'>Spanish</option>" +
//                "<option value='4'>German</option>" +
//                "<option value='5'>Italian</option>" +
//                "<input type = 'submit' value = 'Greet Me!' >" +
//                "</form>" +
//                "</body>" +
//                "</html>";
    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello"; //returns "hello" template
    }
//    //fancy solution
//    @RequestMapping(value="hello", method = RequestMethod.POST)
//    @ResponseBody
//    public String myGreeting(@RequestParam String name, @RequestParam String language) {
//        return createMessage(name, language);
//    }

    public static String createMessage(String name, String language) {
        String sayHello = "";
        if (language.equals("1")) {
            sayHello = "Hello";
        } else if (language.equals("2")) {
            sayHello = "Bonjour";
        } else if (language.equals("3")) {
            sayHello = "Hola";
        } else if (language.equals("4")) {
            sayHello = "Hallo";
        } else if (language.equals("5")) {
            sayHello = "Ciao";
        }
        return sayHello + " " + name + "!";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Launchcode");
        names.add("Java");
        names.add("JavaScript");

        model.addAttribute("names", names);
        return "hello-list";
    }

}
