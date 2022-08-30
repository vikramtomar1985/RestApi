package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
    private Long cId;
    private String email;
    private String contactName;
    private Long UserId;
    
    

    public Contact(){
        
    }
    public Contact(Long cId, String email, String contactName, Long UserId) {
        this.cId = cId;
        this.email = email;
        this.contactName = contactName;
        this.UserId = UserId;
    }


    public Long getCId() {
        return this.cId;
    }

    public void setCId(Long cId) {
        this.cId = cId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Long getUserId() {
        return this.UserId;
    }

    public void setUserId(Long UserId) {
        this.UserId = UserId;
    }
    
    
}
