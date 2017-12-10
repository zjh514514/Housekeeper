package housekeeper.action;

import java.io.IOException;
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

import housekeeper.entities.CashIn;
import housekeeper.entities.CashOut;
import housekeeper.service.CashInAndCashOutService;
import net.sf.json.JSONObject;

@Controller("cashInAndCashOutAction")
@Scope("prototype")
public class CashInAndCashOutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7498673228509628884L;

	@Resource
	private CashInAndCashOutService cashInAndCashOutService;
	@Resource
	private GetStrResponse getStrResponse;

	private String time;
	private String site;
	private String people;
	private Double money;
	private String remark;
	private Integer memberId;
	private Integer itemId;
	private Integer subItemId;
	private Integer id;
	private Integer accountId;
	private String which;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
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

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getSubItemId() {
		return subItemId;
	}

	public void setSubItemId(Integer subItemId) {
		this.subItemId = subItemId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getWhich() {
		return which;
	}

	public void setWhich(String which) {
		this.which = which;
	}

	/**
	 * 增加一条收支记录
	 * 
	 * @throws Exception
	 */
	public void save() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		Map<String, String> results = new HashMap<>();
		String json = getStrResponse.getStrResponse();
		JSONObject jsonRequest;
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			time = jsonRequest.getString("time");
			site = jsonRequest.getString("site");
			people = jsonRequest.getString("people");
			money = jsonRequest.getDouble("money");
			remark = jsonRequest.getString("remark");
			memberId = jsonRequest.getInt("memberId");
			itemId = jsonRequest.getInt("itemId");
			subItemId = jsonRequest.getInt("subItemId");
			accountId = jsonRequest.getInt("accountId");
			System.out.println(time);
		}
		if (which.equals("i")) {
			result = cashInAndCashOutService.addCashIn(time, site, people, money, remark, memberId, itemId, subItemId,
					accountId);
		} else {
			result = cashInAndCashOutService.addCashOut(time, site, people, money, remark, memberId, itemId, subItemId,
					accountId);
		}
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 删除一条收支记录
	 * 
	 * @throws Exception
	 */
	public void delete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
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
		if (which.equals("i")) {
			result = cashInAndCashOutService.deleteCashIn(id);
		} else {
			result = cashInAndCashOutService.deleteCashOut(id);
		}
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员收支记录
	 * 
	 * @throws Exception
	 */
	public void memberQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		JSONObject jsonRequest;
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			memberId = jsonRequest.getInt("memberId");
		}
		if (which.equals("i")) {
			List<CashIn> cashIns = cashInAndCashOutService.queryCashInByMember(memberId);
			writer.writeObject(cashIns);
			writer.flush();
			writer.close();
		} else {
			List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutByMember(memberId);
			writer.writeObject(cashOuts);
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 查询某一条收支记录
	 * 
	 * @throws Exception
	 */
	public void idQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			id = jsonRequest.getInt("id");
		}
		if (which.equals("i")) {
			List<CashIn> cashIns = cashInAndCashOutService.queryCashInById(id);
			writer.writeObject(cashIns);
			writer.flush();
			writer.close();
		} else {
			List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutById(id);
			writer.writeObject(cashOuts);
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 查询某一成员某一父类收支记录
	 * 
	 * @throws Exception
	 */
	public void itemQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			itemId = jsonRequest.getInt("itemId");
			memberId = jsonRequest.getInt("memberId");
		}
		if (which.equals("i")) {
			List<CashIn> cashIns = cashInAndCashOutService.queryCashInByItem(itemId, memberId);
			writer.writeObject(cashIns);
			writer.flush();
			writer.close();
		} else {
			List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutByItem(itemId, memberId);
			writer.writeObject(cashOuts);
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 查询某一成员某一子类收支记录
	 * 
	 * @throws Exception
	 */
	public void subItemQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			subItemId = jsonRequest.getInt("subItemId");
			memberId = jsonRequest.getInt("memberId");
		}
		if (which.equals("i")) {
			List<CashIn> cashIns = cashInAndCashOutService.queryCashInBySubItem(subItemId, memberId);
			writer.writeObject(cashIns);
			writer.flush();
			writer.close();
		} else {
			List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutBySubItem(subItemId, memberId);
			writer.writeObject(cashOuts);
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 修改一条收入记录
	 * 
	 * @throws Exception
	 */
	public void update() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String result = "";
		Map<String, String> results = new HashMap<>();
		String json = getStrResponse.getStrResponse();
		JSONObject jsonRequest;
		if (json != "") {
			jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			time = jsonRequest.getString("time");
			site = jsonRequest.getString("site");
			people = jsonRequest.getString("people");
			money = jsonRequest.getDouble("money");
			remark = jsonRequest.getString("remark");
			memberId = jsonRequest.getInt("memberId");
			itemId = jsonRequest.getInt("itemId");
			subItemId = jsonRequest.getInt("subItemId");
			accountId = jsonRequest.getInt("accountId");
		}
		if (which.equals("i")) {
			result = cashInAndCashOutService.updateCashIn(time, site, people, money, remark, itemId, subItemId, id,
					accountId);
		} else {
			result = cashInAndCashOutService.updateCashOut(time, site, people, money, remark, itemId, subItemId, id,
					accountId);
		}
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员下某一账户收支记录
	 * 
	 * @throws Exception
	 */
	public void accountQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			which = jsonRequest.getString("which");
			accountId = jsonRequest.getInt("accountId");
			memberId = jsonRequest.getInt("memberId");
		}
		if (which.equals("i")) {
			List<CashIn> cashIns = cashInAndCashOutService.queryCashInByAccount(accountId, memberId);
			writer.writeObject(cashIns);
			writer.flush();
			writer.close();
		} else {
			List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutByAccount(accountId, memberId);
			writer.writeObject(cashOuts);
			writer.flush();
			writer.close();
		}
	}
}
