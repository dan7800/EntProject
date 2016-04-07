package data;

import models.InventoryRequest;
import models.PayrollRequest;
import models.SaleRequest;
import models.Transaction;

public interface TransactionDAO {

    // TODO sql should go in here in the form of an @SqlUpdate("INSERT...") annotation
    public long makeSale(SaleRequest saleRequest);

    public Transaction get(long id);

    public long payEmployee(PayrollRequest payrollRequest);

    public long purchaseInventory(InventoryRequest inventoryRequest);
}
