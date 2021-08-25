package com.trucking.logistics.serviceImpl;

        import com.trucking.logistics.entites.Booking;
        import com.trucking.logistics.entites.UserWallet;
        import com.trucking.logistics.repositories.BookingRepository;
        import com.trucking.logistics.services.BookingService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserWalletServiceImpl userWalletServiceImpl;

    //when creating a booking we need to see if there is enough in the wallet
    @Override
    public Long createBooking(Booking booking) {

        UserWallet userWallet = userWalletServiceImpl.findByUserId(booking.getUserId());

        if(booking.getPrice() <= userWallet.getBalance()) {
            Long newBalance = userWallet.getBalance() - booking.getPrice();
            userWallet.setBalance(newBalance);
            userWalletServiceImpl.updateUserWallet(userWallet, userWallet.getId());
            booking.setPaid(true);
            booking.setStatus("A");
            return bookingRepository.save(booking).getId(); //this is the base
        }else{
            booking.setPaid(false);
            booking.setStatus("I");
            return bookingRepository.save(booking).getId(); //this is the base
            //this is where we check the wallet
            //before saving the booking, see if enough in the walet, update(use update command) the wallet content,
            //if no money, set the status to not paid
        }
    }

    @Override
    public void updateBooking(Booking booking, Long id) {
        Booking bookingFromDb = bookingRepository.findById(id).get();
        //System.out.println(userFromDb.toString());
        if(booking.getPickuptime() != null) {
            bookingFromDb.setPickuptime(booking.getPickuptime());
        }
        if(booking.getVehicleNumber() != null) {
            bookingFromDb.setVehicleNumber(booking.getVehicleNumber());
        }
        if(booking.getVehicleType() != null) {
            bookingFromDb.setVehicleType(booking.getVehicleType());
        }
        if(booking.getMaterialType() != null) {
            bookingFromDb.setMaterialType(booking.getMaterialType());
        }
        if(booking.getTotalLoad() != null) {
            bookingFromDb.setTotalLoad(booking.getTotalLoad());
        }
        if(booking.isInvoiceCollected() != null) {
            bookingFromDb.setInvoiceCollected(booking.isInvoiceCollected());
        }
        if(booking.isStatutoryDocsCollected() != null) {
            bookingFromDb.setStatutoryDocsCollected(booking.isStatutoryDocsCollected());
        }
        if(booking.isPaid() != null) {
            bookingFromDb.setPaid(booking.isPaid());
        }
        if(booking.getStatus() != null) {
            bookingFromDb.setStatus(booking.getStatus());
        }
        bookingRepository.save(bookingFromDb);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking bookingFromDb = bookingRepository.findById(id).get();
        bookingFromDb.setStatus("I");
        bookingRepository.save(bookingFromDb);
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()){
            return booking.get();
        }
        return null;
    }

    @Override
    public List<Booking> findBookingUserId(Long id) {
        return bookingRepository.findByUserId(id);
    }

}
