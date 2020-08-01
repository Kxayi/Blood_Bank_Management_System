/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

/**
 * @author daus
 */
public class Organization {

    private int organizationID;
    private String orgnizationName, orgnizationAddress, orgnizationPhoneNo, orgnizationEmail;
    private Campaign campaign;

    public Organization(int orgnizationID, String orgnizationName, String orgnizationAddress, String orgnizationPhoneNo, String orgnizationEmail) {
        this.organizationID = orgnizationID;
        this.orgnizationName = orgnizationName;
        this.orgnizationAddress = orgnizationAddress;
        this.orgnizationPhoneNo = orgnizationPhoneNo;
        this.orgnizationEmail = orgnizationEmail;
        campaign = new Campaign();
    }

   public void setOrgnizationID(int orgnizationID) {
         this.organizationID = orgnizationID;
    }

    public void setOrgnizationName(String orgnizationName) {
        this.orgnizationName = orgnizationName;
    }

    public void setOrgnizationAddress(String orgnizationAddress) {
        this.orgnizationAddress = orgnizationAddress;
    }

    public void setOrgnizationPhoneNo(String orgnizationPhoneNo) {
        this.orgnizationPhoneNo = orgnizationPhoneNo;
    }

    public void setOrgnizationEmail(String orgnizationEmail) {
        this.orgnizationEmail = orgnizationEmail;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public int getOrgnizationID() {
        return organizationID;
    }
    
    public String getOrgnizationName() {
        return orgnizationName;
    }

    public String getOrgnizationAddress() {
        return orgnizationAddress;
    }

    public String getOrgnizationPhoneNo() {
        return orgnizationPhoneNo;
    }

    public String getOrgnizationEmail() {
        return orgnizationEmail;
    }

    public void updateDetails(String orgnizationName, String orgnizationAddress, String orgnizationPhoneNo, String orgnizationEmail) {
        this.orgnizationName = orgnizationName;
        this.orgnizationAddress = orgnizationAddress;
        this.orgnizationPhoneNo = orgnizationPhoneNo;
        this.orgnizationEmail = orgnizationEmail;
    }
}

