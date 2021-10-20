/**
 * 
 */
package in.sahyandritech.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sahyandritech.healthcare.entity.Doctor;

/**
 * @author Admin
 *
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
