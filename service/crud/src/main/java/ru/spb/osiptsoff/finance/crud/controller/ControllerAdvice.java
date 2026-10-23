package ru.spb.osiptsoff.finance.crud.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ru.spb.osiptsoff.finance.lib.exception.CrudException;

@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler({ CrudException.class })
    public ResponseEntity<Map<String, Object>> handle(CrudException e) {
        LOG.error("Bad request", e);
        return getEntity(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Map<String, Object>> handle(Exception e) {
        LOG.error("Unhandled error", e);
        return getEntity(HttpStatus.INTERNAL_SERVER_ERROR, "Service error");
    }
    
    private ResponseEntity<Map<String, Object>> getEntity(HttpStatus status, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", status.value());
        result.put("error", status.getReasonPhrase());
        result.put("message", message);

        return new ResponseEntity<>(result, status);
    }
}
