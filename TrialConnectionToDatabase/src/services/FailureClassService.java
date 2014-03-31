package services;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.jws.WebService;

import entities.FailureClass;

//@WebService
@Local
public interface FailureClassService {

    public List<FailureClass> getFailureClasses() ;
    public void addToFailureClasses(FailureClass failureClass);
    
}
