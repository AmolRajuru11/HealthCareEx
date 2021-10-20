/**
 * 
 */
package in.sahyandritech.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Admin
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor_tab")
public class Doctor {

	@Id
	@Column(name = "doctor_id_col")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "doctor_fn_col")
	private String firstName;

	@Column(name = "doctor_ln_col")
	private String lastName;

	@Column(name = "doctor_mail_col")
	private String email;

	@Column(name = "doctor_addr_col")
	private String address;

	@Column(name = "doctor_mob_col")
	private String mobile;

	@Column(name = "doctor_gen_col")
	private String gender;

	@Column(name = "doctor_note_col")
	private String note;

	@Column(name = "doc_img_col")
	private String photoLoc;

	// ----------Association Mapping-----------//
	@ManyToOne
	@JoinColumn(name = "spec_id_fk_col")
	private Specialization specialization; // HAS-A

}
