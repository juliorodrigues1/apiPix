package ms.pix.models;

public class ResponseToken{
    private String access_token;

    public ResponseToken(String access_token) {
        this.access_token = access_token;
    }

    public ResponseToken() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}

