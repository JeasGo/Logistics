package cn.itcast.fore.web.action;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



import cn.itcast.crm.domain.Customer;
import cn.itcast.fore.action.base.common.BaseAction;
import cn.itcast.fore.web.utils.MailUtils;


@Controller
@Scope("prototype")
public class CustomerAction extends BaseAction<Customer> {

	private static final long serialVersionUID = 815772801115457376L;
//  注入Service
//	@Autowired
//	private CustomerService customerService;

	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	//客户注册
	@Action(value="customer_regist",results={
			@Result(type = REDIRECT,location="/signup-success.html"),
			@Result(name = INPUT,type=REDIRECT,location="/signup.html")
	})
	public String regist(){
		System.err.println("======================客户信息保存=========================");
		String checkcodeSession = (String) ServletActionContext.getRequest().getSession().getAttribute(model.getTelephone());
		ServletActionContext.getRequest().getSession().removeAttribute(model.getTelephone());
		if (StringUtils.isBlank(checkcode)||!checkcode.equals(checkcodeSession)) {
			return INPUT;
		}
		WebClient.create("http://localhost:9002/crm_management/services/customerservice/customers").type(MediaType.APPLICATION_JSON).post(model);
		
		return SUCCESS;
		
	}
	
	@Action("customer_sendCheckcode")
	public String sendCheckcode(){
		
		//生成验证码
		String checkcode = RandomStringUtils.randomNumeric(4);
		
		System.err.println("====================================================================");
		System.err.println(checkcode);
		System.err.println("=====================================================================");
		String telephone = model.getTelephone();
		
		//SMSUtils.sendMsg(telephone, checkcode);
		
		ServletActionContext.getRequest().getSession().setAttribute(model.getTelephone(),checkcode);
		
		return NONE;
		
	}
}
