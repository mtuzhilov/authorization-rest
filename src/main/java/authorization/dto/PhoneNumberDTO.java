package authorization.dto;

import authorization.entity.PhoneNumber;

public class PhoneNumberDTO {

  public enum PhoneType {
    HOME, FAX, CELL
  }

  private PhoneType type;
  private String number;

  public void fromDomain(PhoneNumber phoneNumber) {
    this.type = PhoneType.valueOf(phoneNumber.getType().toString());
    this.number = phoneNumber.getNumber();
  }

  public PhoneNumber toDomain() {
    return new PhoneNumber(PhoneNumber.PhoneType.valueOf(type.toString()), number);
  }

  public PhoneType getType() {
    return type;
  }

  public void setType(PhoneType type) {
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


}
