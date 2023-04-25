package com.ingestionservice.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ingestionservice.api.models.Files;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AcmRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-19T16:57:57.183235500+05:30[Asia/Calcutta]")
public class AcmRequest   {
  @JsonProperty("applicationCode")
  private String applicationCode = null;

  @JsonProperty("files")
  @Valid
  private List<Files> files = null;

  public AcmRequest applicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
    return this;
  }

  /**
   * Get applicationCode
   * @return applicationCode
  **/
  @ApiModelProperty(example = "arinc", value = "")
  
    public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
  }

  public AcmRequest files(List<Files> files) {
    this.files = files;
    return this;
  }

  public AcmRequest addFilesItem(Files filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<Files>();
    }
    this.files.add(filesItem);
    return this;
  }

  /**
   * Get files
   * @return files
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Files> getFiles() {
    return files;
  }

  public void setFiles(List<Files> files) {
    this.files = files;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcmRequest acmRequest = (AcmRequest) o;
    return Objects.equals(this.applicationCode, acmRequest.applicationCode) &&
        Objects.equals(this.files, acmRequest.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationCode, files);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcmRequest {\n");
    
    sb.append("    applicationCode: ").append(toIndentedString(applicationCode)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
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
