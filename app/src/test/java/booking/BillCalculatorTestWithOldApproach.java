package booking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

public class BillCalculatorTestWithOldApproach {

  private BillCalculator billCalculator = new BillCalculator();

  @Test
  public void testCalculateBills_Single_Booking_Single_Rate() {
    RoomBooking roomBooking = new RoomBooking();
    roomBooking.setBookingId(100L);
    roomBooking.setRoomId(10L);
    roomBooking.setArrivalDate(LocalDate.of(2025, 1, 1));
    roomBooking.setDepartureDate(LocalDate.of(2025, 1, 10));

    RoomRate roomRate = new RoomRate();
    roomRate.setRoomId(10L);
    roomRate.setValidFrom(LocalDate.of(2025, 1, 1));
    roomRate.setValidTo(LocalDate.of(2025, 1, 31));
    roomRate.setRatePerNight(BigDecimal.valueOf(2_000));

    BookingBill bookingBill = new BookingBill();
    bookingBill.setBookingId(100L);
    bookingBill.setBillAmount(BigDecimal.valueOf(18_000));

    List<BookingBill> actualBookingBillList = billCalculator.calculateBills(List.of(roomBooking), List.of(roomRate));

    assertEquals(bookingBill, actualBookingBillList.get(0));
  }

  @Test
  public void testCalculateBills_Single_Booking_Multi_Rates() {
    RoomBooking roomBooking = new RoomBooking();
    roomBooking.setBookingId(100L);
    roomBooking.setRoomId(10L);
    roomBooking.setArrivalDate(LocalDate.of(2025, 1, 1));
    roomBooking.setDepartureDate(LocalDate.of(2025, 1, 10));

    RoomRate roomRate1 = new RoomRate();
    roomRate1.setRoomId(10L);
    roomRate1.setValidFrom(LocalDate.of(2025, 1, 1));
    roomRate1.setValidTo(LocalDate.of(2025, 1, 5));
    roomRate1.setRatePerNight(BigDecimal.valueOf(1_000));

    RoomRate roomRate2 = new RoomRate();
    roomRate2.setRoomId(10L);
    roomRate2.setValidFrom(LocalDate.of(2025, 1, 6));
    roomRate2.setValidTo(LocalDate.of(2025, 1, 31));
    roomRate2.setRatePerNight(BigDecimal.valueOf(2_000));

    BookingBill bookingBill = new BookingBill();
    bookingBill.setBookingId(100L);
    bookingBill.setBillAmount(BigDecimal.valueOf(13_000));

    List<BookingBill> actualBookingBillList = billCalculator.calculateBills(List.of(roomBooking), List.of(roomRate1, roomRate2));

    assertEquals(bookingBill, actualBookingBillList.get(0));
  }

}
