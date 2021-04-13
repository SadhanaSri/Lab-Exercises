package controlpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {
	@Autowired
	private MyBusiness business;
	
	@RequestMapping(value="hello1", method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Welcome to Spring MVC");
	}
	
	@RequestMapping(value="hello2", method = RequestMethod.GET)
	public void sayHello2() {
		System.out.println("Welcome to Spring MVC 2");
	}
	
	@RequestMapping(value="hello3", method = RequestMethod.GET)
	public String sayHello3() {
		System.out.println("Welcome to Spring MVC 3");
		business.doBusiness();
		return "welcome";
	}
	
	@RequestMapping(value="hello4", method = RequestMethod.GET)
	public ModelAndView sayHello4() {
		System.out.println("Welcome to Spring MVC 3");
		Employee emp = business.doBusiness();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		mv.addObject("hello", "hello world");
		mv.addObject("emp", emp);
		return mv;
	}
}

class Employee {
	@Override
	public String toString() {
		return "employee....";
	}
}

@Component
class MyBusiness {
	@Autowired
	private MyService service;
	
	public Employee doBusiness() {
		System.out.println("do business called....");
		service.doService();
		return new Employee();
	}

	public MyService getService() {
		return service;
	}

	public void setService(MyService service) {
		this.service = service;
	}
}

@Service
class MyService {
	@Autowired
	private MyDAO dao;
	
	public void doService() {
		System.out.println("do service called");
		dao.doDao();
	}

	public MyDAO getDao() {
		return dao;
	}

	public void setDao(MyDAO dao) {
		this.dao = dao;
	}
}

@Repository
class MyDAO {
	public void doDao() {
		System.out.println("dodao called..");
	}
}