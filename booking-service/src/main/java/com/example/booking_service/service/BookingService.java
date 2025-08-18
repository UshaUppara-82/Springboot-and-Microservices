package com.example.booking_service.service;

import com.example.booking_service.model.Booking;
import com.example.booking_service.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setCustomerName(updatedBooking.getCustomerName());
            booking.setContactNumber(updatedBooking.getContactNumber());
            booking.setRouteId(updatedBooking.getRouteId());
            booking.setVehicleId(updatedBooking.getVehicleId());
            booking.setDriverId(updatedBooking.getDriverId());
            booking.setBookingStatus(updatedBooking.getBookingStatus());
            booking.setStartTime(updatedBooking.getStartTime());
            booking.setEndTime(updatedBooking.getEndTime());
            return bookingRepository.save(booking);
        }).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
