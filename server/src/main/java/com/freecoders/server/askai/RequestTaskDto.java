package com.freecoders.server.askai;

import lombok.Data;

@Data
public class RequestTaskDto {
    Long id;
    String question;
    String myAnswer;
}
