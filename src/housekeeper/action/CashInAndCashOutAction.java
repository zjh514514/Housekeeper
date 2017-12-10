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
			if (which.equals("i")) {
				result = cashInAndCashOutService.addCashIn(time, site, people, money, remark, memberId, itemId,
						subItemId, accountId);
			} else {
				result = cashInAndCashOutService.addCashOut(time, site, people, money, remark, memberId, itemId,
						subItemId, accountId);
			}
		} else {
			result = "ERROR";
		}
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 增加一条支出记录
	 * 
	 * @throws Exception
	 */
	public void outSave() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
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
		String result = cashInAndCashOutService.addCashOut(time, site, people, money, remark, memberId, itemId,
				subItemId, accountId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 删除一条收入记录
	 * 
	 * @throws Exception
	 */
	public void inDelete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		String result = cashInAndCashOutService.deleteCashIn(id);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 删除一条支出记录
	 * 
	 * @throws Exception
	 */
	public void outDelete() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		String result = cashInAndCashOutService.deleteCashOut(id);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员收入记录
	 * 
	 * @throws Exception
	 */
	public void inMemberQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			memberId = jsonRequest.getInt("memberId");
		}
		List<CashIn> cashIns = cashInAndCashOutService.queryCashInByMember(memberId);

		System.out.println(cashIns);
		writer.writeObject(cashIns);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员支出记录
	 * 
	 * @throws Exception
	 */
	public void outMemberQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			memberId = jsonRequest.getInt("memberId");
		}
		List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutByMember(memberId);

		System.out.println(cashOuts);
		writer.writeObject(cashOuts);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一条收入记录
	 * 
	 * @throws Exception
	 */
	public void inIdQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		List<CashIn> cashIns = cashInAndCashOutService.queryCashInById(id);

		CashIn cashIn = cashIns.get(0);
		System.out.println(cashIn.getTime());
		writer.writeObject(cashIns);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一条支出记录
	 * 
	 * @throws Exception
	 */
	public void outIdQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			id = jsonRequest.getInt("id");
		}
		List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutById(id);

		writer.writeObject(cashOuts);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员某一父类收入记录
	 * 
	 * @throws Exception
	 */
	public void inItemQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			itemId = jsonRequest.getInt("itemId");
			memberId = jsonRequest.getInt("memberId");
		}
		List<CashIn> cashIns = cashInAndCashOutService.queryCashInByItem(itemId, memberId);

		writer.writeObject(cashIns);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员某一父类支出记录
	 * 
	 * @throws Exception
	 */
	public void outItemQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			itemId = jsonRequest.getInt("itemId");
			memberId = jsonRequest.getInt("memberId");
		}
		List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutByItem(itemId, memberId);

		writer.writeObject(cashOuts);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员某一子类收入记录
	 * 
	 * @throws Exception
	 */
	public void inSubItemQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			subItemId = jsonRequest.getInt("subItemId");
			memberId = jsonRequest.getInt("memberId");
		}
		List<CashIn> cashIns = cashInAndCashOutService.queryCashInBySubItem(subItemId, memberId);

		writer.writeObject(cashIns);
		writer.flush();
		writer.close();
	}

	/**
	 * 查询某一成员某一子类支出记录
	 * 
	 * @throws Exception
	 */
	public void outSubItemQuery() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
			subItemId = jsonRequest.getInt("subItemId");
			memberId = jsonRequest.getInt("memberId");
		}
		List<CashOut> cashOuts = cashInAndCashOutService.queryCashOutBySubItem(subItemId, memberId);

		writer.writeObject(cashOuts);
		writer.flush();
		writer.close();
	}

	/**
	 * 修改一条收入记录
	 * 
	 * @throws Exception
	 */
	public void inUpdate() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
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

		String result = cashInAndCashOutService.updateCashIn(time, site, people, money, remark, itemId, subItemId, id,
				accountId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}

	/**
	 * 修改一条支出记录
	 * 
	 * @throws Exception
	 */
	public void outUpdate() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());

		String json = getStrResponse.getStrResponse();
		if (json != "") {
			JSONObject jsonRequest = JSONObject.fromObject(json);
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

		String result = cashInAndCashOutService.updateCashOut(time, site, people, money, remark, itemId, subItemId, id,
				accountId);
		Map<String, String> results = new HashMap<>();
		results.put("result", result);
		writer.writeObject(results);
		writer.flush();
		writer.close();
	}
}
