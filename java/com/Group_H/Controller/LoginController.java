package com.Group_H.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Group_H.Dao.LoginDao;
import com.Group_H.Model.Login;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
Description - It include the flow to access data with of user credentials in order to validate user*/

@Controller
public class LoginController {

	@Autowired
	LoginDao ldao;

	@RequestMapping("/Login")
	public String showLogin(Model m) {
		m.addAttribute("command", new Login());
		return "Login";
	}

	@RequestMapping("/Home")
	public String showHome() {

		return "Home";
	}

	@RequestMapping("/Register")
	public String showform(Model m) {
		m.addAttribute("command", new Login());
		return "Register";
	}

	@RequestMapping(value = "/saveregister", method = RequestMethod.POST)
	public String save(@ModelAttribute("pub") Login pub) {

		String pass = pub.getPassword();
		String conf_pass = pub.getConf_password();
		if (pass.equals(conf_pass)) {
			ldao.AddRegister(pub);
			return "redirect:/Login";
		} else {
			return "redirect:/Register";
		}

	}

	@RequestMapping(value = "/loginauthentication", method = RequestMethod.POST)
	public String login(@ModelAttribute("pub") Login pub, HttpSession session) {
		String n = "";
		String usr = pub.getUser_name();
		String pass = pub.getPassword();

		List<Login> list = ldao.getregisters();
		for (int i = 0; i < list.size(); i++) {
			if (usr.equals(list.get(i).getUser_name()) && pass.equals(list.get(i).getPassword())) {
				Login l = ldao.getId(usr);
				int Login_id = l.getLogin_id();

				session.setAttribute("usr", usr);
				session.setAttribute("Login_id", Login_id);
				n = "Home";
				break;
			} else {
				n = "redirect:/Login";
			}
		}

		return n;
	}

	@RequestMapping("/Logout")
	public String Logout(Model m, HttpSession session) {
		session.removeAttribute("usr");
		m.addAttribute("command", new Login());
		return "Login";
	}

	@RequestMapping("Final_Project/Logout")
	public String Logout1(Model m, HttpSession session) {

		session.invalidate();
		m.addAttribute("command", new Login());
		return "Login";
	}

}
