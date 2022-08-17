package com.spring.Hospital.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.Hospital.entity.Appointment;
import com.spring.Hospital.entity.Admin;

import com.spring.Hospital.service.AdminServiceImplementation;
import com.spring.Hospital.service.AppointmentServiceImplementation;

@Controller
@RequestMapping("/user")
public class UserController {

	private AppointmentServiceImplementation appointmentServiceImplementation;
	private AdminServiceImplementation adminServiceImplementation;

	@Autowired
	public UserController(AppointmentServiceImplementation obj1, AdminServiceImplementation obj) {
		appointmentServiceImplementation = obj1;
		adminServiceImplementation = obj;

	}

	@GetMapping("/index")

	public String index(Model model) {

		String username = "";

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {

			username = ((UserDetails) principal).getUsername();

			String Pass = ((UserDetails) principal).getPassword();

			System.out.println("One + " + username + "   " + Pass);

		} else {

			username = principal.toString();

			System.out.println("Two + " + username);

		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		Appointment appointment = new Appointment();

		appointment.setName(admin.getFirstName() + " " + admin.getLastName());

		appointment.setEmail(admin.getEmail());

		model.addAttribute("app", appointment);

		return "user/index";

	}

	@PostMapping("/save-app")
	public String saveEmploye(@ModelAttribute("app") Appointment obj) {

		Date date = new Date();
		obj.setRegtime(date.toString());
		appointmentServiceImplementation.save(obj);
		return "redirect:/user/index";
	}

	@GetMapping("/about")
	public String about(Model model) {
		Appointment obj = new Appointment();
		model.addAttribute("app", obj);

		return "user/about";
	}

	@GetMapping("/blog-single")
	public String bs(Model model) {
		Appointment obj = new Appointment();
		model.addAttribute("app", obj);
		return "user/blog-single";
	}

	@GetMapping("/blog")
	public String blog(Model model) {
		Appointment obj = new Appointment();
		model.addAttribute("app", obj);

		return "user/blog";
	}

	@GetMapping("/contact")
	public String contact(Model model) {
		Appointment obj = new Appointment();
		model.addAttribute("app", obj);

		return "user/contact";
	}

	@GetMapping("/department-single")
	public String d(Model model) {
		model.addAttribute("app", new Appointment());
		return "user/department-single";
	}

	@GetMapping("/departments")
	public String dep(Model model) {
		Appointment obj = new Appointment();
		model.addAttribute("app", obj);
		return "user/departments";
	}

	@GetMapping("/doctor")
	public String doctor(Model model) {
		Appointment obj = new Appointment();
		model.addAttribute("app", obj);
		return "user/doctor";
	}

	@RequestMapping("/showapp")

	public String appointments(Model model) {

		String username = "";

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {

			username = ((UserDetails) principal).getUsername();

			String Pass = ((UserDetails) principal).getPassword();

			System.out.println("One + " + username + "   " + Pass);

		} else {

			username = principal.toString();

			System.out.println("Two + " + username);

		}

		List<Appointment> list = appointmentServiceImplementation.findByEmail(username);

		// add to the spring model

		model.addAttribute("app", list);

		return "user/showapp";

	}
}