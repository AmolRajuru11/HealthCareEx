/**
 * 
 */
package in.sahyandritech.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sahyandritech.healthcare.entity.Patient;

/**
 * @author Admin
 *
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
