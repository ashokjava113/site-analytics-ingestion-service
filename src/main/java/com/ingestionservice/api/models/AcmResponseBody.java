package com.ingestionservice.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AcmResponseBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-19T16:57:57.183235500+05:30[Asia/Calcutta]")
public class AcmResponseBody   {
  @JsonProperty("accessGranted")
  private Boolean accessGranted = false;

  @JsonProperty("message")
  private String message = null;

  public AcmResponseBody accessGranted(Boolean accessGranted) {
    this.accessGranted = accessGranted;
    return this;
  }

  /**
   * Get accessGranted
   * @return accessGranted
  **/
  @ApiModelProperty(example = "true", value = "")
  
    public Boolean isAccessGranted() {
    return accessGranted;
  }

  public void setAccessGranted(Boolean accessGranted) {
    this.accessGranted = accessGranted;
  }

  public AcmResponseBody message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(example = "Document Approved", value = "")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcmResponseBody acmResponseBody = (AcmResponseBody) o;
    return Objects.equals(this.accessGranted, acmResponseBody.accessGranted) &&
        Objects.equals(this.message, acmResponseBody.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessGranted, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcmResponseBody {\n");
    
    sb.append("    accessGranted: ").append(toIndentedString(accessGranted)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
