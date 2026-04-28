package lab7;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;

    private String name;
    //7.6.2
    private static PasswordMaker instance;
    //7.6.2
    private static int callingCount = 0;

    private PasswordMaker(){
        this.name=" default";
    }
    //7.6.2 a
    public static PasswordMaker getInstance() {
        callingCount++;   //7.6.2 c
        if (instance == null) {
            instance = new PasswordMaker();
        }
        return instance;
    }
    //geter contor 7.6.2
    public static int getCallingCounts() {

        return callingCount;
    }

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
        instance = new PasswordMaker();
    }

    public PasswordMaker(String name) {
        this.name = name;
    }

    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = ""+name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}

