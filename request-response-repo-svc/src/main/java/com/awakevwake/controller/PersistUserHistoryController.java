package com.awakevwake.controller;

import com.awakevwake.model.GenericResponseDto;
import com.awakevwake.model.UserSession;
import com.awakevwake.service.UserSessionService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersistUserHistoryController {

    @Autowired
    private UserSessionService userSessionService;

    @GetMapping("/getUserHistory/{userId}")
    public ResponseEntity<GenericResponseDto> getUserSessionHistory(@RequestParam("userId") String userId){
        GenericResponseDto getResultsFromDb=userSessionService.getAllUserHistory(userId);
        return new ResponseEntity<>(getResultsFromDb,HttpStatus.OK);
    }

    @PostMapping("/persistHistory")
    public ResponseEntity<String> saveHistory(@RequestBody UserSession userSession){
        userSessionService.saveUserRequestDetails(userSession);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
