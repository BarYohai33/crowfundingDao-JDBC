package com.bean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		EntityManagerFactory
		entityManagerFactory = Persistence.createEntityManagerFactory("crowdfunding");
	}

}