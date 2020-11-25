package com.example.handyman.controller;

import com.example.handyman.controller.dto.HandymanDTO;
import com.example.handyman.controller.transformer.HandymanTransformer;
import com.example.handyman.entity.HandymanEntity;
import com.example.handyman.service.HandymanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/handyman")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HandymanController {

    private HandymanService handymanService;
    private HandymanTransformer handymanTransformer;

    @GetMapping("/")
    public List<HandymanDTO> getHandymanList() {
        return handymanTransformer.createDTOList(handymanService.getAllHandyman());
    }
}
