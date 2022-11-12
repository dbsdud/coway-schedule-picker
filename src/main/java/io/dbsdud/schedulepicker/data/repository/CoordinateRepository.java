package io.dbsdud.schedulepicker.data.repository;

import io.dbsdud.schedulepicker.data.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
