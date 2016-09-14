package com.example.fifthday;

/**
 * Created by Aslan on 2016/9/14.
 */
public class PhoneNumber {
    int imageId;
    int phoneNumber;

    public PhoneNumber(int imageId, int phoneNumber) {
        this.imageId = imageId;
        this.phoneNumber = phoneNumber;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
