
package mvp.dagger.yify.yify.model.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ErrorWrapper {

    @Expose
    private String status;
    @SerializedName("status_message")
    @Expose
    private String statusMessage;
    @SerializedName("@meta")
    @Expose
    private Meta Meta;

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * @param statusMessage The status_message
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * @return The Meta
     */
    public Meta getMeta() {
        return Meta;
    }

    /**
     * @param Meta The @meta
     */
    public void setMeta(Meta Meta) {
        this.Meta = Meta;
    }

}
