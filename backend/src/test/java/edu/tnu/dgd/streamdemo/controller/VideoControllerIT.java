package edu.tnu.dgd.streamdemo.controller;

/**
 * @author Hank
 * @created 2022-05-21 17:23
 */
import edu.tnu.dgd.streamdemo.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.Mockito.*;

@SpringBootTest
class VideoControllerIT {

    @Autowired
    VideoController controller;
    @Autowired
    VideoService service;
    MultipartFile file = mock(MultipartFile.class);

    @Test
    void saveVideo(){

    }
}