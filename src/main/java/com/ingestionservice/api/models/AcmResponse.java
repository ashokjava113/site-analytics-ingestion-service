package com.ingestionservice.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ingestionservice.api.models.AcmResponseBody;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AcmResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-19T16:57:57.183235500+05:30[Asia/Calcutta]")
public class AcmResponse   {
  @JsonProperty("statusCode")
  private Integer statusCode = null;

  @JsonProperty("statusMessage")
  private String statusMessage = null;

  @JsonProperty("errorMessages")
  @Valid
  private List<String> errorMessages = null;

  @JsonProperty("messages")
  @Valid
  private List<String> messages = null;

  @JsonProperty("results")
  @Valid
  private List<AcmResponseBody> results = null;

  public AcmResponse statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * Get statusCode
   * @return statusCode
  **/
  @ApiModelProperty(example = "200", value = "")
  
    public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  public AcmResponse statusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
    return this;
  }

  /**
   * Get statusMessage
   * @return statusMessage
  **/
  @ApiModelProperty(value = "")
  
    public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  public AcmResponse errorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
    return this;
  }

  public AcmResponse addErrorMessagesItem(String errorMessagesItem) {
    if (this.errorMessages == null) {
      this.errorMessages = new ArrayList<String>();
    }
    this.errorMessages.add(errorMessagesItem);
    return this;
  }

  /**
   * Get errorMessages
   * @return errorMessages
  **/
  @ApiModelProperty(value = "")
  
    public List<String> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }

  public AcmResponse messages(List<String> messages) {
    this.messages = messages;
    return this;
  }

  public AcmResponse addMessagesItem(String messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<String>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * Get messages
   * @return messages
  **/
  @ApiModelProperty(value = "")
  
    public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  public AcmResponse results(List<AcmResponseBody> results) {
    this.results = results;
    return this;
  }

  public AcmResponse addResultsItem(AcmResponseBody resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<AcmResponseBody>();
    }
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<AcmResponseBody> getResults() {
    return results;
  }

  public void setResults(List<AcmResponseBody> results) {
    this.results = results;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcmResponse acmResponse = (AcmResponse) o;
    return Objects.equals(this.statusCode, acmResponse.statusCode) &&
        Objects.equals(this.statusMessage, acmResponse.statusMessage) &&
        Objects.equals(this.errorMessages, acmResponse.errorMessages) &&
        Objects.equals(this.messages, acmResponse.messages) &&
        Objects.equals(this.results, acmResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusCode, statusMessage, errorMessages, messages, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcmResponse {\n");
    
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusMessage: ").append(toIndentedString(statusMessage)).append("\n");
    sb.append("    errorMessages: ").append(toIndentedString(errorMessages)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
