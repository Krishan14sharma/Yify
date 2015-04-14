
package mvp.dagger.yify.yify.model.register;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Meta {

    @SerializedName("server_time")
    @Expose
    private Integer serverTime;
    @SerializedName("server_timezone")
    @Expose
    private String serverTimezone;
    @SerializedName("api_version")
    @Expose
    private Integer apiVersion;
    @SerializedName("execution_time")
    @Expose
    private String executionTime;

    /**
     * 
     * @return
     *     The serverTime
     */
    public Integer getServerTime() {
        return serverTime;
    }

    /**
     * 
     * @param serverTime
     *     The server_time
     */
    public void setServerTime(Integer serverTime) {
        this.serverTime = serverTime;
    }

    /**
     * 
     * @return
     *     The serverTimezone
     */
    public String getServerTimezone() {
        return serverTimezone;
    }

    /**
     * 
     * @param serverTimezone
     *     The server_timezone
     */
    public void setServerTimezone(String serverTimezone) {
        this.serverTimezone = serverTimezone;
    }

    /**
     * 
     * @return
     *     The apiVersion
     */
    public Integer getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * @param apiVersion
     *     The api_version
     */
    public void setApiVersion(Integer apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * 
     * @return
     *     The executionTime
     */
    public String getExecutionTime() {
        return executionTime;
    }

    /**
     * 
     * @param executionTime
     *     The execution_time
     */
    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

}
