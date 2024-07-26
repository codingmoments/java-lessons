package booking;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Domain class to represent bill for a booking
 */
public class BookingBill {
  private Long bookingId;
  private BigDecimal billAmount;

  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public BigDecimal getBillAmount() {
    return billAmount;
  }

  public void setBillAmount(BigDecimal billAmount) {
    this.billAmount = billAmount;
  }

  @Override
  public boolean equals(Object bookingBill) {
    if (this == bookingBill) {
      return true;
    }
    if (bookingBill == null) {
      return false;
    }
    if (getClass() != bookingBill.getClass()) {
      return false;
    }
    BookingBill other = (BookingBill) bookingBill;
    //@formatter:off
    return Objects.equals(bookingId, other.bookingId)
        && (billAmount == other.billAmount || (billAmount != null && (billAmount.compareTo(other.billAmount)) == 0));
    //@formatter:on
  }
}
