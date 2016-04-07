package resources;

import data.DummyTransactionDAO;
import data.TransactionDAO;
import models.PayrollRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/payroll")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PayrollResource {

    private TransactionDAO transactionDAO;

    @Inject
    public PayrollResource(TransactionDAO transactionDAO) {
        this.transactionDAO = new DummyTransactionDAO();
    }

    @POST
    public long post(PayrollRequest payrollRequest) {
        return transactionDAO.payEmployee(payrollRequest);
    }
}
