package jp.kadai;

import java.util.Date;
import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PizzaData {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String name;
     
    @Persistent
    private String price;
     
    @Persistent
    private String comment;
     
    @Persistent
    private Date datetime;
 
    public PizzaData(String name, String price, String comment, Date datetime) {
        super();
        this.name = name;
        this.price = price;
        this.comment = comment;
        this.datetime = datetime;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPrice() {
        return price;
    }
 
    public void setPrice(String price) {
        this.price = price;
    }
 
    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
 
    public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
