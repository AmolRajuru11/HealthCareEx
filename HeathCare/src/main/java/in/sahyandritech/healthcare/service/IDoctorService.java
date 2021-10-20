/**
 * 
 */
package in.sahyandritech.healthcare.service;

import java.util.List;

import in.sahyandritech.healthcare.entity.Doctor;

/**
 * @author Admin
 *
 */
public interface IDoctorService {

	public Long saveDoctor(Doctor doc);

	public List<Doctor> getAllDoctors();

	public void removeDoctor(Long id);

	public Doctor getOneDoctor(Long id);

	public void updateDoctor(Doctor doc);

}
