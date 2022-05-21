package edu.tnu.dgd.streamdemo.service.impl;

/**
 * @author Hank
 * @created 2022-05-21 17:07
 */

import edu.tnu.dgd.streamdemo.entity.Video;
import edu.tnu.dgd.streamdemo.exception.VideoAlreadyExistsException;
import edu.tnu.dgd.streamdemo.exception.VideoNotFoundException;
import edu.tnu.dgd.streamdemo.repo.VideoRepo;
import edu.tnu.dgd.streamdemo.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService
{
    private VideoRepo repo;

    @Override
    public Video getVideo(String name) {
        if(!repo.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return repo.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repo.getAllEntryNames();
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(repo.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, file.getBytes());
        repo.save(newVid);
    }
}