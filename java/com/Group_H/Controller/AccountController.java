package com.Group_H.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Group_H.Dao.AccountDao;
import com.Group_H.Model.Account;
import com.Group_H.Model.Bill;

import com.Group_H.Model.Profile;
import com.Group_H.Model.Transfer;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
Description - It include the flow to access data with account of user*/

@Controller
public class AccountController {

	@Autowired
	AccountDao adao;

	@RequestMapping("/CreateAccount")
	public String showform(Model m, HttpSession session) {
		m.addAttribute("command", new Account());
		int login_id = (Integer) session.getAttribute("Login_id");
		Profile prof = adao.getProfile(login_id);
		String acc_num = prof.getAcc_num();
		m.addAttribute("acc_num", acc_num);
		session.setAttribute("acc_num", acc_num);
		return "/Account/AddAccount";
	}

	@RequestMapping(value = "/saveaccount", method = RequestMethod.POST)
	public String saveaccount(@ModelAttribute("pf") Account acc, HttpSession session) {

		Profile prof = adao.getProfile((Integer) session.getAttribute("Login_id"));
		adao.AddAcc_type(acc, session, prof);
		return "Home";
	}

	@RequestMapping("/Accounts")
	public String viewAccounts(Model m, HttpSession session) {
		Profile prof = adao.getProfile((Integer) session.getAttribute("Login_id"));
		String acc_num = prof.getAcc_num();
		int profile_id = prof.getProfile_id();
		session.setAttribute("profile_id", profile_id);
		session.setAttribute("acc_num", acc_num);
		List<Account> acc = adao.getAccount(session);
		m.addAttribute("list", acc);
		return "/Account/Accounts";
	}

	@RequestMapping(value = "/Deposit/{id}")
	public String edit(@PathVariable int id, Model m) {

		Account bk = adao.getAccountDeposit(id);

		m.addAttribute("command", bk);
		return "/Account/Deposit";
	}

	@RequestMapping(value = "/Withdraw/{id}")
	public String withdrawdata(@PathVariable int id, Model m) {

		Account bk = adao.getAccountDeposit(id);

		m.addAttribute("command", bk);
		return "/Account/Withdraw";
	}

	@RequestMapping(value = "/Paybill/{id}")
	public String paybill(@PathVariable int id, Model m) {

		Account bk = adao.getAccountDeposit(id);

		m.addAttribute("command", bk);
		return "/Account/Bill";
	}

	@RequestMapping(value = "/Transfer/{id}")
	public String showTransfer(Model m) {
		m.addAttribute("command", new Transfer());
		return "/Account/Transfer";
	}

	@RequestMapping(value = "/savedeposit", method = RequestMethod.POST)
	public String savedeposit(@ModelAttribute("pf") Account acc, HttpSession session, Model m) {

		// Profile prof=adao.getProfile((Integer)session.getAttribute("Login_id"));
		adao.AddDeposit(acc);
		Profile prof = adao.getProfile((Integer) session.getAttribute("Login_id"));
		String acc_num = prof.getAcc_num();
		session.setAttribute("acc_num", acc_num);
		List<Account> acc1 = adao.getAccount(session);
		m.addAttribute("list", acc1);
		return "Account/Accounts";
	}

	@RequestMapping(value = "/savebill", method = RequestMethod.POST)
	public String AddBill(@ModelAttribute("pf") Account acc, HttpSession session, Model m) {

		// Profile prof=adao.getProfile((Integer)session.getAttribute("Login_id"));
		adao.AddBill(acc);
		Profile prof = adao.getProfile((Integer) session.getAttribute("Login_id"));
		String acc_num = prof.getAcc_num();
		session.setAttribute("acc_num", acc_num);
		List<Account> acc1 = adao.getAccount(session);
		m.addAttribute("list", acc1);
		return "Account/Accounts";
	}
	

	@RequestMapping(value = "/savewithdraw", method = RequestMethod.POST)
	public String savewithdraw(@ModelAttribute("pf") Account acc, HttpSession session, Model m) {

		// Profile prof=adao.getProfile((Integer)session.getAttribute("Login_id"));
		adao.AddWithdraw(acc);
		Profile prof = adao.getProfile((Integer) session.getAttribute("Login_id"));
		String acc_num = prof.getAcc_num();
		session.setAttribute("acc_num", acc_num);
		List<Account> acc1 = adao.getAccount(session);
		m.addAttribute("list", acc1);
		return "Account/Accounts";
	}

	@RequestMapping(value = "/saveTransfer", method = RequestMethod.POST)
	public String savetransfer(@ModelAttribute("pf") Transfer tr, HttpSession session, Model m) {
		String from = tr.getFrom();
		String to = tr.getTo();
		float temp_amt = tr.getAmt_temp();
		Account ac1 = adao.getSaving(session);
		Account ac2 = adao.getChequing(session);
		float sav_amt = ac1.getAcc_bal();
		float cheq_amt = ac2.getAcc_bal();
		if (from.equals("saving") && to.equals("chequing")) {
			sav_amt = sav_amt - temp_amt;
			cheq_amt = cheq_amt + temp_amt;
			adao.updateSaving(sav_amt, session);
			adao.updateChequing(cheq_amt, session);
		} else if (from.equals("chequing") && to.equals("saving")) {
			sav_amt = sav_amt + temp_amt;
			cheq_amt = cheq_amt - temp_amt;
			adao.updateSaving(sav_amt, session);
			adao.updateChequing(cheq_amt, session);
		} else {

		}
		List<Account> acc = adao.getAccount(session);
		m.addAttribute("list", acc);
		return "/Account/Accounts";
	}

	@RequestMapping(value = "/BillHistory/{id}")
	public String BillHistory(@PathVariable int id, Model m) {
		List<Bill> bk = adao.getBillHistory(id);

		m.addAttribute("command", bk);
		return "Account/BillHistory";
	}

}
