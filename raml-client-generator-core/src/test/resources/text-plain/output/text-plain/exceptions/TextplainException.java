
package text-plain.exceptions;


public class TextplainException
    extends RuntimeException
{

    private int statusCode;
    private String reason;

    public TextplainException(int statusCode, String reason) {
        this.statusCode = statusCode;
        this.reason = reason;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getReason() {
        return this.reason;
    }

}
