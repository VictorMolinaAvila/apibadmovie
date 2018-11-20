package application.Repositories;

import application.Entities.ProducerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<ProducerEntity, Long> {

    @Query("select s from ProducerEntity s where s.name = ?1")
    ProducerEntity findByName(String name);
}
