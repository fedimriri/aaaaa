package tn.esprit.piproject.Services;

import java.util.List;
import java.util.Optional;

import tn.esprit.piproject.Entities.Company;
import tn.esprit.piproject.Entities.Complaint;
import tn.esprit.piproject.Entities.Documents;
import tn.esprit.piproject.Entities.Internship;
import tn.esprit.piproject.Entities.Offer;
import tn.esprit.piproject.Entities.Response;
import tn.esprit.piproject.Entities.Task;
import tn.esprit.piproject.Entities.User;

public interface IProjectService {
    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(int id);
/***********************OMAR******************************/
    List<Internship> getAllinternships();

    Optional<Internship> getinternshipById(int id);

    Internship createInternship(Internship internship);

    Internship updateinternship(Internship internship);

    void deleteinternship(int id);
/***************************OMAR****************************/
    List<Documents> getAlldocuments();

    Optional<Documents> getdocumentsById(int id);

    Documents createdocuments(Documents documents);

    Documents updatedocuments(Documents documents);

    void deletedocuments(int id);
    /********************************************/

    List<Company> getAllcompany();

    Optional<Company> getcompanyById(int idComp);

    Company createcompany(Company company);

    Company updatecompany(Company company);

    void deletecompany(int idComp);

/*****************************************/
    List<Offer> getAllOffer();

    Optional<Offer> getofferById(int id);

    Offer createoffer(Offer offer);

    Offer updateoffer(Offer offer);

    void deleteoffer(int id);
    /***************************************/

    List<Complaint> getAllComplaint();

    Optional<Complaint> getComplaintById(int id);

    Complaint createComplaint(Complaint complaint) throws Exception;

    Complaint updateComplaint(Complaint complaint);

    void deleteComplaint(int id);
/************************************/

    List<Response> getAllResponse();

    Optional<Response> getResponseById(int idRep);

    Response createResponse(Response response);

    Response updateResponse(Response response);

    void deleteResponse(int idRep);

    List<Task> getAllTasks();
    Optional<Task> getTaskById(int id);
    Task createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(int id);



}
