package day19;

import java.util.Set;

public interface CustomerMasterDAO {
	public int insertCustomer(CustomerMasterDTO custMasterDTO) throws Exception;
	public int deleteCustomer(int custNo) throws Exception;
	public int updateCustomer(CustomerMasterDTO custMasterDTO) throws Exception;
	public CustomerMasterDTO getCustomerMaster(int custNo) throws Exception;
	public Set<CustomerMasterDTO> getCustomerMasterAll() throws Exception;
}
