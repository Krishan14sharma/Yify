package mvp.dagger.yify.yify.model;

import com.google.gson.annotations.Expose;

public class MovieListItem {

    @Expose
    private String MovieID;
    @Expose
    private String State;
    @Expose
    private String MovieUrl;
    @Expose
    private String MovieTitle;
    @Expose
    private String MovieTitleClean;
    @Expose
    private String MovieYear;
    @Expose
    private String AgeRating;
    @Expose
    private String DateUploaded;
    @Expose
    private Integer DateUploadedEpoch;
    @Expose
    private String Quality;
    @Expose
    private String CoverImage;
    @Expose
    private String ImdbCode;
    @Expose
    private String ImdbLink;
    @Expose
    private String Size;
    @Expose
    private String SizeByte;
    @Expose
    private String MovieRating;
    @Expose
    private String Genre;
    @Expose
    private String Uploader;
    @Expose
    private String UploaderUID;
    @Expose
    private String Downloaded;
    @Expose
    private String TorrentSeeds;
    @Expose
    private String TorrentPeers;
    @Expose
    private String TorrentUrl;
    @Expose
    private String TorrentHash;
    @Expose
    private String TorrentMagnetUrl;

    /**
     * @return The MovieID
     */
    public String getMovieID() {
        return MovieID;
    }

    /**
     * @param MovieID The MovieID
     */
    public void setMovieID(String MovieID) {
        this.MovieID = MovieID;
    }

    /**
     * @return The State
     */
    public String getState() {
        return State;
    }

    /**
     * @param State The State
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     * @return The MovieUrl
     */
    public String getMovieUrl() {
        return MovieUrl;
    }

    /**
     * @param MovieUrl The MovieUrl
     */
    public void setMovieUrl(String MovieUrl) {
        this.MovieUrl = MovieUrl;
    }

    /**
     * @return The MovieTitle
     */
    public String getMovieTitle() {
        return MovieTitle;
    }

    /**
     * @param MovieTitle The MovieTitle
     */
    public void setMovieTitle(String MovieTitle) {
        this.MovieTitle = MovieTitle;
    }

    /**
     * @return The MovieTitleClean
     */
    public String getMovieTitleClean() {
        return MovieTitleClean;
    }

    /**
     * @param MovieTitleClean The MovieTitleClean
     */
    public void setMovieTitleClean(String MovieTitleClean) {
        this.MovieTitleClean = MovieTitleClean;
    }

    /**
     * @return The MovieYear
     */
    public String getMovieYear() {
        return MovieYear;
    }

    /**
     * @param MovieYear The MovieYear
     */
    public void setMovieYear(String MovieYear) {
        this.MovieYear = MovieYear;
    }

    /**
     * @return The AgeRating
     */
    public String getAgeRating() {
        return AgeRating;
    }

    /**
     * @param AgeRating The AgeRating
     */
    public void setAgeRating(String AgeRating) {
        this.AgeRating = AgeRating;
    }

    /**
     * @return The DateUploaded
     */
    public String getDateUploaded() {
        return DateUploaded;
    }

    /**
     * @param DateUploaded The DateUploaded
     */
    public void setDateUploaded(String DateUploaded) {
        this.DateUploaded = DateUploaded;
    }

    /**
     * @return The DateUploadedEpoch
     */
    public Integer getDateUploadedEpoch() {
        return DateUploadedEpoch;
    }

    /**
     * @param DateUploadedEpoch The DateUploadedEpoch
     */
    public void setDateUploadedEpoch(Integer DateUploadedEpoch) {
        this.DateUploadedEpoch = DateUploadedEpoch;
    }

    /**
     * @return The Quality
     */
    public String getQuality() {
        return Quality;
    }

    /**
     * @param Quality The Quality
     */
    public void setQuality(String Quality) {
        this.Quality = Quality;
    }

    /**
     * @return The CoverImage
     */
    public String getCoverImage() {
        return CoverImage;
    }

