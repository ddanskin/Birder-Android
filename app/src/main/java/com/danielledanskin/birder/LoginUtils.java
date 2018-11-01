package com.danielledanskin.birder;

public class LoginUtils {
    /**
     * This method checks if the email address is valid
     * @param email
     * @return
     */
    public boolean isValidEmailAddress(String email){
        boolean hasAtSign = email.indexOf("@") > -1;
        return hasAtSign;
    }

    /**
     * This method returns the length of the local part of the
     * email address.
     * @param email
     * @return
     */
    public int getLocalPartLength(String email) {
        int start = email.indexOf("@");
        String localPart = email.substring(0, start);
        return localPart.length();
    }

    /**
     * This method checks if the password entered is valid.
     * @param password
     * @return
     */
    public boolean isValidPassword(String password){
        if (password.length() < 8) {
            return false;
        }




        return true;
    }
}
