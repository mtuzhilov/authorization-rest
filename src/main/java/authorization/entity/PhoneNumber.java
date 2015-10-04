package authorization.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhoneNumber {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  public enum PhoneType {
    HOME, FAX, CELL
  }

  @Enumerated(EnumType.STRING)
  private PhoneType type = PhoneType.HOME;
  private String number;

  protected PhoneNumber() {}

  public PhoneNumber(PhoneType type, String number) {
    this.type = type;
    this.number = number;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
