/**
 * Eat2 - Concurrency coding
 *
 * has a subtle dead lock problem
 *
 *
 * The Fix: First you need to check to 
 *          see if the salt OR pepper is 
 *          available. Then check to see 
 *          if the salt is available before
 *          trying to grab it a second time.
 *          If you go for it a second time,
 *          then it will be considered "not
 *          available" to the same Diner2.
 *          If you check for the salt and its
 *          taken, but you are inside the 
 *          conditional, then you know the
 *          pepper is available, so you can 
 *          grab the pepper, season, and eat
 *          your food in peace.
 *
 *          P.S. I added an isAvailable() method.
 */
 
public class Eat2 {
    private static Spice2 salt;
    private static Spice2 pepper;

    public static void main(String[] args) {
	salt = new Spice2("salt");
	pepper = new Spice2("pepper");

	Diner2 peter = new Diner2("Peter", salt, pepper);
	Diner2 paul = new Diner2("Paul", salt, pepper);

	peter.start();
	paul.start();

	try {
	    peter.join();
	    paul.join();
	}
	catch (InterruptedException e) { 
	}
    }
}

class Spice2 {
    private String name;
    private boolean available = true;

    public Spice2(String name) { this.name = name; }
    public String getName() { return name; }

    //Method added to check availability.
    public boolean isAvailable() { return available; }
    
    synchronized public boolean grab(Diner2 diner) {
	System.out.println(""+diner.getName()+" grabbing "+this.getName());
	if (available) { 
	    available = false; 
	    System.out.println(""+diner.getName()+" got "+this.getName());
	    return true; 
	}
	else {
	    System.out.println(""+diner.getName()+" failed getting "+this.getName());
	    return false;
	}
    }
    synchronized public boolean release(Diner2 diner) {
	if (! available) { 
	    System.out.println(""+diner.getName()+" releasing "+this.getName());
	    available = true; 
	    return true; 
	}
	return false;
    }
    
}


class Diner2 extends Thread {
    Spice2 salt, pepper;
    java.util.Random gen;

    public Diner2(String name, Spice2 salt, Spice2 pepper) {
	super(name); 
	this.salt = salt;
	this.pepper = pepper;
	gen = new java.util.Random(System.currentTimeMillis());
    }

    public void sleep(int msecs) {
	try { Thread.sleep(msecs); }
	catch (InterruptedException e) { }
    }

    /*
     * Instead of all Diner objects always reaching for the salt first, let's
     * simulate where sometimes diners reach for the salt (maybe it's closer to them) and 
     * other times they might reach for the peper.
     */
    public void run() {
	boolean haveSalt = false, havePepper = false;

	System.out.println("" + this.getName() + ": trying to eat...");
	while (true) {
	    // Sometimes reach for salt first, sometimes pepper first
	    if (this.salt.isAvailable() || this.pepper.isAvailable()) {
		if (gen.nextBoolean() && salt.isAvailable()) {
		sleep(100+gen.nextInt(100));     // hand moves
		haveSalt = salt.grab(this);      // grab salt
		sleep(100+gen.nextInt(100));     // hand moves
		havePepper = pepper.grab(this);  // grab pepper
		}
		else {
		sleep(100+gen.nextInt(100));     // hand moves
		havePepper = pepper.grab(this);  // grab pepper
		sleep(100+gen.nextInt(100));     // hand moves
		haveSalt = salt.grab(this);      // grab salt
		}
	    }
	    if (haveSalt && havePepper) {
		System.out.println("" + this.getName() + ": seasoning...");
		sleep(500+gen.nextInt(500)); // random # 500-1000
		salt.release(this);
		pepper.release(this);

		System.out.println("" + this.getName() + ": eating...");
		sleep(1000+gen.nextInt(1000)); // ran # 1000-2000
	    }
	    else sleep(250);
	}
    }
}
