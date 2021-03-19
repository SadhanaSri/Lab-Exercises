package day19;

import java.util.Set;

public interface ItemMasterDAO {
	public int insertItem(ItemMasterDTO itemMasterDTO) throws Exception;
	public int deleteItem(int itemNo) throws Exception;
	public int updateItem(ItemMasterDTO itemMasterDTO) throws Exception;
	public ItemMasterDTO getItemMaster(int itemNo) throws Exception;
	public Set<ItemMasterDTO> getItemMasterAll() throws Exception;
}
