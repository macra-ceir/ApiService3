/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.exceptions.controllers;

import com.gl.ceir.config.dto.ApiResponse;
import com.gl.ceir.config.dto.ExceptionResponse;
import com.gl.ceir.config.dto.Result;
import com.gl.ceir.config.exceptions.*;
import com.gl.ceir.config.service.impl.CheckImeiServiceImpl;

import java.util.Scanner;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

//@EnableWebMvc   //to be remove FOR SWAGGER
@ControllerAdvice
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalControllerExceptionHandler.class);

    @Autowired
    HttpServletRequest req;

    @Autowired
    CheckImeiServiceImpl checkImeiServiceImpl;

    /* Global System Exceptions*/
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNoHandlerFound(NoHandlerFoundException e, WebRequest request) {
        logger.error("Error msg :" + e.getLocalizedMessage() + " # request " + request.toString());
        try {
            logger.error("Error ############ : " + req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (Exception exp) {
            logger.error("Error msgs :" + exp.toString());

        }
        return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "not found", "en", new Result(checkImeiServiceImpl.globalErrorMsgs("en")));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ExceptionResponse handleMethodNotAllowed(HttpRequestMethodNotSupportedException e, WebRequest request) {
        logger.error("Error msg :" + e.getLocalizedMessage() + " # request " + request.toString());
        try {
            Scanner s = new Scanner(req.getInputStream(), "UTF-8").useDelimiter("\\A");
            String st = s.hasNext() ? s.next() : "";
            logger.error("Error ############ : " + req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (Exception exp) {
            logger.error("Error msgs :" + exp.toString());

        }
        return new ExceptionResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), "method not allowed", "en", new Result(checkImeiServiceImpl.globalErrorMsgs("en")));
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)// other than json
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ExceptionResponse handleHttpMediaTypeNotSupported(Exception e, WebRequest request) {
        logger.error("Error msg :" + e.getLocalizedMessage() + " # request " + request.toString());
        try {
            logger.error("Error ############ : " + req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (Exception exp) {
            logger.error("Error msgs :" + exp.toString());

        }
        return new ExceptionResponse(HttpStatus.NOT_ACCEPTABLE.value(), "not acceptable", "en", new Result(checkImeiServiceImpl.globalErrorMsgs("en")));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleBadRequestException(Exception e, WebRequest request) {
        logger.error("Error msg :" + e.getLocalizedMessage() + " # request " + request.toString());
        try {
            logger.error("Error ############ : " + req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (Exception exp) {
            logger.error("Error msgs :" + exp.toString());
        }
        return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "internal server error", "en ", new Result(checkImeiServiceImpl.globalErrorMsgs("en")));
    }

    @ExceptionHandler(IllegalArgumentException.class)  // spec chars
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleIllegalRequestException(Exception e, WebRequest request) {
        logger.error("Error msg :" + e.getLocalizedMessage() + " # request " + request.toString());
        try {
            logger.error("Error ############ : " + req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (Exception exp) {
            logger.error("Error msgs :" + exp.toString());

        }
        return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "bad request", " request is not valid ", new Result(checkImeiServiceImpl.globalErrorMsgs("en")));
    }

    @ExceptionHandler(InternalServerError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleInternalServerException(Exception e, WebRequest request) {
        logger.error("Error msg :" + e.getLocalizedMessage() + " # request " + request.toString());
        try {
            logger.error("Error ############ : " + req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (Exception exp) {
            logger.error("Error msgs :" + exp.toString());

        }
        return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "server error", "en", new Result(checkImeiServiceImpl.globalErrorMsgs("en")));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMissingServletRequestParameterException(Exception e, WebRequest request) {
        logger.error("Error msg :" + e.getLocalizedMessage() + " # request " + request.toString());
        try {
            logger.error("Error ############ : " + req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (Exception exp) {
            logger.error("Error msgs :" + exp.toString());
        }
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "bad request", "en", new Result(checkImeiServiceImpl.globalErrorMsgs("en")));
    }

    /* Custom Exceptions */
    /* Custom Exceptions */
    /* Custom Exceptions */
    /* Custom Exceptions */
    /* Custom Exceptions */
    /* Custom Exceptions */

    /* Custom Exceptions */
    @ExceptionHandler(value = UnAuthorizationException.class)
    public ResponseEntity<Object> exception(UnAuthorizationException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        HttpStatus.UNAUTHORIZED.value(), "unauthorized", exception.getResourceName(), new Result(exception.getMessage())),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = MissingRequestParameterException.class)
    public ResponseEntity<Object> exception(MissingRequestParameterException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        HttpStatus.BAD_REQUEST.value(), "bad request", exception.getResourceName(), new Result(exception.getMessage())),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ServiceUnavailableException.class)
    public ResponseEntity<Object> exception(ServiceUnavailableException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        HttpStatus.SERVICE_UNAVAILABLE.value(), HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase(), exception.getResourceName(), new Result(exception.getMessage())),
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = InternalServicesException.class)
    public ResponseEntity<Object> exception(InternalServicesException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(), " server error", exception.getResourceName(), new Result(exception.getMessage())),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = PayloadSizeExceeds.class)
    public ResponseEntity<Object> exception(PayloadSizeExceeds exception) {
        return new ResponseEntity<>(new ExceptionResponse(
                HttpStatus.PAYLOAD_TOO_LARGE.value(),
                HttpStatus.PAYLOAD_TOO_LARGE.getReasonPhrase(),
                exception.getResourceName(), new Result(exception.getMessage())),
                HttpStatus.PAYLOAD_TOO_LARGE);
    }

    @ExceptionHandler(value = UnprocessableEntityException.class)
    public ResponseEntity<Object> exception(UnprocessableEntityException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(
                        HttpStatus.UNPROCESSABLE_ENTITY.value(), "unprocessable entity", exception.getResourceName(), new Result(exception.getMessage())),
                HttpStatus.UNPROCESSABLE_ENTITY);

    }


    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
        return new ResponseEntity<>(
                new ExceptionResponse(HttpStatus.NOT_FOUND.value(), "not found", exception.getResourceName(), new Result(exception.getMessage())),
                HttpStatus.NOT_FOUND);
    }

    /* Custom Exceptions .Not used Currently*/
    @ExceptionHandler(value = MyFileNotFoundException.class)
    public ResponseEntity<Object> exception(MyFileNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "FAIL", exception.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = FileStorageException.class)
    public ResponseEntity<Object> exception(FileStorageException exception) {
        return new ResponseEntity<>(new ApiResponse(HttpStatus.NOT_FOUND.value(), "FAIL", exception.getMessage()),
                HttpStatus.NOT_FOUND);
    }

}

//    JSONObject jsonObject = new JSONObject(jsonString) {
//    /**
//     * changes the value of JSONObject.map to a LinkedHashMap in order to maintain
//     * order of keys.
//     */
//    @Override
//    public JSONObject put(String key, Object value) throws JSONException {
//        try {
//            Field map = JSONObject.class.getDeclaredField("map");
//            map.setAccessible(true);
//            Object mapValue = map.get(this);
//            if (!(mapValue instanceof LinkedHashMap)) {
//                map.set(this, new LinkedHashMap<>());
//            }
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//        return super.put(key, value);
//    }
//};
