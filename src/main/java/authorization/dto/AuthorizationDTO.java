package authorization.dto;

import java.util.ArrayList;
import java.util.List;

import authorization.entity.Authorization;
import authorization.entity.PhoneNumber;

public class AuthorizationDTO {

  private Long id;
  private SubjectDTO subject;
  private List<PhoneNumberDTO> phoneNumbers;

  public void fromDomain(Authorization authorization) {
    SubjectDTO subject = new SubjectDTO();
    subject.fromDomain(authorization.getSubject());
    List<PhoneNumberDTO> phoneNumbers = new ArrayList<>();
    for (PhoneNumber phoneNumber : authorization.getPhoneNumbers()) {
      PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO();
      phoneNumberDTO.fromDomain(phoneNumber);
      phoneNumbers.add(phoneNumberDTO);
    }
    this.id = authorization.getId();
    this.subject = subject;
    this.phoneNumbers = phoneNumbers;
  }

  public Authorization toDomain() {
    List<PhoneNumber> numbers = new ArrayList<>();
    for (PhoneNumberDTO number : phoneNumbers) {
      numbers.add(number.toDomain());
    }
    return new Authorization(this.subject.toDomain(), numbers);
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SubjectDTO getSubject() {
    return subject;
  }

  public void setSubject(SubjectDTO subject) {
    this.subject = subject;
  }

  public List<PhoneNumberDTO> getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }


}
