package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

    @GetMapping("/hello")
    public User hello(@RequestParam String name, @RequestParam int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    //Post
//    @PostMapping("/user/{userId}/name/{userName}")
//    public User post(@RequestBody User user,
//                     @PathVariable int userId,
//                     @PathVariable String userName){
//        log.info("userId : {}, userName : {}", userId, userName);
//        log.info("client req : {}", user); // user의 toString이 {}에 들어감
//        return user;
//    }

    // exchange
//    @PostMapping("/user/{userId}/name/{userName}")
//    public User post(@RequestBody User user,
//                     @PathVariable int userId,
//                     @PathVariable String userName,
//                     @RequestHeader("x-authorization") String authorization,
//                     @RequestHeader("custom-header") String customHeader ){
//        log.info("userId : {}, userName : {}", userId, userName);
//        log.info("authorization : {}, custom : {}", authorization, customHeader);
//        log.info("client req : {}", user); // user의 toString이 {}에 들어감
//        return user;
//    }


    // generic exchange

    @PostMapping("/user/{userId}/name/{userName}")
    public Req<User> post(
                          //HttpEntity<String> entity,
                          @RequestBody Req<User> user,
                          @PathVariable int userId,
                          @PathVariable String userName,
                          @RequestHeader("x-authorization") String authorization,
                          @RequestHeader("custom-header") String customHeader ){
        //log.info("req : {}", entity.getBody());
        log.info("userId : {}, userName : {}", userId, userName);
        log.info("authorization : {}, custom : {}", authorization, customHeader);
        log.info("client req : {}", user); // user의 toString이 {}에 들어감

        Req<User> response = new Req<>();
        response.setHeader(
                new Req.Header()
        );
        response.setResBody(
                user.getResBody()
//                null
        );

        return response;
    }

}

