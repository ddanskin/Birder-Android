package com.danielledanskin.birder;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUtilsUnitTest {
    private LoginUtils utils = new LoginUtils();

    @Test
    public void aValidEmailAddressPasses() throws Exception {
        assertTrue(utils.isValidEmailAddress("foobar@email.com"));
    }

    @Test
    public void anInvalidEmailFails() throws Exception {
        assertFalse(utils.isValidEmailAddress("foobar.com"));
    }

    @Test
    public void aValidPasswordPasses() throws Exception {
        assertTrue(utils.isValidPassword("Test1234!"));
    }

    @Test
    public void anInvalidPasswordFails() throws Exception {
        assertFalse(utils.isValidPassword("Test1!"));
    }

    @Test
    public void localPartLengthForEmailAddress() throws Exception {
        assertEquals(1, utils.getLocalPartLength("a@email.com"));
    }
}