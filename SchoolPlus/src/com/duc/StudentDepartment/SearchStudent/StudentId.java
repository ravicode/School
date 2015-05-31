/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.StudentDepartment.SearchStudent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author sourabh
 */
public class StudentId
{
   private String name="";
   private String id="";
   private String fathername="";
   private String dob="" ;
   private String cls="" ;
   private String section="" ;
   private String phone="" ;
   private BufferedImage bimg=null;

    /**
     * @return the name
     */

   public StudentId(String name,String id, String fathername,String dob,BufferedImage bimg,String cls, String section,String phone)
   {
    this.name=name;
    this.id=id;
    this.fathername=fathername;
    this.dob=dob;
    this.bimg=bimg;
    this.cls=cls;
    this.section=section;
    this.phone=phone;
   }
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
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

    /**
     * @return the father
     */
    public String getFathername() {
        return fathername;
    }

    /**
     * @param father the father to set
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
     * @return the bimg
     */
    public BufferedImage getBimg() {
        return bimg;
    }

    /**
     * @param bimg the bimg to set
     */
    public void setBimg(BufferedImage bimg) {
        this.bimg = bimg;
    }

    public String getCls()
    {
        return cls;
    }

    public void setCls(String cls)
    {
      this.cls=cls;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
      this.section=section;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
      this.phone=phone;
    }
    
}
