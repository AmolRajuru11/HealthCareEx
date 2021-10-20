/**
 * 
 */
package in.sahyandritech.healthcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sahyandritech.healthcare.entity.Doctor;
import in.sahyandritech.healthcare.exception.DoctorNotFoundException;
import in.sahyandritech.healthcare.repo.DoctorRepository;
import in.sahyandritech.healthcare.service.IDoctorService;

/**
 * @author Admin
 *
 */
@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public Long saveDoctor(Doctor doc) {
		return doctorRepository.save(doc).getId();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public void removeDoctor(Long id) {
		doctorRepository.delete(getOneDoctor(id));
	}

	@Override
	public Doctor getOneDoctor(Long id) {
		return doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException(id + ", not exist"));
	}

	@Override
	public void updateDoctor(Doctor doc) {
		if (doctorRepository.existsById(doc.getId()))
			doctorRepository.save(doc);
		else
			throw new DoctorNotFoundException(doc.getId() + ", not exist");

	}

}
