package codegym.service.impl;

import codegym.entity.Song;
import codegym.repository.SongRepository;
import codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public void create(Song song) {
        songRepository.create(song);
    }

    @Override
    public void update(Song song) {
        songRepository.update(song);
    }

    @Override
    public void delete(int id) {
        songRepository.delete(id);
    }

    @Override
    public List<Song> getList() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public List<Song> findByName(String name) {
        List<Song> songs = songRepository.findAll();
        List<Song> result = new ArrayList<>();
        songs.forEach(s-> {
            if(s.getName().equals(name)) {
                result.add(s);
            }
        });
        return result;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}
