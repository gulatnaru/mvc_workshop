package com.sds.app;

import java.util.ArrayList;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class SelectAllTest {

	public static void main(String[] args) {
		Service<String, CustomerVO> customers = new CustomerService();
		
		ArrayList<CustomerVO> list = null;
		
		try {
			list = customers.get();
			System.out.println(list);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
