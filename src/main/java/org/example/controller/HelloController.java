package org.example.controller;

import org.example.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // UC1 - GET /hello
    @GetMapping
    public String hello() {
        return "Hello from BridgeLabz";
    }

    // UC2 - GET /hello/query?name=Mark
    @GetMapping("/query")
    public String helloQuery(@RequestParam String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC3 - GET /hello/param/Mark
    @GetMapping("/param/{name}")
    public String helloPath(@PathVariable String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // UC4 - POST /hello/post  {"firstName":"Mark","lastName":"Taylor"}
    @PostMapping("/post")
    public String helloPost(@RequestBody UserDTO user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " from BridgeLabz";
    }

    // UC5 - PUT /hello/put/Mark?lastName=Taylor
    @PutMapping("/put/{firstName}")
    public String helloPut(@PathVariable String firstName, @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}
