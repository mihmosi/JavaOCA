package day0.JmProjects;

public class GetCallerClassAndMethodName {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElement = new Throwable().getStackTrace();
        if (stackTraceElement.length >= 3) {
            return stackTraceElement[2].getClassName() + "#" + stackTraceElement[2].getMethodName();
        } else {
            return null;
        }
    }  
}

