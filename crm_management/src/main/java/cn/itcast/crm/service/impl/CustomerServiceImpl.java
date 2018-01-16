package cn.itcast.crm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.CustomerRepository;
import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	//注入dao
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findCustomerListNoFixedAreaId() {
		return customerRepository.findByFixedAreaIdIsNull();
	}

	@Override
	public List<Customer> findCustomerListByFixedAreaId(String fixedAreaId) {
		
		List<Customer> list = customerRepository.findByFixedAreaId(fixedAreaId);
		
		return list;
	}

	@Override
	public void updateFixedAreaIdByCustomerIds(String fixedAreaId, String customerIds) {
		List<Customer> oldCustomerList = customerRepository.findByFixedAreaId(fixedAreaId);
		
		for (Customer customer : oldCustomerList) {
			//在修改之前去掉本家之前关联的id
			customer.setFixedAreaId(null);
		}
		if(StringUtils.isNotBlank(customerIds)&&!customerIds.equals("null")){
			String[] customerIdArray = customerIds.split(",");
			
			for (String id : customerIdArray) {
				System.err.println(id);
				Customer customer = customerRepository.findOne(Integer.parseInt(id));
				//关联上
				customer.setFixedAreaId(fixedAreaId);
			}
		}
		
		
//		//强烈推荐Hibernate的快照
//		//1，取消某定区关联的所有客户可以
//		//查询所有关联某定区的客户列表
//		List<Customer> oldCustomerList = customerRepository.findByFixedAreaId(fixedAreaId);
//		for (Customer customer : oldCustomerList) {
//			//去掉关联
//			customer.setFixedAreaId(null);
//		}
//		//2.将客户和定区关联
//		if(StringUtils.isNotBlank(customerIds)&&!customerIds.equals("null")){
//			String[] customerIdArray = customerIds.split(",");
//			System.err.println(customerIdArray);
//			for (String id : customerIdArray) {
//				Customer customer = customerRepository.findOne(Integer.parseInt(id));
//				//关联上
//				customer.setFixedAreaId(fixedAreaId);
//			}
//		}
//		//等flush
	}

	@Override
	public void saveCustmer(Customer customer) {
		customerRepository.save(customer);
		
	}


}
