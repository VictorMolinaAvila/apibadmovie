package application.Repositories;

import application.Entities.StudioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends CrudRepository<StudioEntity, Long> {

    @Query("select s from StudioEntity s where s.name = ?1")
    StudioEntity findByName(String name);
}
