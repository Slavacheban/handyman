package com.example.handyman.controller;

import com.example.handyman.controller.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@RestController
@CrossOrigin
public class AuthController {

    @PostMapping("/login")
    public boolean getLoginPage(@RequestBody UserDTO userDTO) {
        return true; //todo
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }
}
