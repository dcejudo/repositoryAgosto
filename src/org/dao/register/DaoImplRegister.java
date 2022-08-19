package org.dao.register;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.register.Register;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoImplRegister implements DaoRegister {
	
	@SessionTarget
	private Session session;
	
	@TransactionTarget
	private Transaction transaction;

	@Override
	public void addRegister(Register register) {
		try {
			session.saveOrUpdate(register);
		} catch (Exception e) {
			System.out.println("exceception " + e.getMessage());
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Register> listRegisters() {
		List<Register> list = null;
		try {
			list = (List<Register>) session.createQuery("from Register").list();
		} catch (Exception e) {
			System.out.println("exceception " + e.getMessage());
		}
		return list;
	}

	@Override
	public Register getRegisterById(int id) {
		Register register = null;
		try {
			register = (Register) session.get(Register.class, id);
		} catch (Exception e) {
			System.out.println("exceception " + e.getMessage());
		}
		return register;
	}

	@Override
	public void deleteRegister(int id) {
		Register register = null;
		try {
			register = (Register) session.get(Register.class, id);
			session.delete(register);
		} catch (Exception e) {
			System.out.println("exceception " + e.getMessage());
		}
		
	}

}
