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

import com.Group_H.Dao.ProfileDao;
import com.Group_H.Model.Profile;

/* Date -@ 6th December 2021 
Author - @Parth,@Ashesh,@Krishna,@Shivangi,@Kaushik
Description - It include the flow to access data of Profile of user*/

@Controller
public class ProfileController {

	@Autowired
	ProfileDao dao;

	@RequestMapping("/Profile")
	public String showform(Model m) {
		m.addAttribute("command", new Profile());

		return "/profile/Profile";
	}

	@RequestMapping(value = "/saveprofile", method = RequestMethod.POST)
	public String saveprofile(@ModelAttribute("pf") Profile pf, HttpSession session) {

		dao.Addprofile(pf, session);
		return "redirect:/Profile";
	}

	@RequestMapping("/ViewProfile")
	public String viewBooking(Model m, HttpSession session) {
		List<Profile> profile = dao.getProfile(session);
		m.addAttribute("list", profile);
		return "/profile/ViewProfile";
	}

	@RequestMapping(value = "/editProfile/{id}")
	public String edit(@PathVariable int id, Model m) {
		Profile bk = dao.getProfileById(id);

		m.addAttribute("command", bk);
		return "/profile/EditProfile";
	}

	@RequestMapping(value = "/editsaveprofile", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("bk") Profile bk) {

		dao.UpdateProfile(bk);
		return "redirect:/ViewProfile";
	}

}
