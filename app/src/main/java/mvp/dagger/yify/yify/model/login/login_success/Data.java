
package mvp.dagger.yify.yify.model.login.login_success;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Data {

    @Expose
    private String username;
    @Expose
    private String email;
    @SerializedName("user_key")
    @Expose
    private String userKey;

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The userKey
     */
    public String getUserKey() {
        return userKey;
    }

    /**
     * 
     * @param userKey
     *     The user_key
     */
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

}
