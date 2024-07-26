package booking;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Domain class to represent a room rate
 */
public class RoomRate {

  private Long roomId;
  private LocalDate validFrom;
  private LocalDate validTo;
  private BigDecimal ratePerNight;

  public Long getRoomId() {
    return roomId;
  }

  public void setRoomId(Long roomId) {
    this.roomId = roomId;
  }

  public LocalDate getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(LocalDate validFrom) {
    this.validFrom = validFrom;
  }

  public LocalDate getValidTo() {
    return validTo;
  }

  public void setValidTo(LocalDate validTo) {
    this.validTo = validTo;
  }

  public BigDecimal getRatePerNight() {
    return ratePerNight;
  }

  public void setRatePerNight(BigDecimal ratePerNight) {
    this.ratePerNight = ratePerNight;
  }

}
