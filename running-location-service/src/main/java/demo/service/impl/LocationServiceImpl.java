package demo.service.impl;

import java.util.List;

import demo.domain.Location;
import demo.domain.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import demo.service.LocationService;

public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> saveRunningLocations(List<Location> runningLocations){
        return locationRepository.save(runningLocations);
    }
    @Override
    public void deleteAll(){
        locationRepository.deleteAll();
    }
    @Override
    public Page<Location> findByRunnerMovementType(String movementType, Pageable pageable){
        return locationRepository.findByRunnerMovementType(Location.RunnerMovementType.valueOf(movementType),
                pageable);
    }

    @Override
    public Page<Location> findByRunningId(String runningId, Pageable pageable){
        return locationRepository.findByUnitInfoRunningId(runningId, pageable);
    }
}
