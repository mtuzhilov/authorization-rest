package authorization.dto;

import authorization.entity.Address;

public class AddressDTO {
  private String street1;
  private String street2;
  private String city;
  private String state;
  private int postalCode;

  public void fromDomain(Address address) {
    this.street1 = address.getStreet1();
    this.street2 = address.getStreet2();
    this.city = address.getCity();
    this.state = address.getState();
    this.postalCode = address.getPostalCode();
  }

  public Address toDomain() {
    return new Address(street1, street2, city, state, postalCode);
  }

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
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

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }
}
