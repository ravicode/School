/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.FeeDepartment;

/**
 *
 * @author sourabh
 */
public class StatementPrintReport
{
    private String head;
    private Double dues;
    private Double paid;
    private Double remaining;
    private String month;
    private String date;

    public StatementPrintReport(String head,Double dues,Double paid, Double remaining,String month,String date)
    {
     this.head=head;
     this.dues=dues;
     this.paid=paid;
     this.remaining=remaining;
     this.month=month;
     this.date=date;
    }

    /**
     * @return the head
     */
    public String getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * @return the dues
     */
    public Double getDues() {
        return dues;
    }

    /**
     * @param dues the dues to set
     */
    public void setDues(Double dues) {
        this.dues = dues;
    }

    /**
     * @return the paid
     */
    public Double getPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(Double paid) {
        this.paid = paid;
    }

    /**
     * @return the remaining
     */
    public Double getRemaining() {
        return remaining;
    }

    /**
     * @param remaining the remaining to set
     */
    public void setRemaining(Double remaining) {
        this.remaining = remaining;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

}
