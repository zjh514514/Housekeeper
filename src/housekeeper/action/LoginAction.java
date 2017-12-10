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

import housekeeper.entities.Family;
import housekeeper.entities.Member;
import housekeeper.service.FamilyAndMemberService;
import net.sf.json.JSONObject;
import housekeeper.action.GetStrResponse;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -743176005568741483L;

	@Resource
	private FamilyAndMemberService familyAndMemberService;
	@Resource(name = "getStrResponse")
	private GetStrResponse getStrResponse;

	private String username;
	private String password;
	private String name;
	private String role;
	private String familyName;
	private Double balance;
	private String which;
	private Integer id;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getWhich() {
		return which;
	}

	public void setWhich(String which) {
		this.which = which;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 登陆
	 * 
	 * @throws Exception
	 */
	public void login() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			username = jsonRequest.getString("username");
			password = jsonRequest.getString("password");
		}
		if (which.equals("m")) {
			result = familyAndMemberService.memberLogin(username, password);
		} else {
			result = familyAndMemberService.familyLogin(username, password);
		}
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 添加
	 * 
	 * @throws Exception
	 */
	public void sign() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		JSONObject jsonRequest;
		String json = getStrResponse.getStrResponse();
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			if (which.equals("m")) {
				username = jsonRequest.getString("username");
				password = jsonRequest.getString("password");
				name = jsonRequest.getString("name");
				role = jsonRequest.getString("role");
				id = jsonRequest.getInt("id");
				result = familyAndMemberService.memberSign(username, password, name, role, id);
			} else {
				username = jsonRequest.getString("username");
				password = jsonRequest.getString("password");
				familyName = jsonRequest.getString("familyName");
				result = familyAndMemberService.familySign(username, password, familyName);
			}
		} else {
			if (which.equals("m")) {
				result = familyAndMemberService.memberSign(username, password, name, role, id);
			} else {
				result = familyAndMemberService.familySign(username, password, familyName);
			}
		}

		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 删除
	 * 
	 * @throws Exception
	 */
	public void delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			id = jsonRequest.getInt("id");
		}
		if (which.equals("m")) {
			result = familyAndMemberService.memberDelete(id);
		} else {
			result = familyAndMemberService.familyDelete(id);
		}
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 修改信息
	 * 
	 * @throws Exception
	 */
	public void update() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		String json = getStrResponse.getStrResponse();
		JSONObject jsonRequest;
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			if (which.equals("m")) {
				password = jsonRequest.getString("password");
				role = jsonRequest.getString("role");
				balance = jsonRequest.getDouble("balance");
				id = jsonRequest.getInt("id");
				name = jsonRequest.getString("name");
				result = familyAndMemberService.memberUpdate(password, role, balance, id, name);
			} else {
				password = jsonRequest.getString("password");
				familyName = jsonRequest.getString("familyName");
				id = jsonRequest.getInt("id");
				result = familyAndMemberService.familyUpdate(password, familyName, id);
			}
		} else {
			if (which.equals("m")) {
				result = familyAndMemberService.memberUpdate(password, role, balance, id, name);
			} else {
				result = familyAndMemberService.familyUpdate(password, familyName, id);
			}
		}
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 获取成员或家庭信息
	 * 
	 * @throws Exception
	 */
	public void idGet() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			id = jsonRequest.getInt("id");
		}
		if (which.equals("m")) {
			List<Member> members = familyAndMemberService.memberGet(id);
			writer.writeObject(members);
			writer.flush();
			writer.close();
		} else {
			List<Family> families = familyAndMemberService.familyGet(id);
			writer.writeObject(families);
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 获取某一家庭成员信息
	 * 
	 * @throws Exception
	 */
	public void familyGet() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		List<Member> members = familyAndMemberService.memberFamilyGet(id);
		writer.writeObject(members);
		writer.flush();
		writer.close();
	}

}
