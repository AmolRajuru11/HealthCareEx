/**
 * 
 */
package in.sahyandritech.healthcare.service;

import java.util.List;

import in.sahyandritech.healthcare.entity.Patient;

/**
 * @author Admin
 *
 */
public interface IPatientService {

	Long savePatient(Patient patient);

	void updatePatient(Patient patient);

	void deletePatient(Long id);

	Patient getOnePatient(Long id);

	List<Patient> getAllPatients();

}
