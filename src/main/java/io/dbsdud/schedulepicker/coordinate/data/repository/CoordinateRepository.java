package io.dbsdud.schedulepicker.coordinate.data.repository;

import io.dbsdud.schedulepicker.coordinate.data.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
