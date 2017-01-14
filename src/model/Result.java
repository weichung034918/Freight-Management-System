package model;


public class Result {
    private String message;
    private Object object;

    public Result(String message, Object object) {
        System.out.println("Result:"+message);
        this.message = message;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
