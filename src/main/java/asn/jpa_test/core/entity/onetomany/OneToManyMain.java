/**
 * 
 */
package asn.jpa_test.core.entity.onetomany;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import asn.jpa_test.core.repository.ParentRepository;
import asn.jpa_test.core.services.IUserInfoServices;

/**
 * @author Abhishek
 *
 */
public class OneToManyMain {

	private ParentRepository parentRepository;
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		parentRepository = ctx.getBean(ParentRepository.class);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OneToManyMain otm = new OneToManyMain();
		Parent parent = new Parent("Abhishek");
		Child child1 = new Child("junior 1");
		Child child2 = new Child("junior 2");
		parent.setChilds(Arrays.asList(child1,child2));
		
		otm.save(parent);
		otm.printParent(1L);
		/*otm.getParent(1L);
		otm.update(parent);
		otm.delete(1L);*/
	}
	private void printParent(long id) {
		System.out.println(parentRepository.findOne(id));
	}
	
	@Transactional
	private void delete(long id) {
		parentRepository.delete(id);
	}
	
	@Transactional
	private Parent update(Parent parent) {
		Parent updatedParent = parentRepository.findOne(parent.getId());
		updatedParent.setName(parent.getName());
		updatedParent.getChilds().addAll(parent.getChilds());
		return updatedParent;
	}
	
	private Parent getParent(long id) {
		return parentRepository.findOne(id);
	}
	
	@Transactional
	private Parent save(Parent parent) {
		return parentRepository.save(parent);
	}

}
