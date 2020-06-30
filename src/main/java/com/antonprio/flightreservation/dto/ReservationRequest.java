package com.antonprio.flightreservation.dto;

import java.util.Date;

public class ReservationRequest {

    private Long flightId;
    private String passangerFirstName;
    private String passangerMiddleName;
    private String passangerLastName;
    private String passangerEmail;
    private String passangerPhone;
    private String nameOnTheCard;
    private String cardNumber;
    private Date expirationDate;
    private String securityCode;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getPassangerFirstName() {
        return passangerFirstName;
    }

    public void setPassangerFirstName(String passangerFirstName) {
        this.passangerFirstName = passangerFirstName;
    }

    public String getPassangerMiddleName() {
        return passangerMiddleName;
    }

    public void setPassangerMiddleName(String passangerMiddleName) {
        this.passangerMiddleName = passangerMiddleName;
    }

    public String getPassangerLastName() {
        return passangerLastName;
    }

    public void setPassangerLastName(String passangerLastName) {
        this.passangerLastName = passangerLastName;
    }

    public String getPassangerEmail() {
        return passangerEmail;
    }

    public void setPassangerEmail(String passangerEmail) {
        this.passangerEmail = passangerEmail;
    }

    public String getPassangerPhone() {
        return passangerPhone;
    }

    public void setPassangerPhone(String passangerPhone) {
        this.passangerPhone = passangerPhone;
    }

    public String getNameOnTheCard() {
        return nameOnTheCard;
    }

    public void setNameOnTheCard(String nameOnTheCard) {
        this.nameOnTheCard = nameOnTheCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "flightId=" + flightId +
                ", passangerFirstName='" + passangerFirstName + '\'' +
                ", passangerMiddleName='" + passangerMiddleName + '\'' +
                ", passangerLastName='" + passangerLastName + '\'' +
                ", passangerEmail='" + passangerEmail + '\'' +
                ", passangerPhone='" + passangerPhone + '\'' +
                ", nameOnTheCard='" + nameOnTheCard + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
