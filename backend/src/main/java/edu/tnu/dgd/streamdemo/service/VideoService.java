package edu.tnu.dgd.streamdemo.service;

/**
 * @author Hank
 * @created 2022-05-21 17:03
 */
import edu.tnu.dgd.streamdemo.entity.Video;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(String name);

    void saveVideo(MultipartFile file, String name) throws IOException;

    List<String> getAllVideoNames();
}