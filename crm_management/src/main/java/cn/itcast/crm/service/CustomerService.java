package cn.itcast.crm.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cn.itcast.crm.domain.Customer;


//SET接口:暴露方法
@Path("/customers")
//消费者
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})


//生产者
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public interface CustomerService {
	@Path("/nofixedareaid")//小写URI
	@GET
	public List<Customer> findCustomerListNoFixedAreaId();

	@Path("/fixedareaid/{fixedAreaId}")//小写URI
	@GET
	public List<Customer> findCustomerListByFixedAreaId(@PathParam("fixedAreaId")String fixedAreaId);

	
	@Path("/fixedareaid/{fixedAreaId}/{customerIds}")
	@PUT //更新
	public void updateFixedAreaIdByCustomerIds(@PathParam("fixedAreaId")String fixedAreaId,@PathParam("customerIds")String customerIds);

	
	@POST
	public void saveCustmer(Customer customer);
}
