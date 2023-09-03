package app.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/member")
public class MemberRestController {

    @GetMapping
    public ResponseEntity<String> firstGetMethod(){
        return ResponseEntity.ok("hello from get!");
    }


    @PostMapping
    public ResponseEntity<String> firstPostMethod() {
        return ResponseEntity.ok("hello from post");
    }


}
