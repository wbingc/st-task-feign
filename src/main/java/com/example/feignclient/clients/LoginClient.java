package com.example.feignclient.clients;

import com.example.feignclient.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.attribute.standard.Media;
import java.util.List;

@FeignClient(name="${feign.name}")
public interface LoginClient {

    @PostMapping(value = "${feign.url.login}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> login(@RequestBody User user);

    @PostMapping(value = "${feign.url.signup}",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> signup(@RequestBody User user);

    @PostMapping(value = "${feign.url.fl}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> fakelogin(@RequestBody User user);

    @PostMapping("${feign.url.hello}")
    ResponseEntity<String> hello();

    @GetMapping("${feign.url.la}")
    ResponseEntity<List<User>> listAll();

}
