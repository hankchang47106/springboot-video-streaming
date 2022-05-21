package edu.tnu.dgd.streamdemo.controller;

/**
 * @author Hank
 * @created 2022-05-21 17:11
 */
import edu.tnu.dgd.streamdemo.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("video")
@AllArgsConstructor
public class VideoController {
    private VideoService videoService;

    // Each parameter annotated with @RequestParam corresponds to a form field where the String argument is the name of the field
    @PostMapping()
    public ResponseEntity<String> saveVideo(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name) throws IOException
    {
        videoService.saveVideo(file, name);
        return ResponseEntity.ok("Video saved successfully.");
    }

    // {name} is a path variable in the url. It is extracted as the String parameter annotated with @PathVariable
    // 注意：若沒有加 produces = "video/mp4"，無法正常撥放影片
    // HTTP Code: 206
    //
    @GetMapping(value="{name}", produces = "video/mp4")
    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name){
        return ResponseEntity
                .ok(new ByteArrayResource(videoService.getVideo(name).getData()));
    }

    @GetMapping("all")
    public ResponseEntity<List<String>> getAllVideoNames(){
        return ResponseEntity
                .ok(videoService.getAllVideoNames());
    }
}