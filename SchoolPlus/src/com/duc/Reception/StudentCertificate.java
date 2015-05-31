/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.Reception;

/**
 *
 * @author ravi
 */
public class StudentCertificate
{
    private String name="";
    private String fathername="";
    private String dob="";
    private String doa="";
    private String class1="";
    private String id="";

    public StudentCertificate(String name,String fathername,String dob,String doa,String class1,String id)
    {
      this.name=name;
      this.fathername=fathername;
      this.doa=doa;
      this.dob=dob;
      this.class1=class1;
      this.id=id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the fathername
     */
    public String getFathername() {
        return fathername;
    }

    /**
     * @param fathername the fathername to set
     */
    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the doa
     */
    public String getDoa() {
        return doa;
    }

    /**
     * @param doa the doa to set
     */
    public void setDoa(String doa) {
        this.doa = doa;
    }

    /**
     * @return the class1
     */
    public String getClass1() {
        return class1;
    }

    /**
     * @param class1 the class1 to set
     */
    public void setClass1(String class1) {
        this.class1 = class1;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
