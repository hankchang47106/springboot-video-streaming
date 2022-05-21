package edu.tnu.dgd.streamdemo.repo;

/**
 * @author Hank
 * @created 2022-05-21 17:02
 */
import edu.tnu.dgd.streamdemo.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<Video, Long> {
    Video findByName(String name);

    boolean existsByName(String name);

    @Query(nativeQuery = true, value="SELECT name FROM Video")
    List<String> getAllEntryNames();
}