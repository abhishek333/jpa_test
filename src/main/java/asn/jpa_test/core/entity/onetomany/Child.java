/**
 * 
 */
package asn.jpa_test.core.entity.onetomany;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import asn.jpa_test.core.entity.BaseEntity;

/**
 * @author Abhishek
 *
 */
@Entity
public class Child extends BaseEntity {
	
	private String name;
	
	@ManyToOne
	private Parent parent;
	
	public Child(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	
}
