package codegym.repository;

//import codegym.entity.Song;
//import org.springframework.data.repository.CrudRepository;
import codegym.entity.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SongRepository {
    List<Song> findAll();
    void create (Song song);
    void update(Song song);
    void delete(int id);
    Song findById(int id);
}
