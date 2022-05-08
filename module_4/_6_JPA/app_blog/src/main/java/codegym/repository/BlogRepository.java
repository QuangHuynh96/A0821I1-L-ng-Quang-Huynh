package codegym.repository;

import codegym.entity.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer> {
    List<Blog> findAllByName(String name);
    List<Blog> findAllByNameContaining(String name);
    List<Blog> findAllByNameContainingAndAuthorContaining(String name, String author);

    @Query(value = "select * from Blog where price between ?1 and ?2", nativeQuery = true)
    List<Blog> findAllByPriceByNativeQuery(long price1, long price2);

    @Query(value = "select b from Blog b where b.price >= ?1 and b.price <= ?2")
    List<Blog> findAllByPriceByHQL(long price1, long price2);
}
