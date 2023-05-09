package com.citiustech.main;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.citiustech.model.Customer;
import com.citiustech.ui.MainMenu;

public class FlightManagementMain {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		
		
		MainMenu.mainmenu();
	}

}
