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

import housekeeper.entities.Account;
import housekeeper.service.AccountService;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class AccountAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7911753295581288255L;

	@Resource
	private AccountService accountService;
	@Resource
	private GetStrResponse getStrResponse;

	private Integer id;
	private String accountName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * 账户选项添加
	 * 
	 * @throws Exception
	 */
	public void add() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			accountName = jsonRequest.getString("accountName");
		}
		String result = accountService.addAccount(accountName);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 账户选项删除
	 * 
	 * @throws Exception
	 */
	public void delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		String result = accountService.deleteAccount(id);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 账户选项修改
	 * 
	 * @throws Exception
	 */
	public void update() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
			accountName = jsonRequest.getString("accountName");
		}
		String result = accountService.updateAccount(id, accountName);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 账户选项查询
	 * 
	 * @throws Exception
	 */
	public void query() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		List<Account> accounts = accountService.query();
		writer.writeObject(accounts);
		writer.flush();
		writer.close();
	}
}
