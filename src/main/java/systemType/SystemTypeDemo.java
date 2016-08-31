package systemType;

public class SystemTypeDemo {

	public static void main(String[] args) {
		System.out.println( System.getProperty("os.name") );  
	    System.out.println( System.getProperty("os.version") );  
	    System.out.println( System.getProperty("os.arch") );
	    System.out.println(System.getProperty("file.separator") );

	}

    public static boolean isWindows(){
        boolean result = false;
        if (System.getProperty("os.name").indexOf("Windows") != -1) {
            result = true;
        }
        return result;
    }

}
