/**
 * 
 */
package in.sahyandritech.healthcare.service;

import java.util.List;
import java.util.Map;

import in.sahyandritech.healthcare.entity.Specialization;

/**
 * @author Admin
 *
 */
public interface ISpecializationService {

	public Long saveSpecialization(Specialization spec);

	public List<Specialization> getAllSpecialization();

	public void removeSpecialization(Long id);

	public Specialization getOneSpecialization(Long id);

	public void updateSpecialization(Specialization spec);

	public boolean isSpecCodeExist(String specCode);

	public boolean isSpecNameExist(String specName);

	public boolean isSpecCodeExistForEdit(String specCode, Long id);

	public boolean isSpecNameExistForEdit(String specName, Long id);
	
	Map<Long, String> getSpecIdAndName();

}
