package housekeeper.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONWriter;
import com.opensymphony.xwork2.ActionSupport;

import housekeeper.entities.Item;
import housekeeper.entities.SubItem;
import housekeeper.service.ItemsService;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class ItemAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 260340696080751436L;

	@Resource
	private ItemsService itemsService;
	@Resource
	private GetStrResponse getStrResponse;

	private Integer type;
	private Integer id;
	private String itemName;
	private String subItemName;
	private Integer itemId;

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSubItemName() {
		return subItemName;
	}

	public void setSubItemName(String subItemName) {
		this.subItemName = subItemName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * 查询收入或支出父类
	 * 
	 * @throws Exception
	 */
	public void itemGet() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			type = jsonRequest.getInt("type");
		}
		List<Item> items = itemsService.queryItem(type);

		writer.writeObject(items);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一父类下的子类
	 * 
	 * @throws Exception
	 */
	public void subItemGet() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			itemId = jsonRequest.getInt("itemId");
		}
		List<SubItem> subItems = itemsService.querySubItem(itemId);

		writer.writeObject(subItems);
		writer.flush();
		writer.close();
	}

	/**
	 * 修改某一父类名称
	 * 
	 * @throws Exception
	 */
	public void itemUpdate() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			itemName = jsonRequest.getString("itemName");
			id = jsonRequest.getInt("id");
		}
		String result = itemsService.updateItem(itemName, id);
		Map<String, String> results = new HashMap<>();
		results.put("results", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 修改某一子类名称
	 * 
	 * @throws Exception
	 */
	public void subItemUpdate() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			subItemName = jsonRequest.getString("subItemName");
			id = jsonRequest.getInt("id");
		}
		String result = itemsService.updateSubItem(subItemName, id);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 删除某一父类
	 * 
	 * @throws Exception
	 */
	public void itemDelete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		String result = itemsService.deleteItem(id);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 删除某一子类
	 * 
	 * @throws Exception
	 */
	public void subItemDelete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		String result = itemsService.deleteSubItem(id);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 增加某一父类
	 * 
	 * @throws Exception
	 */
	public void itemAdd() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			itemName = jsonRequest.getString("itemName");
			type = jsonRequest.getInt("type");
		}
		String result = itemsService.addItems(itemName, type);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 增加某一父类下的子类
	 * 
	 * @throws Exception
	 */
	public void subItemAdd() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			subItemName = jsonRequest.getString("subItemName");
			itemId = jsonRequest.getInt("itemId");
		}
		String result = itemsService.addSubItems(subItemName, itemId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}
}
