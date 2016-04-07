package data;

import data.TransactionDAO;
import models.InventoryRequest;
import models.PayrollRequest;
import models.SaleRequest;
import models.Transaction;

// This is a dummy class.  The actual implementation will be written in sql in the interface.
public class DummyTransactionDAO implements TransactionDAO {

    @Override
    public long makeSale(SaleRequest saleRequest) {
        return 0;
    }

    @Override
    public Transaction get(long id) {
        return new Transaction(id);
    }

    @Override
    public long payEmployee(PayrollRequest payrollRequest) {
        return 1;
    }

    @Override
    public long purchaseInventory(InventoryRequest inventoryRequest) {
        return 2;
    }
}
