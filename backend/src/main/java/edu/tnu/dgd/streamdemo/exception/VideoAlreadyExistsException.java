package edu.tnu.dgd.streamdemo.exception;

/**
 * @author Hank
 * @created 2022-05-21 17:08
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "A video with this name already exists")
public class VideoAlreadyExistsException extends RuntimeException {

}