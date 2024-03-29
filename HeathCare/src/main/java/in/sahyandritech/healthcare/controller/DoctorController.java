/**
 * 
 */
package in.sahyandritech.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.sahyandritech.healthcare.entity.Doctor;
import in.sahyandritech.healthcare.exception.DoctorNotFoundException;
import in.sahyandritech.healthcare.service.IDoctorService;
import in.sahyandritech.healthcare.service.ISpecializationService;
import in.sahyandritech.healthcare.util.MyMailUtil;

/**
 * @author Admin
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private ISpecializationService specservice;

	@Autowired
	private MyMailUtil mailUtil;

	private void createDynamicUi(Model model) {
		model.addAttribute("specialization", specservice.getSpecIdAndName());
	}

	/**
	 * 1.Show Register page
	 */
	@GetMapping("/register")
	public String showRegister(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		createDynamicUi(model);
		return "DoctorRegister";
	}

	/**
	 * 2.On Submit form save data
	 */

	@PostMapping("/save")
	public String saveForm(@ModelAttribute Doctor doctor, RedirectAttributes attributes) {
		Long id = doctorService.saveDoctor(doctor);
		String message = "Doctor (" + id + ") is created";
		attributes.addAttribute("message", message);
		if (id != null) {
			new Thread(new Runnable() {
				public void run() {
					mailUtil.send(doctor.getEmail(), "SUCCESS", message,
							new ClassPathResource("/static/myres/sample.pdf"));
				}
			}).start();
		}
		return "redirect:register";
	}

	/**
	 * 3. Display all Doctor Records
	 */

	@GetMapping("/all")
	public String display(@RequestParam(value = "message", required = false) String message, Model model) {
		List<Doctor> list = doctorService.getAllDoctors();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "DoctorData";
	}

	/**
	 * Delete one record using id
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id, RedirectAttributes attributes) {
		String message = null;
		try {
			doctorService.removeDoctor(id);
			message = "(" + id + ") Doctor removed";
		} catch (DoctorNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		attributes.addAttribute("message", message);
		return "redirect:all";
	}

	/**
	 * show Edit page for doctor edit
	 */

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model, RedirectAttributes attributes) {
		String page = null;
		try {
			Doctor doc = doctorService.getOneDoctor(id);
			model.addAttribute("doctor", doc);
			createDynamicUi(model);
			page = "DoctorEdit";
		} catch (DoctorNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}

	/**
	 * Update doctor record
	 */

	@PostMapping("/update")
	public String doUpdate(@ModelAttribute Doctor doctor, RedirectAttributes attributes) {
		doctorService.updateDoctor(doctor);
		attributes.addAttribute("message", doctor.getId() + ", updated!");
		return "redirect:all";
	}
}
