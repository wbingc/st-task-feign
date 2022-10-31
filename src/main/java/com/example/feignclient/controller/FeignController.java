package com.example.feignclient.controller;

import com.example.feignclient.clients.LoginClient;
import com.example.feignclient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private LoginClient loginClient;

    @PostMapping(value = "${feign.url.login}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody User user) {
        return loginClient.login(user);
    }

    @PostMapping(value = "${feign.url.fl}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fakelogin(@RequestBody User user) {
        return loginClient.fakelogin(user);
    }

    @PostMapping(value = "${feign.url.signup}",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signup(@RequestBody User user) {
        return loginClient.signup(user);
    }

    @PostMapping("${feign.url.hello}")
    public ResponseEntity<String> hello() {
        return loginClient.hello();
    }

    @GetMapping("${feign.url.la}")
    public ResponseEntity<List<User>> listAll() {
        return loginClient.listAll();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("Service is up and running.");
    }
}
