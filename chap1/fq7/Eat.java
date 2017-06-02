/*
 * Eat - Concurrency coding
 *
 * Has a dead lock problem...
 *
 * The fix: Swapping Janes while loop arguments.
 *          This allows Jane to go after the salt
 *          at the same time as Mary, but Mary grabs
 *          the salt first because she was invoked first. 
 *          Mary then retrieves the pepper and tells 
 *          Jane to hold her horses... So now Mary 
 *          has both the salt and pepper and seasons
 *          her food. After Mary is finished with the
 *          salt and pepper and begins to eat, Jane 
 *          is able to snatch the salt and pepper.
 * 
 * I also added a delay at the beginning of Janes
 * run method to allow Mary to finish eating before
 * Jane tried to grab the salt and pepper.
 */
 
public class Eat {
    // The shared resources
    private static Spice salt;
    private static Spice pepper;

    
    public static void main(String[] args) {
	// Create the limited resources
	salt = new Spice("salt");
	pepper = new Spice("pepper");

	// Create the processes using the limited resources
	Mary mary = new Mary(salt, pepper);
	Jane jane = new Jane(salt, pepper);

	// Start the processes
	mary.start();
	jane.start();

	// Wait for the processes to finish
	try {
	    mary.join();
	    jane.join();
	}
	catch (InterruptedException e) { 
	    // Exception swallowed - PLEASE FIX THIS
	    System.out.println("Error: It's a trap!!!");
	}
    }
}

class Spice {
    private String name;
    private boolean available = true;

    public Spice(String name) { this.name = name; }
    public String getName() { return name; }

    synchronized public boolean grab(String diner) {
	System.out.println(""+diner+" grabbing "+this.getName());
	if (available) { 
	    available = false; 
	    System.out.println(""+diner+" got "+this.getName());
	    return true; 
	}
	else {
	    System.out.println(""+diner+" failed getting "+this.getName());
	    return false;
	}
    }
    synchronized public boolean release(String diner) {
	if (! available) { 
	    System.out.println(""+diner+" releasing "+this.getName());
	    available = true; 
	    return true; 
	}
	return false;
    }
}


class Mary extends Thread {
    Spice salt, pepper;  // references to singular objects created in main

    public Mary (Spice salt, Spice pepper) {
	this.salt = salt;
	this.pepper = pepper;
    }

    public void sleep(int msecs) {
	try { Thread.sleep(msecs); }
	catch (InterruptedException e) { }
    }
    public void run() {
	System.out.println("Mary: trying to eat...");
	while (true) {
	    // grab the salt first
	    while (! salt.grab("Mary") ) { sleep(250); }
	    // when have salt then grab pepper
	    while (! pepper.grab("Mary") ) { sleep(250); }

	    // Successfully grabbed both salt and pepper
	    System.out.println("Mary: seasoning...");
	    sleep(1000);
	    salt.release("Mary");
	    pepper.release("Mary");

	    System.out.println("Mary: eating...");
	    sleep(1000);
	}
    }
}

class Jane extends Thread {
    Spice salt, pepper;  // references to singular objects created in main

    public Jane(Spice salt, Spice pepper) {
	this.salt = salt;
	this.pepper = pepper;
    }

    public void sleep(int msecs) {
	try { Thread.sleep(msecs); }
	catch (InterruptedException e) { }
    }
    public void run() {
	sleep(1500);
	System.out.println("Jane: trying to eat...");
	while (true) {
	    while (! salt.grab("Jane") ) { sleep(250); }
	    while (! pepper.grab("Jane") ) { sleep(250); }

	    // Successfully grabbed both salt and pepper
	    System.out.println("Jane: seasoning...");
	    sleep(1000);
	    salt.release("Jane");
	    pepper.release("Jane");

	    System.out.println("Jane: eating...");
	    sleep(1000);
	}
    }
}
