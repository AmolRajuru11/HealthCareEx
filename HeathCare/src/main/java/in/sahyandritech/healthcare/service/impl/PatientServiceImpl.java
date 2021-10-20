/**
 * 
 */
package in.sahyandritech.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.sahyandritech.healthcare.entity.Patient;
import in.sahyandritech.healthcare.repo.PatientRepository;
import in.sahyandritech.healthcare.service.IPatientService;

/**
 * @author Admin
 *
 */
@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Override
	@Transactional
	public Long savePatient(Patient patient) {
		return patientRepo.save(patient).getId();
	}

	@Override
	@Transactional
	public void updatePatient(Patient patient) {
		patientRepo.save(patient);
	}

	@Override
	@Transactional
	public void deletePatient(Long id) {
		patientRepo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Patient getOnePatient(Long id) {
		return patientRepo.findById(id).get();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Patient> getAllPatients() {
		return patientRepo.findAll();
	}

}
