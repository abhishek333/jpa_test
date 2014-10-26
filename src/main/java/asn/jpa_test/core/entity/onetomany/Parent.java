/**
 * 
 */
package asn.jpa_test.core.entity.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import asn.jpa_test.core.entity.BaseEntity;

/**
 * @author Abhishek
 *
 */
@Entity
public class Parent extends BaseEntity {

	private String name;
	
	@OneToMany(mappedBy="parent", cascade=CascadeType.ALL)	
	private List<Child> childs;
	
	public Parent() {
		super();
	}

	public Parent(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getChilds() {
		return childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}
	
	
	
}
