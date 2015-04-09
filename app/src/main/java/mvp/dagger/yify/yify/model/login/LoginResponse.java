package mvp.dagger.yify.yify.model.login;

import com.google.gson.annotations.Expose;

/**
 * Created by HP LAPTOP on 30-11-2014.
 */
public class LoginResponse {

    @Expose
    private String userID;
    @Expose
    private String username;
    @Expose
    private String userRole;
    @Expose
    private String hash;

    /**
     * @return The userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID The userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole The userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return The hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash The hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

}
