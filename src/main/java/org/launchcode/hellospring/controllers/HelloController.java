package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    //only accept get method requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // route to /goodbye
    @GetMapping("goodbye")
    //@ResponseBody tells java not to go looking for a template
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handler that handles requests of the form /hello?name=Rustiphyde

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String aGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", aGreeting);
        return "hello";
    }

    // Handles requests of the form /hello/Rusty
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // Displays the form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }



    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Rusty");
        names.add("Rustiphyde");
        names.add("Rustipher");
        names.add("Rustoleum Dynamite");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
