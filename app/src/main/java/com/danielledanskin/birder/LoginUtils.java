package com.danielledanskin.birder;

public class LoginUtils {

    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = LoginUtils.class.getName();

    /**
     * This method checks if the email address is valid
     * @param email
     * @return
     */
    public static boolean isValidEmailAddress(String email){
        boolean hasAtSign = email.indexOf("@") > -1;
        return hasAtSign;
    }

    /**
     * This method returns the length of the local part of the
     * email address.
     * @param email
     * @return
     */
    public static int getLocalPartLength(String email) {
        int start = email.indexOf("@");
        String localPart = email.substring(0, start);
        return localPart.length();
    }

    /**
     * This method checks if the password entered is valid.
     * @param password
     * @return
     */
    public static boolean isValidPassword(String password){
        if (password.length() < 8) {
            return false;
        }

        return true;
    }
}
