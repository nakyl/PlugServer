package com.plugserver;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.plugserver.domain.Authority;
import com.plugserver.domain.User;

public class UserTest {

   
    @Test
    public void userGetSet() throws Exception {
    	User usu = new User();
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
    	User usu = new User();
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
				"User{username='username', pass='password', email='email', activated='true', activationKey='activationKey', resetPasswordKey='resetPasswordKey', authorities=[]}");
    	
    }
    
    @Test
    public void userHasCode() throws Exception {
    	User usu = new User();
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
    	User usu = new User();
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
    	
    	User usuDisUserName = new User();
    	usuDisUserName.setUsername("fake");
    	assertFalse(usu.equals(usuDisUserName));
    	
    	Object userObject = (Object) new User();
    	((User)userObject).setUsername("username");
    	assertTrue(usu.equals(userObject));
    	
    	assertFalse(usu.equals(new String()));
    	
    }
}