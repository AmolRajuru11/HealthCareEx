/**
 * 
 */
package in.sahyandritech.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sahyandritech.healthcare.entity.Patient;
import in.sahyandritech.healthcare.service.IPatientService;

/**
 * @author Admin
 *
 */
@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private IPatientService patientService;

	@GetMapping("/register")
	public String registerPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "PatientRegister";
	}

	@PostMapping("/save")
	public String savePatient(@ModelAttribute Patient patient, Model model) {
		Long id = patientService.savePatient(patient);
		model.addAttribute("message", "Patient created with id:" + id);
		model.addAttribute("patient", new Patient());
		return "PatientRegister";
	}

	@GetMapping("/all")
	public String getAllPatient(Model model, @RequestParam(value = "message", required = false) String message) {
		List<Patient> list = patientService.getAllPatients();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "PatientData";
	}

}
