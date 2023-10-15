package com.awakevwake.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User_Session_History")
public class UserSession {
    @Id
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "REQUEST_URL")
    private String requestUrl;
    @Column(name = "REQUEST_HEADERS")
    private Map<String,String> requestHeaders;
    @Column(name = "METHOD_TYPE")
    private String methodType;
    @Column(name = "RESPONSE")
    private String response;
    @Column(name = "RESPONSE_HEADERS")
    private Map<String,String> responseheaders;
    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;
}
