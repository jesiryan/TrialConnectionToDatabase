package dao;

import java.util.List;
import java.util.Collection;

import entities.FailureClass;

public interface FailureClassDAO {
	
	void addFailureClass(FailureClass failureClass);
	FailureClass getFailureClassById(String id);
	List<FailureClass> getFailureClassesByDescription(String description);
	List<FailureClass> getAllFailureClasses();

}
