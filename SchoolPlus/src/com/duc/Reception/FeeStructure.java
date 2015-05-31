/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.Reception;

/**
 *
 * @author sourabh
 */
public class FeeStructure
{
    private int group;
    private String head;
    private Double amount;

    /**
     * @return the group
     */

    public FeeStructure(int group,String head, Double amount)
    {
      this.group=group;
      this.head=head;
      this.amount=amount;
    }
    public int getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(int group) {
        this.group = group;
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
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
