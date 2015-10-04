package authorization.dto;

import authorization.entity.Subject;

public class SubjectDTO {
  private String firstName;
  private String lastName;
  private int age;
  private AddressDTO address;

  public void fromDomain(Subject subject) {
    this.firstName = subject.getFirstName();
    this.lastName = subject.getLastName();
    this.age = subject.getAge();
    AddressDTO addressDTO = new AddressDTO();
    addressDTO.fromDomain(subject.getAddress());
    this.address = addressDTO;
  }

  public Subject toDomain() {
    return new Subject(firstName, lastName, age, address.toDomain());
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }
}
