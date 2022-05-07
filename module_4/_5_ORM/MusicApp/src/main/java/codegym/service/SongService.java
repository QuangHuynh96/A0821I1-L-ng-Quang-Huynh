package codegym.service;

import codegym.entity.Song;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SongService {
    void create(Song song);
    void update(Song song);
    void delete(int id);
    List<Song> getList();
    Song findById(int id);
    List<Song> findByName(String name);
    List<Song> findAll();
}
