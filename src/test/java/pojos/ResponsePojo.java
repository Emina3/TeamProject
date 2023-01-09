package pojos;

public class ResponsePojo {

    private  Integer responseCode;
    private String message;

    public ResponsePojo(Integer responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public ResponsePojo() {
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponsePojo{" +
                "responseCode=" + responseCode +
                ", message='" + message + '\'' +
                '}';
    }
}
