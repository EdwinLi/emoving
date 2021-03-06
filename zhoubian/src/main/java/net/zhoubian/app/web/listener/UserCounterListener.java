package net.zhoubian.app.web.listener;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import net.zhoubian.app.model.Location;
import net.zhoubian.app.model.User;
import net.zhoubian.app.util.GridUtil;

import org.apache.log4j.Logger;


/**
 * UserCounterListener class used to count the current number
 * of active users for the applications.  Does this by counting
 * how many user objects are stuffed into the session.  It also grabs
 * these users and exposes them in the servlet context.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class UserCounterListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {
	private static Logger logger = Logger.getLogger(UserCounterListener.class);
    /**
     * Name of user counter variable
     */
    public static final String COUNT_KEY = "userCounter";
    /**
     * Name of users Set in the ServletContext
     */
    public static final String USERS_KEY = "userNames";
    /**
     * The default event we're looking to trap.
     */
    private transient ServletContext servletContext;
    private int counter;
    private Set<User> users;

    /**
     * Initialize the context
     * @param sce the event
     */
    public synchronized void contextInitialized(ServletContextEvent sce) {
        servletContext = sce.getServletContext();
        servletContext.setAttribute((COUNT_KEY), Integer.toString(counter));
    }

    /**
     * Set the servletContext, users and counter to null
     * @param event The servletContextEvent
     */
    public synchronized void contextDestroyed(ServletContextEvent event) {
        servletContext = null;
        users = null;
        counter = 0;
    }

    synchronized void incrementUserCounter() {
        counter = Integer.parseInt((String) servletContext.getAttribute(COUNT_KEY));
        counter++;
        servletContext.setAttribute(COUNT_KEY, Integer.toString(counter));
    }

    synchronized void decrementUserCounter() {
        int counter = Integer.parseInt((String) servletContext.getAttribute(COUNT_KEY));
        counter--;

        if (counter < 0) {
            counter = 0;
        }

        servletContext.setAttribute(COUNT_KEY, Integer.toString(counter));
    }

    @SuppressWarnings("unchecked")
    synchronized void addUsername(User user) {
        users = (Set) servletContext.getAttribute(USERS_KEY);

        if (users == null) {
            users = new LinkedHashSet<User>();
        }
        logger.debug("users.contains(user):" + users.contains(user));
        if (!users.contains(user)) {
            users.add(user);
            servletContext.setAttribute(USERS_KEY, users);
            incrementUserCounter();
        }
        logger.debug("users:" + users.size());
    }

    @SuppressWarnings("unchecked")
	synchronized void removeUsername(User user) {
        users = (Set) servletContext.getAttribute(USERS_KEY);

        if (users != null) {
            users.remove(user);
        }

        servletContext.setAttribute(USERS_KEY, users);
        decrementUserCounter();
    }

    /**
     * This method is designed to catch when user's login and record their name
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
     * @param event the event to process
     */
    public void attributeAdded(HttpSessionBindingEvent event) {
//    	TODO
    	logger.debug("attributeAdded");
    	logger.debug("event name:" + event.getName() + " source:" + event.getSource() + " value:" + event.getValue());
    	if(event.getName().equals("user")){
    		addUsername((User)event.getValue());
    	}
    }

    /**
     * When user's logout, remove their name from the hashMap
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
     * @param event the session binding event
     */
    public void attributeRemoved(HttpSessionBindingEvent event) {
//    	TODO
    	logger.debug("attributeRemoved");
    	logger.debug("event name:" + event.getName() + " source:" + event.getSource() + " value:" + event.getValue());
    	if(event.getName().equals("user")){
    		removeUsername((User)event.getValue());
    	}
    }

    /**
     * Needed for Acegi Security 1.0, as it adds an anonymous user to the session and
     * then replaces it after authentication. http://forum.springframework.org/showthread.php?p=63593
     * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
     * @param event the session binding event
     */
    public void attributeReplaced(HttpSessionBindingEvent event) {
//    	TODO
    }

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		logger.debug("UserCounterListener sessionDestroyed");
//		HttpSession httpSession = se.getSession();
//		logger.debug("httpSession:" + httpSession.getId());
//		Location location = (Location) httpSession.getAttribute("location");
//		if(location == null){
//			return;
//		}
//		long code = GridUtil.getOwnGridCode(location.getLatitude(), location.getLongitude());
//		CustomSSManager.bt.delete(code, httpSession.getId());
		logger.debug("UserCounterListener sessionDestroyed end");
	}
}
