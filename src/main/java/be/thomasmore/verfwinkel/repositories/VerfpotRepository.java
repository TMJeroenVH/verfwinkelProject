package be.thomasmore.verfwinkel.repositories;

import be.thomasmore.verfwinkel.model.Verfpot;
import org.springframework.data.repository.CrudRepository;

public interface VerfpotRepository extends CrudRepository<Verfpot, Integer> {
    Iterable<Verfpot> findByOndergrond(String ondergrond);
    Iterable<Verfpot> findByPrijsLessThanEqual(double prijs);
    Iterable<Verfpot> findByPrijsGreaterThanEqual(double prijs);
    Iterable<Verfpot> findByPrijsIsBetween(double min, double max);
}
