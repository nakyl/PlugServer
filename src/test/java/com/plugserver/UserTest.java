package com.plugserver;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.plugserver.domain.Authority;
import com.plugserver.domain.user_info;

public class UserTest {

   
    @Test
    public void userGetSet() throws Exception {
    	user_info usu = new user_info();
    	assertNotNull(usu);
    	
    	Set<Authority> testAuth = new TreeSet<>();
    	usu.setActivated(true);
    	usu.setActivationKey("activationKey");
    	usu.setAuthorities(testAuth);
    	usu.setEmail("email");
    	usu.setPassword("password");
    	usu.setResetPasswordKey("resetPasswordKey");
    	usu.setUsername("username");

    	assertEquals(usu.isActivated(), true);
    	assertEquals(usu.getActivationKey(), "activationKey");
    	assertEquals(usu.getAuthorities(), testAuth);
    	assertEquals(usu.getEmail(), "email");
    	assertEquals(usu.getPassword(), "password");
    	assertEquals(usu.getResetPasswordKey(), "resetPasswordKey");
    	assertEquals(usu.getUsername(), "username");
    	
    }
    
    @Test
    public void userToString() throws Exception {
    	user_info usu = new user_info();
    	assertNotNull(usu);
    	
    	Set<Authority> testAuth = new TreeSet<>();
    	usu.setActivated(true);
    	usu.setActivationKey("activationKey");
    	usu.setAuthorities(testAuth);
    	usu.setEmail("email");
    	usu.setPassword("password");
    	usu.setResetPasswordKey("resetPasswordKey");
    	usu.setUsername("username");
    	
		assertEquals(usu.toString(),
				"user_info{username='username', pass='password', email='email', activated='true', activationKey='activationKey', resetPasswordKey='resetPasswordKey', authorities=[]}");
    	
    }
    
    @Test
    public void userHasCode() throws Exception {
    	user_info usu = new user_info();
    	assertNotNull(usu);
    	
    	Set<Authority> testAuth = new TreeSet<>();
    	usu.setActivated(true);
    	usu.setActivationKey("activationKey");
    	usu.setAuthorities(testAuth);
    	usu.setEmail("email");
    	usu.setPassword("password");
    	usu.setResetPasswordKey("resetPasswordKey");
    	usu.setUsername("username");

    	assertEquals(usu.hashCode(),-265713450);
    	
    }
    
    @Test
    public void userEquals() throws Exception {
    	user_info usu = new user_info();
    	assertNotNull(usu);
    	
    	Set<Authority> testAuth = new TreeSet<>();
    	usu.setActivated(true);
    	usu.setActivationKey("activationKey");
    	usu.setAuthorities(testAuth);
    	usu.setEmail("email");
    	usu.setPassword("password");
    	usu.setResetPasswordKey("resetPasswordKey");
    	usu.setUsername("username");
    	
    	assertTrue(usu.equals(usu));
    	
    	assertFalse(usu.equals(null));
    	
    	user_info usuDisUserName = new user_info();
    	usuDisUserName.setUsername("fake");
    	assertFalse(usu.equals(usuDisUserName));
    	
    	Object userObject = (Object) new user_info();
    	((user_info)userObject).setUsername("username");
    	assertTrue(usu.equals(userObject));
    	
    	assertFalse(usu.equals(new String()));
    	
    }
}