class Foo2
{
    public static void main(String [] args)
    {
	for (int i = 0; i < 5; i++){
	    int var = 1;
	    System.out.println(var + i); //Inside
	}
	System.out.println(var); //Outside
    }
}
