package model;

public class Customer extends User{
    private int customerID;
    public Customer(int customerID,String name, String email) {
        super(name, email);
        this.customerID=customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
