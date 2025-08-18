package com.example.route_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.route_service.model.Route;
import com.example.route_service.repository.RouteRepository;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    public Route updateRoute(Long id, Route updatedRoute) {
        return routeRepository.findById(id)
                .map(route -> {
                    route.setSource(updatedRoute.getSource());
                    route.setDestination(updatedRoute.getDestination());
                    route.setDistance(updatedRoute.getDistance());
                    route.setDuration(updatedRoute.getDuration());
                    return routeRepository.save(route);
                })
                .orElseThrow(() -> new RuntimeException("Route not found with id " + id));
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }
}
