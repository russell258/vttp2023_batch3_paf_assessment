package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2023.batch3.assessment.paf.bookings.models.Accomodation;
import vttp2023.batch3.assessment.paf.bookings.models.Booking;

@Repository
public class BookingRepository {
    
    @Autowired
    JdbcTemplate jdbc;

    private final String vacancySQL = "select vacancy from acc_occupancy where acc_id = ?";
    private final String updateVacancySQL = "update acc_occupancy set vacancy = vacancy - ? where acc_id=?";
    private final String createReservationSQL = "insert into reservations values (?,?,?,?,?,?)";

    public Accomodation vacancySQL(String acc_id){
        List<Accomodation> accList = jdbc.query(vacancySQL,BeanPropertyRowMapper.newInstance(Accomodation.class),acc_id);
        return accList.get(0);
    }

    public Boolean updateVacancySQL(Integer duration, String acc_id){
        Integer iResult = jdbc.update(updateVacancySQL,duration,acc_id);
        return iResult>0 ? true: false;
    }   

    public Boolean createReservationSQL(Booking book){
        UUID uuid = UUID.randomUUID();
        String resvId = uuid.toString().substring(0, 8);
        Integer iResult = jdbc.update(createReservationSQL,resvId, book.getName(),book.getEmail(),book.getDate(),book.getDuration());
        return iResult>0 ? true: false;
    }


}
