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
	private Integer familyId;
	private String familyName;
	private Integer memberId;
	private Double balance;
	private String which;

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

	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	/**
	 * 登陆
	 * 
	 * @throws Exception
	 */
	public void login() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
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
	 * 成员添加
	 * 
	 * @throws Exception
	 */
	public void memberSign() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			username = jsonRequest.getString("username");
			password = jsonRequest.getString("password");
			name = jsonRequest.getString("name");
			role = jsonRequest.getString("role");
			familyId = jsonRequest.getInt("familyId");
		}
		String result = familyAndMemberService.memberSign(username, password, name, role, familyId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 家庭注册
	 * 
	 * @throws Exception
	 */
	public void familySign() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			username = jsonRequest.getString("username");
			password = jsonRequest.getString("password");
			familyName = jsonRequest.getString("familyName");
		}
		String result = familyAndMemberService.familySign(username, password, familyName);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 家庭删除
	 * 
	 * @throws Exception
	 */
	public void familyDelete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			familyId = jsonRequest.getInt("familyId");
		}
		String result = familyAndMemberService.familyDelete(familyId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 成员删除
	 * 
	 * @throws Exception
	 */
	public void memberDelete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			memberId = jsonRequest.getInt("memberId");
		}
		String result = familyAndMemberService.memberDelete(memberId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 修改家庭信息
	 * 
	 * @throws Exception
	 */
	public void familyUpdate() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			password = jsonRequest.getString("password");
			familyName = jsonRequest.getString("familyName");
			familyId = jsonRequest.getInt("familyId");
		}
		String result = familyAndMemberService.familyUpdate(password, familyName, familyId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 成员信息修改
	 * 
	 * @throws Exception
	 */
	public void memberUpdate() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			password = jsonRequest.getString("password");
			role = jsonRequest.getString("role");
			balance = jsonRequest.getDouble("balance");
			memberId = jsonRequest.getInt("memberId");
			name = jsonRequest.getString("name");
		}
		String result = familyAndMemberService.memberUpdate(password, role, balance, memberId, name);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 获取某一家庭信息
	 * 
	 * @throws Exception
	 */
	public void familyIdGet() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			familyId = jsonRequest.getInt("familyId");
		}
		List<Family> families = familyAndMemberService.familyGet(familyId);
		writer.writeObject(families);
		writer.flush();
		writer.close();
	}

	/**
	 * 获取某一家庭成员信息
	 * 
	 * @throws Exception
	 */
	public void memberFamilyGet() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			familyId = jsonRequest.getInt("familyId");
		}
		List<Member> members = familyAndMemberService.memberFamilyGet(familyId);
		writer.writeObject(members);
		writer.flush();
		writer.close();
	}

	/**
	 * 获取某一成员信息
	 * 
	 * @throws Exception
	 */
	public void memberIdGet() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			memberId = jsonRequest.getInt("memberId");
		}
		List<Member> members = familyAndMemberService.memberGet(memberId);
		writer.writeObject(members);
		writer.flush();
		writer.close();
	}
}
