package com.awakevwake.repo;

import com.awakevwake.model.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserSessionHistoryRepo extends JpaRepository<UserSession,String> {
    List<UserSession> findAllByUserId(@Param("userId") String userId);
}
