package com.myapp;

import com.myapp.repository.UserRepository;

public class InvokeApp {

	public static void main(String[] args) {

		try {
			UserRepository userrepository = new UserRepository();
			if (userrepository.authenticate("chhaya.nikam@gmail.com", "password")) {
				System.out.println("Welcome user");
			} else {
				System.out.println("Access Denied");
			}
		} catch (Exception e) {
			System.out.println("problem in connecting to db ");			
		}

	}

}
