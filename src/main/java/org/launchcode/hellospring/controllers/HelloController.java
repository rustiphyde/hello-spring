package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/Rusty
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // Displays the form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

}
