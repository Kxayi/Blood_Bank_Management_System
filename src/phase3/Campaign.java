/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

/**
 *
 * @author daus
 */
public class Campaign {
    
    private int id;
    private String campaignName, campaignStartDate, campaignVenue;
   
    private Donor donor;
    
    
    public Campaign(int id, String campaignName, String campaignStartDate, String campaignVenue) {
        this.id = id;
        this.campaignName = campaignName;
        this.campaignStartDate = campaignStartDate;
        this.campaignVenue = campaignVenue;
        this.donor = donor;
       
    }
    public Campaign(){
        
        this.campaignName = null;
        this.campaignStartDate = null;
        this.campaignVenue = null;
        this.donor = null;
    }
    public void setId(int id) {
         this.id = id;
    }
    public int getId()
    {
        return id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
    
    
    public String getCampaignName() {
        return campaignName;
    }

    public String getCampaignStartDate() {
        return campaignStartDate;
    }

    public String getCampaignVenue() {
        return campaignVenue;
    }
  
   
}

