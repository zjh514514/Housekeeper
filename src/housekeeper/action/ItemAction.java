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
	private String which;

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

	public String getWhich() {
		return which;
	}

	public void setWhich(String which) {
		this.which = which;
	}

	/**
	 * 查询父类或子类
	 * 
	 * @throws Exception
	 */
	public void get() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		JSONObject jsonRequest;
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			System.out.println(jsonRequest);
			which = jsonRequest.getString("which");
			System.out.println(which);
			// which是i时查询父类，否则查询子类
			if (which.equals("i")) {
				type = jsonRequest.getInt("type");
				List<Item> items = itemsService.queryItem(type);
				writer.writeObject(items);
				writer.flush();
				writer.close();
			} else {
				itemId = jsonRequest.getInt("itemId");
				List<SubItem> subItems = itemsService.querySubItem(itemId);
				writer.writeObject(subItems);
				writer.flush();
				writer.close();
			}
		} else {
			// which是i时查询父类，否则查询子类
			if (which.equals("i")) {
				List<Item> items = itemsService.queryItem(type);
				writer.writeObject(items);
				writer.flush();
				writer.close();
			} else {
				List<SubItem> subItems = itemsService.querySubItem(itemId);
				writer.writeObject(subItems);
				writer.flush();
				writer.close();
			}
		}
	}

	/**
	 * 修改父类或子类名称
	 * 
	 * @throws Exception
	 */
	public void update() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		Map<String, String> results = new HashMap<>();
		String json = getStrResponse.getStrResponse();
		JSONObject jsonRequest;
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			// which为i时修改父类，否则修改子类
			if (which.equals("i")) {
				itemName = jsonRequest.getString("itemName");
				id = jsonRequest.getInt("id");
				result = itemsService.updateItem(itemName, id);
			} else {
				subItemName = jsonRequest.getString("subItemName");
				id = jsonRequest.getInt("id");
				result = itemsService.updateSubItem(subItemName, id);
			}
			results.put("result", result);
		} else {
			if (which.equals("i")) {
				result = itemsService.updateItem(itemName, id);
			} else {
				result = itemsService.updateSubItem(subItemName, id);
			}
			results.put("result", result);
		}
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 删除父类或子类
	 * 
	 * @throws Exception
	 */
	public void delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		Map<String, String> results = new HashMap<>();
		String json = getStrResponse.getStrResponse();
		JSONObject jsonRequest;
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			id = jsonRequest.getInt("id");
		}
		// which为i时删除父类，否则删除子类
		if (which.equals("i")) {
			result = itemsService.deleteItem(id);
		} else {
			result = itemsService.deleteSubItem(id);
		}
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 增加父类或子类
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		Map<String, String> results = new HashMap<>();
		String json = getStrResponse.getStrResponse();
		JSONObject jsonRequest;
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			// which为i时增加父类，否则增加子类
			if (which.equals("i")) {
				itemName = jsonRequest.getString("itemName");
				type = jsonRequest.getInt("type");
				result = itemsService.addItems(itemName, type);
			} else {
				subItemName = jsonRequest.getString("subItemName");
				itemId = jsonRequest.getInt("itemId");
				result = itemsService.addSubItems(subItemName, itemId);
			}
			results.put("result", result);
		} else {
			if (which.equals("i")) {
				result = itemsService.addItems(itemName, type);
			} else {
				result = itemsService.addSubItems(subItemName, itemId);
			}
			results.put("result", result);
		}
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

}
