package assigment.sem2.entity;

import assigment.sem2.Util.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.PrimitiveIterator;

public class Order {
    private String id;
    private String customer;
    private String productName;
    private int price;
    private Date createAt;
    private Date dob;
    private int status;

    public Order() {
    }

    public Order(String id, String customer, String productName, int price, Date dob, int status) {
        this.id = id;
        this.customer = customer;
        this.productName = productName;
        this.price = price;
        this.dob = dob;
        this.createAt = Calendar.getInstance().getTime();
        this.status = status;
    }

    public Order(String id, String customer, String productName, int price, String strDob, int status) {
        this.id = id;
        this.customer = customer;
        this.productName = productName;
        this.price = price;
        this.dob = DateTimeUtil.parseDateFromString(strDob);
        this.createAt = Calendar.getInstance().getTime();
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%5s%10s%10s | %10s%10s%10s | %5s%20s%5s | %5s%10s%5s | %5s%10s%5s | %5s%10s%5s\n",
                "",  this.id, "",
                "", this.customer, "",
                "", this.productName, "",
                "", this.price, "vnd", "",
                "", this.getDobString(), "",
                "", this.getStatusName(), ""
        );
    }

    private String getDobString() {
        return  DateTimeUtil.formatDateToString(this.dob);
    }

    private String getStatusName() {
        if (this.status == 1){
            return "Unpaid";
        }else if(this.status == 2){
            return "Paid";
        }
        return this.status == 0 ? "Deleted": "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
