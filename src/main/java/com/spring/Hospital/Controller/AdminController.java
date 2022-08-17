package com.spring.Hospital.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.Hospital.entity.Admin;
import com.spring.Hospital.entity.Appointment;
import com.spring.Hospital.entity.User;
import com.spring.Hospital.repository.AppointmentRepository;
import com.spring.Hospital.repository.UserRepository;
import com.spring.Hospital.service.AdminServiceImplementation;
import com.spring.Hospital.service.AppointmentServiceImplementation;
import com.spring.Hospital.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private AdminServiceImplementation adminServiceImplementation;

	private AppointmentServiceImplementation appointmentServiceImplementation;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	public AdminController(UserService userService, AdminServiceImplementation obj,
			AppointmentServiceImplementation app) {
		adminServiceImplementation = obj;
		appointmentServiceImplementation = app;
	}

	@RequestMapping("/user-details")
	public String index(Model model) {

		List<Admin> list = adminServiceImplementation.findByRole("ROLE_USER");
		model.addAttribute("user", list);

		// get last seen
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

		adminServiceImplementation.save(admin);

		return "admin/user";
	}

	@RequestMapping("/doctor-details")
	public String doctorDetails(Model model) {

		// get last seen
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

		adminServiceImplementation.save(admin);

		List<Admin> list = adminServiceImplementation.findByRole("ROLE_DOCTOR");

		// add to the spring model
		model.addAttribute("user", list);

		return "admin/doctor";
	}

	@RequestMapping("/admin-details")
	public String adminDetails(Model model) {

		// get last seen
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

		adminServiceImplementation.save(admin);

		List<Admin> list = adminServiceImplementation.findByRole("ROLE_ADMIN");

		// add to the spring model
		model.addAttribute("user", list);

		return "admin/admin";
	}

	@GetMapping("/add-doctor")
	public String showFormForAdd(Model theModel) {

		// get last seen
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

		Admin admin1 = adminServiceImplementation.findByEmail(username);

		adminServiceImplementation.save(admin1);

		// create model attribute to bind form data
		Admin admin = new Admin();

		theModel.addAttribute("doctor", admin);

		return "admin/addDoctor";
	}

	@GetMapping("/add-patient")
	public String showFormForPat(Model theModel) {

		// get last seen
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

		Admin admin1 = adminServiceImplementation.findByEmail(username);

		adminServiceImplementation.save(admin1);

		// create model attribute to bind form data
		Admin admin = new Admin();

		theModel.addAttribute("doctor", admin);

		return "admin/addPatient";
	}

	@PostMapping("/save-patient")
	public String savepatient(@ModelAttribute("doctor") Admin admin) {

		admin.setRole("ROLE_USER");

		admin.setPassword("default");

		admin.setEnabled(true);

		System.out.println(admin);

		adminServiceImplementation.save(admin);

		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/user-details";
	}

	@PostMapping("/save-doctor")
	public String saveEmployee(@ModelAttribute("doctor") Admin admin) {
		admin.setRole("ROLE_DOCTOR");

		admin.setPassword("default");

		admin.setEnabled(true);

		System.out.println(admin);

		adminServiceImplementation.save(admin);

		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/doctor-details";
	}

	@GetMapping("/add-admin")
	public String showForm(Model theModel) {

		// get last seen
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

		Admin admin1 = adminServiceImplementation.findByEmail(username);

		adminServiceImplementation.save(admin1);

		// create model attribute to bind form data
		Admin admin = new Admin();

		theModel.addAttribute("doctor", admin);

		return "admin/addAdmin";
	}

	@PostMapping("/save-admin")
	public String saveEmploye(@ModelAttribute("doctor") Admin admin) {

		admin.setRole("ROLE_ADMIN");

		admin.setPassword("default");

		admin.setEnabled(true);

		System.out.println(admin);

		adminServiceImplementation.save(admin);

		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/admin-details";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		Optional<User> user = this.userRepository.findById(id);

		User user1 = user.get();

		this.userRepository.delete(user1);

		return "redirect:/admin/user-details";

	}

	@GetMapping("/deleteApp/{id}")
	public String deleteApp(@PathVariable("id") Integer id) {
		Optional<Appointment> appointment = this.appointmentRepository.findById(id);

		Appointment appointment1 = appointment.get();

		this.appointmentRepository.delete(appointment1);

		return "redirect:/admin/appointments";

	}

	@GetMapping("/edit-my-profile")
	public String EditForm(Model theModel) {

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

		// get the employee from the service

		Admin admin = adminServiceImplementation.findByEmail(username);

		adminServiceImplementation.save(admin);

		System.out.println(admin);

		theModel.addAttribute("profile", admin);

		return "admin/updateMyProfile";
	}

	@PostMapping("/edit-patient/{id}")
	public String EditPatient(@PathVariable("id") Long id, Model theModel) {

		User user = this.userRepository.findById(id).get();
		theModel.addAttribute("user", user);

		return "admin/sucess";
	}

	@PostMapping("/update-patient")
	public String updatePatient(@ModelAttribute("user") User user) {

		System.out.println(user);

		userRepository.save(user);

		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/user-details";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("profile") Admin admin) {

		System.out.println(admin);

		adminServiceImplementation.save(admin);

		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/admin-details";
	}

	@RequestMapping("/appointments")
	public String appointments(Model model) {

		// get last seen
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

		adminServiceImplementation.save(admin);

		List<Appointment> list = appointmentServiceImplementation.findAll();

		// add to the spring model
		model.addAttribute("app", list);

		return "admin/appointment";
	}
}
