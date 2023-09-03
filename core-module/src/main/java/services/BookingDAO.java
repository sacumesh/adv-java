package services;

import datamodel.Booking;
import datamodel.Facility;
import datamodel.Member;
import services.impl.jpa.GenericDAO;

import java.sql.Timestamp;

public interface BookingDAO extends GenericDAO<Booking> {

    public Booking createBooking(Member member, Facility facility, Timestamp startTime, Integer slots);
}
