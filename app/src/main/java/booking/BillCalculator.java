package booking;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Class to calculate bill for room bookings
 */
public class BillCalculator {

  public List<BookingBill> calculateBills(List<RoomBooking> bookings, List<RoomRate> rates) {
    List<BookingBill> bills = new ArrayList<>();

    bookings.forEach(booking -> {
      List<RoomRate> ratesForRoom = rates.stream().filter(rate -> rate.getRoomId().equals(booking.getRoomId())).collect(Collectors.toList());

      BigDecimal billAmount = BigDecimal.ZERO;
      LocalDate stayDate = booking.getArrivalDate();

      while (stayDate.isBefore(booking.getDepartureDate())) {
        LocalDate date = stayDate;

        //@formatter:off
        Optional<RoomRate> roomRate = ratesForRoom.stream()
            .filter(rate -> (rate.getValidFrom().isBefore(date) || rate.getValidFrom().isEqual(date)) 
                && (rate.getValidTo().isAfter(date) || rate.getValidTo().isEqual(date))).findFirst();
        //@formatter:on

        if (roomRate.isPresent()) {
          billAmount = billAmount.add(roomRate.get().getRatePerNight());
        }

        stayDate = stayDate.plusDays(1);
      }

      BookingBill bill = new BookingBill();
      bill.setBookingId(booking.getBookingId());
      bill.setBillAmount(billAmount);
      bills.add(bill);

    });
    return bills;
  }
}
