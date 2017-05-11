package connection;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 * Vytvori spojenie so serverom
 * @author Peter Ocelik
 *
 */
public class Connection {
	
	private Context remoteEjb;
	private Logger LOG = Logger.getLogger("connection.Connection");
	private FileHandler fh;
	
	public Connection() {
		
		try {  
	        fh = new FileHandler("etc/mylog.log");  
	        LOG.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        LOG.info("ACCESS TO REMOTE BEAN");  

	    } catch (SecurityException e) { 
	    	LOG.log(Level.SEVERE, "ERROR", e);
	    } catch (IOException e) {
	    	LOG.log(Level.SEVERE, "ERROR", e);
	    }  

		
		createRemoteEjbContext("localhost", "8080");
	}
	
	/**
	 * Prida nastavenia serveru
	 * @param host
	 * @param port
	 */
	private void createRemoteEjbContext(String host, String port) {
		
		Hashtable<Object, Object> props = new Hashtable<Object, Object>();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		props.put("jboss.naming.client.ejb.context", false);
		props.put("org.jboss.ejb.client.scoped.context", true);
 
		props.put("endpoint.name", "client-endpoint");
		props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
		props.put("remote.connections", "default");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
 
        props.put(Context.PROVIDER_URL, "http-remoting://" + host + ":" + port);
        props.put("remote.connection.default.host", host);
        props.put("remote.connection.default.port", port);
 
        try {
			this.remoteEjb = new InitialContext(props);
		} catch (NamingException e) {
			LOG.log(Level.SEVERE, "ERROR", e);
		}
    }
	
	public Context getRemoteEjbContext() {
		return remoteEjb;
	}

}
