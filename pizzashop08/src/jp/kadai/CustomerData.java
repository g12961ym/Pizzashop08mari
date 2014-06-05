package jp.kadai;

import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class CustomerData {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String name;
     
    @Persistent
    private String order;
     
    @Persistent
    private String count;
       
    @Persistent
    private Date datetime;
 
    public CustomerData(String name, String order, String count, Date datetime) {
        super();
        this.name = name;
        this.order = order;
        this.count = count;
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
 
    public String getOrder() {
        return order;
    }
 
    public void setOrder(String order) {
        this.order= order;
    }
 
    public String getCount() {
        return count;
    }
 
    public void setCount(String count) {
        this.count = count;
    }
 
    public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
