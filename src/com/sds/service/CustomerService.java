package com.sds.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.sds.dao.CustomerDao;
import com.sds.dao.ItemDao;
import com.sds.frame.Dao;
import com.sds.frame.Service;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerService extends Service<String, CustomerVO> {
	
	Dao<String, CustomerVO> cDao;
	Dao<String, ItemVO> iDao;
	
	public CustomerService() {
			cDao = new CustomerDao();
			iDao = new ItemDao();
	}

	@Override
	public void register(CustomerVO v) throws Exception {
		//고객 정보가 들어오면
		//고객 정보에 아이템을 세팅하고
		//Dao를 통해 저장 요청 한다.
		//입력을 하다가 오류가 나면 예외사항을 App에 던진다.
		ItemVO item = new ItemVO(v.getId(),"창",1000);
		Connection con = getConn();
		try {
			//System.out.println("tb_user select : "+get(v.getId()));
			if(get(v.getId()) != null) {
				//System.out.println("여길탄다");
				item.setName("방패");
				iDao.insert(item, con);
			}
			else {
				cDao.insert(v, con);
				iDao.insert(item, con);
			}
			con.commit();
		} catch(Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}
		
	}
	
	@Override
	public CustomerVO get(String t) throws Exception {
		CustomerVO customer = null;
		Connection con = getConn();
		
		try {
			customer = cDao.select(t, con);
			if(customer == null)
				return null;
			customer.setItem(iDao.select(t, con));
			iDao.select(t, con);
		} catch(Exception e) {
			throw e;
		} finally {
			
			close(con);
		}
		return customer;
	}

	@Override
	public ArrayList<CustomerVO> get() throws Exception {
		ArrayList<CustomerVO> customers = null;
		Connection con = getConn();
		try {
			customers = cDao.select(con);
		} catch(Exception e) {
			throw e;
		} finally {
			close(con);
		}
		return customers;
	}

}
