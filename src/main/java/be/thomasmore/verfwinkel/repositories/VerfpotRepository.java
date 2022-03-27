package be.thomasmore.verfwinkel.repositories;

import be.thomasmore.verfwinkel.model.Verfpot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VerfpotRepository extends CrudRepository<Verfpot, Integer> {
    Iterable<Verfpot> findByPrijsLessThanEqual(double prijs);

    Iterable<Verfpot> findByPrijsGreaterThanEqual(double prijs);

    @Query("SELECT v FROM Verfpot v WHERE (:min IS NULL OR v.prijs >= :min) " +
            "AND (:max IS NULL OR v.prijs <= :max)")
    List<Verfpot> findByPrijsIsBetween(@Param("min") double min,
                                       @Param("max") double max);


    @Query("SELECT v FROM Verfpot v WHERE :word IS NULL OR LOWER(v.naam) LIKE LOWER(CONCAT('%',:word,'%')) ")
    List<Verfpot> findByKeyword(@Param("word") String word);

}
