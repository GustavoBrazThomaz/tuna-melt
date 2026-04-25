package com.study.tunamelt.dto;


import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponseDTO(
        String message,
        Integer status,
        LocalDateTime timeStamp
){

}
