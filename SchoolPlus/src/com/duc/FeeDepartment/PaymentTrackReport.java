/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.FeeDepartment;

/**
 *
 * @author sourabh
 */
public class PaymentTrackReport
{
private String feehead;
private Double totaldues=0.0;
private Double totalpaid = 0.0;
private Double totalremaining = 0.0;

  public PaymentTrackReport(String feehead,Double totaldues,Double totalpaid,Double totalremaining)
    {
      this.feehead=feehead;
      this.totaldues=totaldues;
      this.totalpaid=totalpaid;
      this.totalremaining=totalremaining;
    }

    /**
     * @return the feehead
     */
    public String getFeehead() {
        return feehead;
    }

    /**
     * @param feehead the feehead to set
     */
    public void setFeehead(String feehead) {
        this.feehead = feehead;
    }

    /**
     * @return the totaldues
     */
    public Double getTotaldues() {
        return totaldues;
    }

    /**
     * @param totaldues the totaldues to set
     */
    public void setTotaldues(Double totaldues) {
        this.totaldues = totaldues;
    }

    /**
     * @return the totalpaid
     */
    public Double getTotalpaid() {
        return totalpaid;
    }

    /**
     * @param totalpaid the totalpaid to set
     */
    public void setTotalpaid(Double totalpaid) {
        this.totalpaid = totalpaid;
    }

    /**
     * @return the totalremaining
     */
    public Double getTotalremaining() {
        return totalremaining;
    }

    /**
     * @param totalremaining the totalremaining to set
     */
    public void setTotalremaining(Double totalremaining) {
        this.totalremaining = totalremaining;
    }  

}
