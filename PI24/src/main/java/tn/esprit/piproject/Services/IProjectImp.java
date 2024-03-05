package tn.esprit.piproject.Services;

import org.springframework.stereotype.Service;
import tn.esprit.piproject.Entities.*;
import tn.esprit.piproject.Repositories.*;
import tn.esprit.piproject.helpers.JavaMailSenderHelper;

import java.util.List;
import java.util.Optional;

@Service
public class IProjectImp implements IProjectService {

    private final OfferRepository offerRepository;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final InternshipRepository internshipRepository;
    private final DocumentsRepository documentsRepository;
    private final ComplaintRepository complaintRepository;
    private final ResponseRepository responseRepository;
    private final TaskRepository taskRepository;

    private final JavaMailSenderHelper mailSenderHelper;

    public IProjectImp(OfferRepository offerRepository, SequenceGeneratorService sequenceGeneratorService,
                       UserRepository userRepository, CompanyRepository companyRepository,
                       InternshipRepository internshipRepository, DocumentsRepository documentsRepository,
                       ComplaintRepository complaintRepository, ResponseRepository responseRepository,
                       TaskRepository taskRepository, JavaMailSenderHelper mailSenderHelper) {
        this.offerRepository = offerRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.internshipRepository = internshipRepository;
        this.documentsRepository = documentsRepository;
        this.complaintRepository = complaintRepository;
        this.responseRepository = responseRepository;
        this.taskRepository = taskRepository;
        this.mailSenderHelper = mailSenderHelper;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
/*********************************************************/
    @Override
    public List<Internship> getAllinternships() {
        return internshipRepository.findAll();
    }

    @Override
    public Optional<Internship> getinternshipById(int id) {
        return internshipRepository.findById(id);
    }

    @Override
    public Internship createInternship(Internship internship) {
        internship.setId(sequenceGeneratorService.generateSequence("documents_sequence"));
        return internshipRepository.save(internship);
    }

    @Override
    public Internship updateinternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    @Override
    public void deleteinternship(int id) {
        internshipRepository.deleteById(id);
    }
/****************************************************************/
    @Override
    public List<Documents> getAlldocuments() {
        return documentsRepository.findAll();
    }

    @Override
    public Optional<Documents> getdocumentsById(int id) {
        return documentsRepository.findById(id);
    }

    @Override
    public Documents createdocuments(Documents documents) {
        documents.setIdDoc(sequenceGeneratorService.generateSequence("documents_sequence"));
        return documentsRepository.save(documents);
    }





    @Override
    public Documents updatedocuments(Documents documents) {
        return documentsRepository.save(documents);
    }

    @Override
    public void deletedocuments(int id) {
        documentsRepository.deleteById(id);

    }
    /********************************************************************************/


    @Override
    public List<Company> getAllcompany() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getcompanyById(int idComp) {
        return companyRepository.findById(idComp);
    }

    @Override
    public Company createcompany(Company company) {
        company.setIdComp(sequenceGeneratorService.generateSequence("documents_sequence"));
        return companyRepository.save(company);
    }


    @Override
    public Company updatecompany(Company company) {return companyRepository.save(company);
    }

    @Override
    public void deletecompany(int idComp) {
        companyRepository.deleteById(idComp);
    }
/*************************************************************/
    @Override
    public List<Offer> getAllOffer() {
        return offerRepository.findAll();
    }

    @Override
    public Optional<Offer> getofferById(int id) {
        return offerRepository.findById(id);
    }

    @Override
    public Offer createoffer(Offer offer) {
        offer.setId(sequenceGeneratorService.generateSequence("documents_sequence"));
        return offerRepository.save(offer);
    }

    @Override
    public Offer updateoffer(Offer offer) {
        return offerRepository.save(offer);
    }



    @Override
    public void deleteoffer(int id) {
        offerRepository.deleteById(id);
    }
/******************************************************/
    @Override
    public List<Complaint> getAllComplaint() {
        return complaintRepository.findAll();
    }

    @Override
    public Optional<Complaint> getComplaintById(int idComp) {
        return complaintRepository.findById(idComp);
    }

    @Override
    public Complaint createComplaint(Complaint complaint) throws Exception {
        complaint.setIdComp(sequenceGeneratorService.generateSequence("documents_sequence"));
        String Subject = "Réclamation réçu";
        String msg = "Nous vous confirmons la réception de votre réclamation.\nNous mettons tout en œuvre pour la traiter dans les meilleurs délais.\n\nMerci pour votre compréhension et votre patience.";

        Complaint c = complaintRepository.save(complaint);
        mailSenderHelper.sendEmail(Subject, msg, complaint.getEmail());
        return c;
    }

    @Override
    public Complaint updateComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public void deleteComplaint(int id) {
        complaintRepository.deleteById(id);
    }


    /***************************************************/


    @Override
    public List<Response> getAllResponse() {
        return responseRepository.findAll();
    }

    @Override
    public Optional<Response> getResponseById(int id) {
        return responseRepository.findById(id);
    }

    @Override
    public Response createResponse(Response response) {
        response.setIdRep(sequenceGeneratorService.generateSequence("documents_sequence"));
        return responseRepository.save(response);
    }

    @Override
    public Response updateResponse(Response response) {
        return responseRepository.save(response);
    }

    @Override
    public void deleteResponse(int id) {
        responseRepository.deleteById(id);
    }

    /***********TASK SERVICE************/

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        task.setId(sequenceGeneratorService.generateSequence("documents_sequence"));
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
