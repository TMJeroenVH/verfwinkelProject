package be.thomasmore.verfwinkel.repositories;

import be.thomasmore.verfwinkel.model.Klant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KlantenRepository extends CrudRepository<Klant, Integer> {
    Optional<Klant> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Klant> findFirstByIdGreaterThanOrderById(int id);
    Optional<Klant> findFirstByOrderByIdDesc();
    Optional<Klant> findFirstByOrderByIdAsc();

    @Query("SELECT DISTINCT a FROM Klant a JOIN a.user u WHERE u.username = ?1")
    Optional<Klant> findByUsername(String name);
}
