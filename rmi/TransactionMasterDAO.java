package day19;

import java.util.Set;

public interface TransactionMasterDAO {
	public int insertTransaction(TransactionMasterDTO transMasterDTO) throws Exception;
	public int deleteTransaction(int invNo) throws Exception;
	public int updateTransaction(TransactionMasterDTO transMasterDTO) throws Exception;
	public TransactionMasterDTO getTransactionMaster(int invNo) throws Exception;
	public Set<TransactionMasterDTO> getTransactionMasterAll() throws Exception;
}
