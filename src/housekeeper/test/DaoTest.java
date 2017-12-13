package housekeeper.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import housekeeper.dao.CardDao;
import housekeeper.dao.CashInDao;
import housekeeper.dao.CashOutDao;
import housekeeper.dao.FamilyDao;
import housekeeper.dao.ItemDao;
import housekeeper.dao.MemberDao;
import housekeeper.dao.SubItemDao;
import housekeeper.entities.Account;
import housekeeper.entities.Card;
import housekeeper.entities.CashIn;
import housekeeper.entities.CashOut;
import housekeeper.entities.Family;
import housekeeper.entities.Item;
import housekeeper.entities.Member;
import housekeeper.entities.SubItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DaoTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private ItemDao itemDao;
	@Resource
	private SubItemDao subItemDao;
	@Resource
	private FamilyDao familyDao;
	@Resource
	private MemberDao memberDao;
	@Resource
	private CardDao cardDao;
	@Resource
	private CashInDao cashInDao;
	@Resource
	private CashOutDao cashOutDao;

	/**
	 * ����ItemDao
	 */
	@Test
	public void testItemGetAll() {
		List<Item> items = itemDao.getAll();
		String item = items.toString();
		// List<Item> item2=new ArrayList<Item>(item);
		String itemJson = JSON.toJSONString(items);
		System.out.println(itemJson);
	}

	@Test
	public void testItemSave() {
		Item item = new Item();
		item.setItemName("����");
		itemDao.save(item);
	}

	@Test
	public void testItemDelete() {
		itemDao.delete(4);
	}

	@Test
	public void testItemUpdate() {
		itemDao.update(3, "����");
	}

	@Test
	public void testItemQueryByType() {
		System.out.println(itemDao.queryByType(0));
	}

	@Test
	public void testItemQueryByName() {
		System.out.println(itemDao.queryByName("aa"));
	}

	@Test
	public void testItemQueryById() {
		System.out.println(itemDao.queryById(1));
	}

	/**
	 * ����SubItemDao
	 */
	@Test
	public void testSubItemGetAll() {
		System.out.println(subItemDao.getAll());
	}

	@Test
	public void testSubItemSave() {
		SubItem subItem = new SubItem();
		Item item = new Item();
		item.setItemId(1);
		subItem.setItem(item);
		subItem.setSubItemName("�з�");
		subItemDao.save(subItem);
	}

	@Test
	public void testSubItemDelete() {
		subItemDao.delete(1);
	}

	@Test
	public void testSubItemUpdate() {
		subItemDao.update(2, "��");
	}

	@Test
	public void testSubItemQueryByItem() {
		// Item item = new Item();
		// item.setItemId(1);
		System.out.println(subItemDao.queryByItem(1));
	}

	@Test
	public void testSubItemQueryByName() {
		System.out.println(subItemDao.queryByName("aa"));
	}

	@Test
	public void testSubItemQueryById() {
		System.out.println(subItemDao.queryById(1));
	}

	/**
	 * ����FamilyDao
	 */
	@Test
	public void testFamilySave() {
		Family family = new Family();
		family.setFamilyName("aa");
		family.setUsername("aaa");
		family.setPassword("123");
		familyDao.save(family);
	}

	@Test
	public void testFamilyDelete() {
		familyDao.delete(2);
	}

	@Test
	public void testFamilyUpdate() {
		Family family = new Family();
		family.setFamilyId(1);
		family.setFamilyName("bbb");
		family.setUsername("bb");
		family.setPassword("123123");
		familyDao.update(family);
	}

	@Test
	public void testFamilyQuery() {
		System.out.println(familyDao.query("bbb"));
	}

	@Test
	public void testFamilyQueryByUsername() {
		System.out.println(familyDao.queryByUsername("aa").size() == 1);
	}

	@Test
	public void testFamilyQueryById() {
		System.out.println(familyDao.queryById(1));
	}

	/**
	 * ����MemberDao
	 */
	@Test
	public void testMemberSave() {
		Family family = new Family();
		family.setFamilyId(1);

		Member member = new Member();
		member.setName("aa");
		member.setUsername("aaa");
		member.setPassword("123");
		member.setRole("aa");
		member.setBalance(100.01);
		member.setFamily(family);

		memberDao.save(member);
	}

	@Test
	public void testMemberDelete() {
		memberDao.delete(1);
	}

	@Test
	public void testMemberUpdate() {
		Family family = new Family();
		family.setFamilyId(1);

		Member member = new Member();
		member.setMemberId(1);
		member.setName("bb");
		member.setUsername("bbb");
		member.setPassword("123123");
		member.setBalance(10.18);
		member.setFamily(family);
		memberDao.update(member);
	}

	@Test
	public void testMemberGetAll() {
		System.out.println(memberDao.getAll());
	}

	@Test
	public void testMemberQueryByUsername() {
		System.out.println(memberDao.queryByUsername("bbb"));
	}

	@Test
	public void testMemberQueryById() {
		System.out.println(memberDao.queryById(3));
	}

	@Test
	public void testMemberQueryByFamily() {
		Family family = new Family();
		family.setFamilyId(1);
		System.out.println(memberDao.queryByFamily(1));
	}

	@Test
	public void testMemberSumCashIn() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str="2017-01-01 10:00:00";
		Date date=sdf.parse(str);
		System.out.println(memberDao.sumCashIn(3,date));
	}

	@Test
	public void testMemberSumCashOut() {
		System.out.println(memberDao.sumCashOut(3));
	}

	/**
	 * ����CardDao
	 */
	@Test
	public void testCardSave() {
		Member member = new Member();
		member.setMemberId(1);

		Card card = new Card();
		card.setCardName("bb");
		card.setCardNumber("11111");
		card.setMoney(50.54);
		card.setRemark("asdasd");
		card.setMember(member);
		cardDao.save(card);
	}

	@Test
	public void testCardDelete() {
		cardDao.delete(2);
	}

	@Test
	public void testCardUpdate() {
		Card card = new Card();
		card.setCardName("bb");
		card.setCardNumber("11111");
		card.setMoney(58647.58);
		card.setRemark("bbbbb");
		card.setCardId(1);
		cardDao.update(card);
	}

	@Test
	public void testCardQueryByMember() {
		Member member = new Member();
		member.setMemberId(1);
		System.out.println(cardDao.queryByMember(3));
	}

	@Test
	public void testCardQueryById() {
		System.out.println(cardDao.queryById(-1).size());
	}

	/**
	 * ����CashInDao
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testCashInSave() throws ParseException {
		Member member = new Member();
		member.setMemberId(1);
		Item item = new Item();
		item.setItemId(1);
		SubItem subItem = new SubItem();
		subItem.setSubItemId(1);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dstr = "2017-11-27";
		Date time = sdf.parse(dstr);

		CashIn cashIn = new CashIn();
		cashIn.setMoney(100.01);
		cashIn.setItem(item);
		cashIn.setSubItem(subItem);
		cashIn.setRemark("aaa");
		cashIn.setSite("aaa");
		cashIn.setTime(time);
		cashIn.setMember(member);
		cashIn.setPeople("aa");
		cashInDao.save(cashIn);
	}

	@Test
	public void testCashInDelete() {
		cashInDao.delete(2);
	}

	@Test
	public void testCashInUpdate() throws ParseException {
		Item item = new Item();
		item.setItemId(5);
		SubItem subItem = new SubItem();
		subItem.setSubItemId(14);

		CashIn cashIn = new CashIn();
		cashIn.setCashInId(8);
		cashIn.setItem(item);
		cashIn.setSubItem(subItem);
		cashIn.setTime(new Date());
		cashIn.setSite("bb");
		cashIn.setRemark("bbb");
		cashIn.setPeople("bb");
		cashIn.setMoney(20.54);

		cashInDao.update(cashIn);
	}

	@Test
	public void testCashInQueryByMember() {
		// Member member = new Member();
		// member.setMemberId(1);
		System.out.println(cashInDao.queryByMember(3));
	}

	@Test
	public void testCashInQueryByItem() {
		// Item item = new Item();
		// item.setItemId(1);
		//
		// Member member = new Member();
		// member.setMemberId(6);

		System.out.println(cashInDao.queryByItem(5, 3));
	}

	@Test
	public void testCashInQueryBySubItem() {
		// SubItem subItem = new SubItem();
		// subItem.setSubItemId(1);
		//
		// Member member = new Member();
		// member.setMemberId(6);

		System.out.println(cashInDao.queryBySubItem(15, 3));
	}

	@Test
	public void testCashInQueryById() {
		System.out.println(cashInDao.queryById(4));
	}

	/**
	 * ����CashOutDao
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testCashOutSave() throws ParseException {
		Member member = new Member();
		member.setMemberId(3);
		Item item = new Item();
		item.setItemId(1);
		SubItem subItem = new SubItem();
		subItem.setSubItemId(13);
		Account account = new Account();
		account.setAccountId(1);

		String date = "2017-12-10 16:18";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		CashOut cashOut = new CashOut();
		cashOut.setItem(item);
		cashOut.setMember(member);
		cashOut.setMoney(156.45);
		cashOut.setPeople("aa");
		cashOut.setRemark("aa");
		cashOut.setSite("aa");
		cashOut.setSubItem(subItem);
		cashOut.setTime(f.parse(date));
		cashOut.setAccount(account);

		cashOutDao.save(cashOut);
	}

	@Test
	public void testCashOutDelete() {
		cashOutDao.delete(2);
	}

	@Test
	public void testCashOutUpdate() throws Exception {
		Item item = new Item();
		item.setItemId(2);
		SubItem subItem = new SubItem();
		subItem.setSubItemId(2);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dstr = "2017-3-5";
		Date time = sdf.parse(dstr);

		CashOut cashOut = new CashOut();
		cashOut.setCashOutId(1);
		cashOut.setItem(item);
		cashOut.setMoney(621.06);
		cashOut.setPeople("bb");
		cashOut.setRemark("bb");
		cashOut.setSite("bb");
		cashOut.setSubItem(subItem);
		cashOut.setTime(time);
		cashOutDao.update(cashOut);
	}

	@Test
	public void testCashOutQueryByMember() {
		// Member member = new Member();
		// member.setMemberId(1);
		System.out.println(cashOutDao.queryByMember(1));
	}

	@Test
	public void testCashOutQueryByItem() {
		// Item item = new Item();
		// item.setItemId(2);
		// Member member = new Member();
		// member.setMemberId(6);
		System.out.println(cashOutDao.queryByItem(1, 1));
	}

	@Test
	public void testCashOutQueryBySubItem() {
		// SubItem subItem = new SubItem();
		// subItem.setSubItemId(2);
		// Member member = new Member();
		// member.setMemberId(6);
		System.out.println(cashOutDao.queryBySubItem(1, 1));
	}
}
