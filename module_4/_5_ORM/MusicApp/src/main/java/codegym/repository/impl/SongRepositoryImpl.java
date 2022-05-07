package codegym.repository.impl;

import codegym.entity.Song;
import codegym.repository.SongRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class SongRepositoryImpl implements SongRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("Select p from Song p").getResultList();
    }

    @Override
    public void create(Song song) {
        entityManager.persist(song);
    }

    @Override
    public void update(Song song) {
        entityManager.merge(song);
    }

    @Override
    public void delete(int id) {
        Song song = findById(id);
        entityManager.remove(song);
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }
}
