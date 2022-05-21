package edu.tnu.dgd.streamdemo.exception;

/**
 * @author Hank
 * @created 2022-05-21 17:09
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "A video with that id was not found")
public class VideoNotFoundException extends RuntimeException{


}