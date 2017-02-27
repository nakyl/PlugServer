package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlugAndStatus
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-02-27T16:23:55.894Z")
public class PlugAndStatus {
  @SerializedName("status")
  private String status = null;

  @SerializedName("deviceID")
  private String deviceID = null;

  public PlugAndStatus status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(example = "true", required = true, value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public PlugAndStatus deviceID(String deviceID) {
    this.deviceID = deviceID;
    return this;
  }

   /**
   * Get deviceID
   * @return deviceID
  **/
  @ApiModelProperty(example = "DSDFERSSASDF", required = true, value = "")
  public String getDeviceID() {
    return deviceID;
  }

  public void setDeviceID(String deviceID) {
    this.deviceID = deviceID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlugAndStatus plugAndStatus = (PlugAndStatus) o;
    return Objects.equals(this.status, plugAndStatus.status) &&
        Objects.equals(this.deviceID, plugAndStatus.deviceID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, deviceID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlugAndStatus {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    deviceID: ").append(toIndentedString(deviceID)).append("\n");
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

