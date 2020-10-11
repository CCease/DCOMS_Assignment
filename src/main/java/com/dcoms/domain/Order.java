package com.dcoms.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable{

    private String id;
    private List<Food> foods;
    private long timeCreated;
    private long timeResolved;
    private String customerID;
    private boolean isSuccess;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getTimeResolved() {
        return timeResolved;
    }

    public void setTimeResolved(long timeResolved) {
        this.timeResolved = timeResolved;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", foods=" + foods +
                ", timeCreated=" + timeCreated +
                ", timeResolved=" + timeResolved +
                ", customerID='" + customerID + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
   
}
