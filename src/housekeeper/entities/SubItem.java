package housekeeper.entities;

import org.springframework.stereotype.Component;

@Component("subItem")
public class SubItem {

	private Integer subItemId;
	private String subItemName;

	private Item item;

	public Integer getSubItemId() {
		return subItemId;
	}

	public void setSubItemId(Integer subItemId) {
		this.subItemId = subItemId;
	}

	public String getSubItemName() {
		return subItemName;
	}

	public void setSubItemName(String subItemName) {
		this.subItemName = subItemName;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "SubItem [subItemId=" + subItemId + ", subItemName=" + subItemName + ", item=" + item + "]";
	}

}
