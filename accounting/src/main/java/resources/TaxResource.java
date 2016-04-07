package resources;

import data.DummyTransactionDAO;
import data.TransactionDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/tax")
@Produces(MediaType.APPLICATION_JSON)
public class TaxResource {

    private TransactionDAO transactionDAO;

    @Inject
    public TaxResource(TransactionDAO transactionDAO) {
        this.transactionDAO = new DummyTransactionDAO();
    }

    @GET
    @Path("/sales/{salePrice}")
    public double get(@PathParam("salePrice") double salePrice) {
        return salePrice*1.08;
    }
}
