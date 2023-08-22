package cloning.domain;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long addressId;
  private String firstLine;
  private String secondLine;
  private String thirdLine;
  private String zipcode;
  private String city;
  private String state;
  private String country;

  public Address() {
  }

  public Address(Address address) {
    this.addressId = address.getAddressId();
    this.firstLine = address.getFirstLine();
    this.secondLine = address.getSecondLine();
    this.thirdLine = address.getThirdLine();
    this.zipcode = address.getZipcode();
    this.city = address.getCity();
    this.state = address.getState();
    this.country = address.getCountry();
  }

  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public String getFirstLine() {
    return firstLine;
  }

  public void setFirstLine(String firstLine) {
    this.firstLine = firstLine;
  }

  public String getSecondLine() {
    return secondLine;
  }

  public void setSecondLine(String secondLine) {
    this.secondLine = secondLine;
  }

  public String getThirdLine() {
    return thirdLine;
  }

  public void setThirdLine(String thirdLine) {
    this.thirdLine = thirdLine;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Address other = (Address) obj;
    return Objects.equals(addressId, other.addressId) && Objects.equals(city, other.city) && Objects.equals(country, other.country) && Objects.equals(firstLine, other.firstLine)
      && Objects.equals(secondLine, other.secondLine) && Objects.equals(state, other.state) && Objects.equals(thirdLine, other.thirdLine) && Objects.equals(zipcode, other.zipcode);
  }

}
