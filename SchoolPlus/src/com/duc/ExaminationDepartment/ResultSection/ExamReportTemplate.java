/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.duc.ExaminationDepartment.ResultSection;

/**
 *
 * @author sourabh
 */
public class ExamReportTemplate
{
private String subject;
    private String u1;
    private String u2;
    private String u3;
    private String u4;
    private String t1;
    private String t2;
    private String f1;
    private String f2;
    private String f;
    private String per;

    /**
     * @return the subject
     */

    public ExamReportTemplate(String subject,String u1,String u2,String t1,String u3,String u4,String t2,String f1,String f2,String f,String per)
    {
    this.subject=subject;
    this.t1=t1;
    this.t2=t2;
    this.u1=u1;
    this.u2=u2;
    this.u3=u3;
    this.u4=u4;
    this.f1=f1;
    this.f2=f2;
    this.f=f;
    this.per=per;
    }
    
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the u1
     */
    public String getU1() {
        return u1;
    }

    /**
     * @param u1 the u1 to set
     */
    public void setU1(String u1) {
        this.u1 = u1;
    }

    /**
     * @return the u2
     */
    public String getU2() {
        return u2;
    }

    /**
     * @param u2 the u2 to set
     */
    public void setU2(String u2) {
        this.u2 = u2;
    }

    /**
     * @return the u3
     */
    public String getU3() {
        return u3;
    }

    /**
     * @param u3 the u3 to set
     */
    public void setU3(String u3) {
        this.u3 = u3;
    }

    /**
     * @return the u4
     */
    public String getU4() {
        return u4;
    }

    /**
     * @param u4 the u4 to set
     */
    public void setU4(String u4) {
        this.u4 = u4;
    }

    /**
     * @return the t1
     */
    public String getT1() {
        return t1;
    }

    /**
     * @param t1 the t1 to set
     */
    public void setT1(String t1) {
        this.t1 = t1;
    }

    /**
     * @return the t2
     */
    public String getT2() {
        return t2;
    }

    /**
     * @param t2 the t2 to set
     */
    public void setT2(String t2) {
        this.t2 = t2;
    }

    /**
     * @return the f1
     */
    public String getF1() {
        return f1;
    }

    /**
     * @param f1 the f1 to set
     */
    public void setF1(String f1) {
        this.f1 = f1;
    }

    /**
     * @return the f2
     */
    public String getF2() {
        return f2;
    }

    /**
     * @param f2 the f2 to set
     */
    public void setF2(String f2) {
        this.f2 = f2;
    }

    /**
     * @return the f
     */
    public String getF() {
        return f;
    }

    /**
     * @param f the f to set
     */
    public void setF(String f) {
        this.f = f;
    }

    /**
     * @return the per
     */
    public String getPer() {
        return per;
    }

    /**
     * @param per the per to set
     */
    public void setPer(String per) {
        this.per = per;
    }
}
