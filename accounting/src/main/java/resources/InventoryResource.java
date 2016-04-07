package resources;

import data.DummyTransactionDAO;
import data.TransactionDAO;
import models.InventoryRequest;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryResource {

    private TransactionDAO transactionDAO;

    @Inject
    public InventoryResource(TransactionDAO transactionDAO) {
        this.transactionDAO = new DummyTransactionDAO();
    }

    @POST
    public long post(InventoryRequest inventoryRequest) {
        return transactionDAO.purchaseInventory(inventoryRequest);
    }
}
