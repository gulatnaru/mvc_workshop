package com.sds.app;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class SelectTest {

	public static void main(String[] args) {
		Service<String, CustomerVO> service = new CustomerService();
		
		CustomerVO getCustomer = null;
		
		try {
			//getCustomer = service.get();
			System.out.println(getCustomer);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("조회 실패");
		}
	}

}
