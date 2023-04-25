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
 * Files
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-19T16:57:57.183235500+05:30[Asia/Calcutta]")
public class Files   {
  @JsonProperty("accountFile")
  private String accountFile = null;

  @JsonProperty("accountCustomEventFile")
  private String accountCustomEventFile = null;

  public Files accountFile(String accountFile) {
    this.accountFile = accountFile;
    return this;
  }

  /**
   * Get accountFile
   * @return accountFile
  **/
  @ApiModelProperty(example = "GainsightPX_Accounts.json", value = "")
  
    public String getAccountFile() {
    return accountFile;
  }

  public void setAccountFile(String accountFile) {
    this.accountFile = accountFile;
  }

  public Files accountCustomEventFile(String accountCustomEventFile) {
    this.accountCustomEventFile = accountCustomEventFile;
    return this;
  }

  /**
   * Get accountCustomEventFile
   * @return accountCustomEventFile
  **/
  @ApiModelProperty(example = "GainsightPX_Account_Custom_Event.json", value = "")
  
    public String getAccountCustomEventFile() {
    return accountCustomEventFile;
  }

  public void setAccountCustomEventFile(String accountCustomEventFile) {
    this.accountCustomEventFile = accountCustomEventFile;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Files files = (Files) o;
    return Objects.equals(this.accountFile, files.accountFile) &&
        Objects.equals(this.accountCustomEventFile, files.accountCustomEventFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountFile, accountCustomEventFile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Files {\n");
    
    sb.append("    accountFile: ").append(toIndentedString(accountFile)).append("\n");
    sb.append("    accountCustomEventFile: ").append(toIndentedString(accountCustomEventFile)).append("\n");
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
