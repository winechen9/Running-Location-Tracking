package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Long> {
    //the first is the entity class name, the second is the index type
    //select * from Locations where runnerMovementType = :movementType
    Page<Location> findByRunnerMovementType(@Param("movementType") Location.RunnerMovementType movementType,
                                            Pageable pageable);
    Page<Location> findByUnitInfoRunningId(@Param("runningId") String runningId, Pageable pageable);
}
