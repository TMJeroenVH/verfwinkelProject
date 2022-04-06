package be.thomasmore.verfwinkel.repositories;

import be.thomasmore.verfwinkel.model.Verfpot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VerfpotRepository extends CrudRepository<Verfpot, Integer> {
    Iterable<Verfpot> findByPrijsLessThanEqual(Double prijs);

    Iterable<Verfpot> findByPrijsGreaterThanEqual(Double prijs);

    @Query("SELECT v FROM Verfpot v WHERE (:min IS NULL OR v.prijs >= :min) " +
            "AND (:max IS NULL OR v.prijs <= :max)" +
            "AND (:word IS NULL OR LOWER(v.naam) LIKE LOWER(CONCAT('%',:word,'%')))" +
            "AND (:ondergrond IS NULL OR LOWER (v.ondergrond) LIKE LOWER(CONCAT('%',:ondergrond,'%')))")
    List<Verfpot> findByPrijsNaam(@Param("min") Double min,
                                  @Param("max") Double max,
                                  @Param("word") String word,
                                  @Param("ondergrond") String ondergrond);
}
