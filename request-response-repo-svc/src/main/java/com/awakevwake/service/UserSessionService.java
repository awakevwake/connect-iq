package com.awakevwake.service;

import com.awakevwake.model.GenericResponseDto;
import com.awakevwake.model.UserSession;
import com.awakevwake.repo.UserSessionHistoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserSessionService {

    @Autowired
    private UserSessionHistoryRepo userSessionHistoryRepo;

    public GenericResponseDto getAllUserHistory(String userId){
        GenericResponseDto userHistory = new GenericResponseDto();
        userHistory.getGenericResponse().addAll(userSessionHistoryRepo.findAllByUserId(userId));
        return userHistory;
    }

    public String saveUserRequestDetails(UserSession userSession) {
        UserSession persistedData = userSessionHistoryRepo.save(userSession);
        return persistedData !=null ? "Data is Saved" : "Data not saved";
    }
}
