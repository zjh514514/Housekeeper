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

import housekeeper.entities.Card;
import housekeeper.service.CardService;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
public class CardAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4550468265979662129L;

	@Resource
	private CardService cardService;
	@Resource
	private GetStrResponse getStrResponse;

	private String name;
	private String number;
	private Double money;
	private String remark;
	private Integer memberId;
	private Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 保存银行卡
	 * 
	 * @throws Exception
	 */
	public void save() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			name = jsonRequest.getString("name");
			number = jsonRequest.getString("number");
			money = jsonRequest.getDouble("money");
			remark = jsonRequest.getString("remark");
			memberId = jsonRequest.getInt("memberId");
		}
		String result = cardService.addCard(name, number, money, remark, memberId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);

		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 删除银行卡
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
		String result = cardService.deleteCard(id);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);

		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 修改银行卡信息
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
			name = jsonRequest.getString("name");
			number = jsonRequest.getString("number");
			money = jsonRequest.getDouble("money");
			remark = jsonRequest.getString("remark");
			id = jsonRequest.getInt("id");
		}
		String result = cardService.updateCard(name, number, money, remark, id);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);

		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员的银行卡
	 * 
	 * @throws Exception
	 */
	public void memberQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			memberId = jsonRequest.getInt("memberId");
		}
		List<Card> cards = cardService.queryByMember(memberId);

		writer.writeObject(cards);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一银行卡信息
	 * 
	 * @throws Exception
	 */
	public void idQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		List<Card> cards = cardService.queryById(id);

		writer.writeObject(cards);
		writer.flush();
		writer.close();
	}
}
