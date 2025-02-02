package com.example.projectegrupalxavineta.persistance;

import com.example.projectegrupalxavineta.domain.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends CrudRepository<Route, String> {
}
