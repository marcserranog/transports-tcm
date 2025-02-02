package com.example.projectegrupalxavineta.persistance;

import com.example.projectegrupalxavineta.domain.Route;
import com.example.projectegrupalxavineta.domain.Truck;
import org.springframework.data.repository.CrudRepository;

public interface TruckRepository extends CrudRepository<Truck,String>  {

    Iterable<Truck> findAllByRoute(Route route);

    Iterable<Truck> deleteAllByIdEquals(String id);
}
