package com.sds.app;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class App {
	public static void main(String[] args) {
		Service<String, CustomerVO> service = new CustomerService();
		CustomerVO customer = new CustomerVO("id01","pwd01","이말숙");
		
		try {
			service.register(customer);
			service.register(customer);
			
			System.out.println("입력 정상");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 실패");
		}
	}

}
