package vttp2023.batch3.assessment.paf.bookings.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp2023.batch3.assessment.paf.bookings.models.Accomodation;
import vttp2023.batch3.assessment.paf.bookings.repositories.BookingRepository;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository bRepo;

    @Autowired
    MongoTemplate mongo;

    @Autowired
    ListingsService lsvc;

    public Boolean checkVacancy(String acc_id, Integer duration){
       //check vacancy days
        Accomodation acc = bRepo.vacancySQL(acc_id);
        Integer vacancy = acc.getVacancy();

        if (duration > vacancy){
            return false;
        }

        return true;
    }

    // @Transactional
    // public Boolean bookReservation(String acc_id, Integer duration){
        // logic
        // check that vacancy exceeds duration
        // if (checkVacancy(acc_id, duration)){
        //     //1. decrease vacancy by duration of stay
        //     bRepo.updateVacancySQL(duration, acc_id);

        //     //2. create reservation 
            
        //     // bRepo.createReservationSQL(Booking book);
        //     // commentted due to error


        //     return true;
        // }



    }



}