    /**
     * @param CoverImage The CoverImage
     */
    public void setCoverImage(String CoverImage) {
        this.CoverImage = CoverImage;
    }

    /**
     * @return The ImdbCode
     */
    public String getImdbCode() {
        return ImdbCode;
    }

    /**
     * @param ImdbCode The ImdbCode
     */
    public void setImdbCode(String ImdbCode) {
        this.ImdbCode = ImdbCode;
    }

    /**
     * @return The ImdbLink
     */
    public String getImdbLink() {
        return ImdbLink;
    }

    /**
     * @param ImdbLink The ImdbLink
     */
    public void setImdbLink(String ImdbLink) {
        this.ImdbLink = ImdbLink;
    }

    /**
     * @return The Size
     */
    public String getSize() {
        return Size;
    }

    /**
     * @param Size The Size
     */
    public void setSize(String Size) {
        this.Size = Size;
    }

    /**
     * @return The SizeByte
     */
    public String getSizeByte() {
        return SizeByte;
    }

    /**
     * @param SizeByte The SizeByte
     */
    public void setSizeByte(String SizeByte) {
        this.SizeByte = SizeByte;
    }

    /**
     * @return The MovieRating
     */
    public String getMovieRating() {
        return MovieRating;
    }

    /**
     * @param MovieRating The MovieRating
     */
    public void setMovieRating(String MovieRating) {
        this.MovieRating = MovieRating;
    }

    /**
     * @return The Genre
     */
    public String getGenre() {
        return Genre;
    }

    /**
     * @param Genre The Genre
     */
    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    /**
     * @return The Uploader
     */
    public String getUploader() {
        return Uploader;
    }

    /**
     * @param Uploader The Uploader
     */
    public void setUploader(String Uploader) {
        this.Uploader = Uploader;
    }

    /**
     * @return The UploaderUID
     */
    public String getUploaderUID() {
        return UploaderUID;
    }

    /**
     * @param UploaderUID The UploaderUID
     */
    public void setUploaderUID(String UploaderUID) {
        this.UploaderUID = UploaderUID;
    }

    /**
     * @return The Downloaded
     */
    public String getDownloaded() {
        return Downloaded;
    }

    /**
     * @param Downloaded The Downloaded
     */
    public void setDownloaded(String Downloaded) {
        this.Downloaded = Downloaded;
    }

    /**
     * @return The TorrentSeeds
     */
    public String getTorrentSeeds() {
        return TorrentSeeds;
    }

    /**
     * @param TorrentSeeds The TorrentSeeds
     */
    public void setTorrentSeeds(String TorrentSeeds) {
        this.TorrentSeeds = TorrentSeeds;
    }

    /**
     * @return The TorrentPeers
     */
    public String getTorrentPeers() {
        return TorrentPeers;
    }

    /**
     * @param TorrentPeers The TorrentPeers
     */
    public void setTorrentPeers(String TorrentPeers) {
        this.TorrentPeers = TorrentPeers;
    }

    /**
     * @return The TorrentUrl
     */
    public String getTorrentUrl() {
        return TorrentUrl;
    }

    /**
     * @param TorrentUrl The TorrentUrl
     */
    public void setTorrentUrl(String TorrentUrl) {
        this.TorrentUrl = TorrentUrl;
    }

    /**
     * @return The TorrentHash
     */
    public String getTorrentHash() {
        return TorrentHash;
    }

    /**
     * @param TorrentHash The TorrentHash
     */
    public void setTorrentHash(String TorrentHash) {
        this.TorrentHash = TorrentHash;
    }

    /**
     * @return The TorrentMagnetUrl
     */
    public String getTorrentMagnetUrl() {
        return TorrentMagnetUrl;
    }

    /**
     * @param TorrentMagnetUrl The TorrentMagnetUrl
     */
    public void setTorrentMagnetUrl(String TorrentMagnetUrl) {
        this.TorrentMagnetUrl = TorrentMagnetUrl;
    }
}