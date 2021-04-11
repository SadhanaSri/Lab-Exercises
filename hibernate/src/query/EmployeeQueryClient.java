package query;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import onetomany.Address;
import onetomany.Employee;
import hibernateday1.HibernateUtility;

public class EmployeeQueryClient {
	public static void main(String[] args) {
		EmployeeQueryClient obj=new EmployeeQueryClient();
		obj.query8();
	}
	
	public void query1() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from Employee");
		List<Employee> list=query.list();
		
		for(Employee emp:list) {
			System.out.println(emp.getEid()+":"+emp.getEmpname());
			Set<Address> addresses=emp.getAddresses();
			for(Address add:addresses) {
				System.out.println(add.getCity()+":"+add.getStreet());
			}
		}		
	}
	
	//where clause and named query
	public void query2() {
		Session session=HibernateUtility.getSession();
//		Query query=session.createQuery("from Employee emp where emp.eid>=1");
		Query query=session.getNamedQuery("myquery");
		List<Employee> list=query.list();
		for(Employee emp:list) {
			System.out.println(emp.getEmpname());
			Set<Address> addresses=emp.getAddresses();
			for(Address add:addresses) {
				System.out.println(add.getCity()+":"+add.getStreet());
			}
		}	
	}
	
	//scalars
	public void query3() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select emp.empname from Employee emp where emp.eid<=20");
		List<Object> list=query.list();
		for(Object emp:list) {
			System.out.println((String)emp);
		}
		
		Query query2=session.createQuery("select emp.eid,emp.empname from Employee emp where emp.eid<=20");
		List<Object[]> list2=query2.list();
		for(Object[] emp:list2) {
			System.out.println((Integer)emp[0]+":"+(String)emp[1]);
		}
	}
	//query paramter and also multiple objects joined...
	public void query4() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.empname, a.city from Employee e, Address a where a.city=:c");
			query.setParameter("c", "pollachi");
			Iterator<Object[]> obj=query.iterate();
			while(obj.hasNext())
			{
				Object o[]=obj.next();
				System.out.println(o[0]+":"+o[1]);
			}
	}
	public void query5() {
		//an inner join will return a employee name ONLY if there is atleast one matching address
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.empname, a.city from Employee e join e.addresses a with a.city=:c");
		query.setParameter("c", "pollachi");
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			System.out.println(o[0]+":"+o[1]);
		}
	}
	public void query6() {
		//an outer join will return all employee names ones with a NULL address if no
		//matching employees are found.
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.empname, a.city from Employee e left join e.addresses a with a.city=:c");
		query.setParameter("c", "chennaii");
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			System.out.println(o[0]+":"+o[1]);
		}	
	}
	
	public void query7() {
		Session session=HibernateUtility.getSession();
		Query q=session.createQuery("update Employee set empsal=empsal+1000");
		int updateditems=q.executeUpdate();
		System.out.println("No of records updated...:"+updateditems);
		session.beginTransaction().commit();
	}
	
	public void query8() {	
		Session session=HibernateUtility.getSession();
		Query q=session.createQuery
		("insert into BackupEmployee (eid, empname,empsal) select e.eid,e.empname,e.empsal from Employee e");
		int createobjects=q.executeUpdate();
		System.out.println(createobjects);
		session.beginTransaction().commit();
	}
}