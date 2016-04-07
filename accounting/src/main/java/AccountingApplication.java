import com.hubspot.dropwizard.guice.GuiceBundle;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;
import resources.*;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Mostly boilerplate code to get a DropWizard App going.  This class sets up
 * the connections for dependency injection and different modules that will
 * be used.
 *
 * To run, execute this class with program args:
 * server accounting.yaml
 *
 * The webservice will start on port 8080.
 */
public class AccountingApplication extends Application<AccountingConfiguration> {

    private GuiceBundle guiceBundle;
    private AccountingModule accountingModule;

    public static void main(String[] args) throws Exception {
        new AccountingApplication().run(args);
    }

    // Set up the module and get ready for injection with guice.
    @Override
    public void initialize(Bootstrap<AccountingConfiguration> bootstrap) {
        accountingModule = new AccountingModule();
        guiceBundle = GuiceBundle.<AccountingConfiguration>newBuilder()
                .addModule(accountingModule)
                .setConfigClass(AccountingConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    // The run method needs to set up the database connection and register the resources.
    @Override
    public void run(AccountingConfiguration accountingConfiguration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, accountingConfiguration.getDatabase(), "mysql");
        jdbi.registerMapper(new RosettaMapperFactory());

        accountingModule.setJdbi(jdbi);

        registerResources(environment, TransactionResource.class, SalesResource.class, TaxResource.class, PayrollResource.class, InventoryResource.class);

        // We probably won't need CORS since the domain will be the same, but it shouldn't hurt...
        // Enable CORS headers
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

    // Just an easy way to register all the resources without having to write
    // the same super-long line of code.
    private void registerResources(Environment environment, Class... resourceClasses) {
        for (Class resourceClass : resourceClasses) {
            // Grabs an instance of the resource class from the guice bundle
            // and registers it.
            environment.jersey().register(guiceBundle.getInjector().getInstance(resourceClass));
        }
    }
}
