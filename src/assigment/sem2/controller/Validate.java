package assigment.sem2.controller;

public interface Validate {
    boolean verifyId(String id);
    boolean verifyCustomer(String customer);
    boolean verifyProducts(String products);
    boolean verifyDate(String strDate);
    boolean verifyPrice(int strDate);
    boolean verifyStatus(int status);
}
