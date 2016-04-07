import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import data.TransactionDAO;
import org.skife.jdbi.v2.DBI;

/**
 * Anything that needs to be provided by dependency injection will get provided
 * through here.  Whenever the @Inject annotation appears (e.g. in a resource
 * class), DropWizard will search the modules for @Provides methods that are of
 * the given type or that share an @Named string.
 */
public class AccountingModule implements Module {

    private DBI jdbi;

    @Override
    public void configure(Binder binder) {}

    public void setJdbi(DBI jdbi) {
        this.jdbi = jdbi;
    }

    @Provides
    public TransactionDAO providesTransactionDAO() {
        return jdbi.onDemand(TransactionDAO.class);
    }
}
