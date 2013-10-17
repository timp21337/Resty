package us.monoid.web;

import java.io.IOException;

/**
 * @author timp21337
 * @since 2103-10-15
 */
public class HttpIOException extends IOException {

  private String requestMethod;
  private int responseCode;
  private String responseMessage;
  private String content;

  public HttpIOException(String requestMethod, int responseCode,
                         String responseMessage, String content, IOException e) {
    super(e);
    this.requestMethod = requestMethod;
    this.responseCode = responseCode;
    this.responseMessage = responseMessage;
    this.content = content;
  }

  public String getRequestMethod() {
    return requestMethod;
  }
  public int getResponseCode() {
    return responseCode;
  }
  public String getResponseMessage() {
    return responseMessage;
  }
  public String getContent() {
    return content;
  }

  @Override
  public String getMessage() {
    return "Error while reading from " + getRequestMethod()
        + ": [" + getResponseCode() + "] "
        + getResponseMessage() + "\n"
        + getContent();
  }

  @Override
  public String toString() {
    return "HttpIOException{" +
        "requestMethod='" + requestMethod + '\'' +
        ", responseCode=" + responseCode +
        ", responseMessage='" + responseMessage + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}
