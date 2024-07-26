package booking;

import static booking.TestDataBuilder.build;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BillCalculatorTestWithTabularDataFormat {

  private BillCalculator billCalculator = new BillCalculator();

  @Test
  public void testCalculateBills_Single_Booking_Single_Rate() {
    //@formatter:off
    String roomBookings =
        "|| bookingId | roomId | arrivalDate | departureDate ||"
      + "||       100 |     10 |  2025-01-01 |    2025-01-10 ||";

    String roomRates =
        "|| roomId |  validFrom |    validTo | ratePerNight ||"
      + "||     10 | 2025-01-01 | 2025-01-31 |         2000 ||";

    String bookingBills =
        "|| bookingId | billAmount ||"
      + "||       100 |      18000 ||";

    //@formatter:on

    testCalculateBills(roomBookings, roomRates, bookingBills);
  }

  @Test
  public void testCalculateBills_Single_Booking_Multi_Rates() {
    //@formatter:off
    String roomBookings =
        "|| bookingId | roomId | arrivalDate | departureDate ||"
      + "||       100 |     10 |  2025-01-01 |    2025-01-10 ||";

    String roomRates =
        "|| roomId |  validFrom |    validTo | ratePerNight ||"
      + "||     10 | 2025-01-01 | 2025-01-05 |         1000 ||"
      + "||     10 | 2025-01-06 | 2025-01-31 |         2000 ||";

    String bookingBills =
        "|| bookingId | billAmount ||"
      + "||       100 |      13000 ||";

    //@formatter:on

    testCalculateBills(roomBookings, roomRates, bookingBills);
  }

  private void testCalculateBills(String roomBookings, String roomRates, String bookingBills) {
    List<RoomBooking> roomBookingList = build(roomBookings, RoomBooking.class);
    List<RoomRate> roomRateList = build(roomRates, RoomRate.class);
    List<BookingBill> expectedBookingBillList = build(bookingBills, BookingBill.class);

    List<BookingBill> actualBookingBillList = billCalculator.calculateBills(roomBookingList, roomRateList);

    assertTrue(expectedBookingBillList.containsAll(actualBookingBillList) && actualBookingBillList.containsAll(expectedBookingBillList));
  }

}
