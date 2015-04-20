
package mvp.dagger.yify.yify.model.movie_list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    @Expose
    private int id;
    @Expose
    private String url;
    @SerializedName("imdb_code")
    @Expose
    private String imdbCode;
    @Expose
    private String title;
    @SerializedName("title_long")
    @Expose
    private String titleLong;
    @Expose
    private String slug;
    @Expose
    private int year;
    @Expose
    private double rating;
    @Expose
    private int runtime;
    @Expose
    private List<String> genres = new ArrayList<String>();
    @Expose
    private String language;
    @SerializedName("mpa_rating")
    @Expose
    private String mpaRating;
    @SerializedName("small_cover_image")
    @Expose
    private String smallCoverImage;
    @SerializedName("medium_cover_image")
    @Expose
    private String mediumCoverImage;
    @Expose
    private String state;
    @Expose
    private List<Torrent> torrents = new ArrayList<Torrent>();
    @SerializedName("date_uploaded")
    @Expose
    private String dateUploaded;
    @SerializedName("date_uploaded_unix")
    @Expose
    private int dateUploadedUnix;

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
     * @return The imdbCode
     */
    public String getImdbCode() {
        return imdbCode;
    }

    /**
     * @param imdbCode The imdb_code
     */
    public void setImdbCode(String imdbCode) {
        this.imdbCode = imdbCode;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The titleLong
     */
    public String getTitleLong() {
        return titleLong;
    }

    /**
     * @param titleLong The title_long
     */
    public void setTitleLong(String titleLong) {
        this.titleLong = titleLong;
    }

    /**
     * @return The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * @param slug The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * @return The year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year The year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return The rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating The rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return The runtime
     */
    public int getRuntime() {
        return runtime;
    }

    /**
     * @param runtime The runtime
     */
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    /**
     * @return The genres
     */
    public List<String> getGenres() {
        return genres;
    }

    /**
     * @param genres The genres
     */
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    /**
     * @return The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return The mpaRating
     */
    public String getMpaRating() {
        return mpaRating;
    }

    /**
     * @param mpaRating The mpa_rating
     */
    public void setMpaRating(String mpaRating) {
        this.mpaRating = mpaRating;
    }

    /**
     * @return The smallCoverImage
     */
    public String getSmallCoverImage() {
        return smallCoverImage;
    }

    /**
     * @param smallCoverImage The small_cover_image
     */
    public void setSmallCoverImage(String smallCoverImage) {
        this.smallCoverImage = smallCoverImage;
    }

    /**
     * @return The mediumCoverImage
     */
    public String getMediumCoverImage() {
        return mediumCoverImage;
    }

    /**
     * @param mediumCoverImage The medium_cover_image
     */
    public void setMediumCoverImage(String mediumCoverImage) {
        this.mediumCoverImage = mediumCoverImage;
    }

    /**
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return The torrents
     */
    public List<Torrent> getTorrents() {
        return torrents;
    }

    /**
     * @param torrents The torrents
     */
    public void setTorrents(List<Torrent> torrents) {
        this.torrents = torrents;
    }

    /**
     * @return The dateUploaded
     */
    public String getDateUploaded() {
        return dateUploaded;
    }

    /**
     * @param dateUploaded The date_uploaded
     */
    public void setDateUploaded(String dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    /**
     * @return The dateUploadedUnix
     */
    public int getDateUploadedUnix() {
        return dateUploadedUnix;
    }

    /**
     * @param dateUploadedUnix The date_uploaded_unix
     */
    public void setDateUploadedUnix(int dateUploadedUnix) {
        this.dateUploadedUnix = dateUploadedUnix;
    }

}
