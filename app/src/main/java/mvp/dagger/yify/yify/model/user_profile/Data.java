package mvp.dagger.yify.yify.model.user_profile;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Data {

    @Expose
    private int id;
    @Expose
    private String username;
    @Expose
    private String email;
    @Expose
    private String group;
    @SerializedName("ip_address")
    @Expose
    private String ipAddress;
    @SerializedName("user_key")
    @Expose
    private String userKey;
    @Expose
    private String url;
    @SerializedName("profile_hidden")
    @Expose
    private boolean profileHidden;
    @SerializedName("about_text")
    @Expose
    private String aboutText;
    @SerializedName("small_avatar_image")
    @Expose
    private String smallAvatarImage;
    @SerializedName("medium_avatar_image")
    @Expose
    private String mediumAvatarImage;
    @SerializedName("date_joined")
    @Expose
    private String dateJoined;
    @SerializedName("date_joined_unix")
    @Expose
    private int dateJoinedUnix;
    @SerializedName("date_last_seen")
    @Expose
    private String dateLastSeen;
    @SerializedName("date_last_seen_unix")
    @Expose
    private int dateLastSeenUnix;

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
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
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return The group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group The group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * @return The ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress The ip_address
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return The userKey
     */
    public String getUserKey() {
        return userKey;
    }

    /**
     * @param userKey The user_key
     */
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The profileHidden
     */
    public boolean isProfileHidden() {
        return profileHidden;
    }

    /**
     * @param profileHidden The profile_hidden
     */
    public void setProfileHidden(boolean profileHidden) {
        this.profileHidden = profileHidden;
    }

    /**
     * @return The aboutText
     */
    public String getAboutText() {
        return aboutText;
    }

    /**
     * @param aboutText The about_text
     */
    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }

    /**
     * @return The smallAvatarImage
     */
    public String getSmallAvatarImage() {
        return smallAvatarImage;
    }

    /**
     * @param smallAvatarImage The small_avatar_image
     */
    public void setSmallAvatarImage(String smallAvatarImage) {
        this.smallAvatarImage = smallAvatarImage;
    }

    /**
     * @return The mediumAvatarImage
     */
    public String getMediumAvatarImage() {
        return mediumAvatarImage;
    }

    /**
     * @param mediumAvatarImage The medium_avatar_image
     */
    public void setMediumAvatarImage(String mediumAvatarImage) {
        this.mediumAvatarImage = mediumAvatarImage;
    }

    /**
     * @return The dateJoined
     */
    public String getDateJoined() {
        return dateJoined;
    }

    /**
     * @param dateJoined The date_joined
     */
    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    /**
     * @return The dateJoinedUnix
     */
    public int getDateJoinedUnix() {
        return dateJoinedUnix;
    }

    /**
     * @param dateJoinedUnix The date_joined_unix
     */
    public void setDateJoinedUnix(int dateJoinedUnix) {
        this.dateJoinedUnix = dateJoinedUnix;
    }

    /**
     * @return The dateLastSeen
     */
    public String getDateLastSeen() {
        return dateLastSeen;
    }

    /**
     * @param dateLastSeen The date_last_seen
     */
    public void setDateLastSeen(String dateLastSeen) {
        this.dateLastSeen = dateLastSeen;
    }

    /**
     * @return The dateLastSeenUnix
     */
    public int getDateLastSeenUnix() {
        return dateLastSeenUnix;
    }

    /**
     * @param dateLastSeenUnix The date_last_seen_unix
     */
    public void setDateLastSeenUnix(int dateLastSeenUnix) {
        this.dateLastSeenUnix = dateLastSeenUnix;
    }

}

