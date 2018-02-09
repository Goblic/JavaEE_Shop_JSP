
package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author student
 */
public class Category implements java.io.Serializable{

    public Category(String code) {
        this.code = code;
    }
    
    private Long id; 
    private String name; 
    private String code; 
    private Date creationDate; 
    
    public Category(){}
    // 
    public Category(String code, String name) {        
        this(null, code, name, null);
    }    
    public Category(Long id, String code, String name, Date creationDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.creationDate = creationDate;
    }

    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }
    
    public String getCreationDateAsString() {
        return creationDate != null ? new SimpleDateFormat("dd.MM.yyyy hh:mm").format(creationDate) : "";
    }

    public String getCreationFullDateAsString() {
        return creationDate != null ? new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").format(creationDate) : "";
    }


    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
}
