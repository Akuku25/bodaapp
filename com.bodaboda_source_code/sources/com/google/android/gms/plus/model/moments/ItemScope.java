package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.zztr;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {
        private String mName;
        private String zzFA;
        private String zzZO;
        private double zzalQ;
        private double zzalR;
        private final Set<Integer> zzauX = new HashSet();
        private zztr zzauY;
        private List<String> zzauZ;
        private String zzavA;
        private zztr zzavB;
        private zztr zzavC;
        private zztr zzavD;
        private List<zztr> zzavE;
        private String zzavF;
        private String zzavG;
        private String zzavH;
        private String zzavI;
        private zztr zzavJ;
        private String zzavK;
        private String zzavL;
        private String zzavM;
        private zztr zzavN;
        private String zzavO;
        private String zzavP;
        private String zzavQ;
        private String zzavR;
        private zztr zzava;
        private String zzavb;
        private String zzavc;
        private String zzavd;
        private List<zztr> zzave;
        private int zzavf;
        private List<zztr> zzavg;
        private zztr zzavh;
        private List<zztr> zzavi;
        private String zzavj;
        private String zzavk;
        private zztr zzavl;
        private String zzavm;
        private String zzavn;
        private List<zztr> zzavo;
        private String zzavp;
        private String zzavq;
        private String zzavr;
        private String zzavs;
        private String zzavt;
        private String zzavu;
        private String zzavv;
        private String zzavw;
        private zztr zzavx;
        private String zzavy;
        private String zzavz;
        private String zzpn;
        private String zzxV;
        private String zzxX;

        public ItemScope build() {
            return new zztr(this.zzauX, this.zzauY, this.zzauZ, this.zzava, this.zzavb, this.zzavc, this.zzavd, this.zzave, this.zzavf, this.zzavg, this.zzavh, this.zzavi, this.zzavj, this.zzavk, this.zzavl, this.zzavm, this.zzavn, this.zzpn, this.zzavo, this.zzavp, this.zzavq, this.zzavr, this.zzZO, this.zzavs, this.zzavt, this.zzavu, this.zzavv, this.zzavw, this.zzavx, this.zzavy, this.zzavz, this.zzFA, this.zzavA, this.zzavB, this.zzalQ, this.zzavC, this.zzalR, this.mName, this.zzavD, this.zzavE, this.zzavF, this.zzavG, this.zzavH, this.zzavI, this.zzavJ, this.zzavK, this.zzavL, this.zzavM, this.zzavN, this.zzavO, this.zzavP, this.zzxV, this.zzxX, this.zzavQ, this.zzavR);
        }

        public Builder setAbout(ItemScope about) {
            this.zzauY = (zztr) about;
            this.zzauX.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.zzauZ = additionalName;
            this.zzauX.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.zzava = (zztr) address;
            this.zzauX.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.zzavb = addressCountry;
            this.zzauX.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.zzavc = addressLocality;
            this.zzauX.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.zzavd = addressRegion;
            this.zzauX.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.zzave = associated_media;
            this.zzauX.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.zzavf = attendeeCount;
            this.zzauX.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.zzavg = attendees;
            this.zzauX.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.zzavh = (zztr) audio;
            this.zzauX.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.zzavi = author;
            this.zzauX.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.zzavj = bestRating;
            this.zzauX.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.zzavk = birthDate;
            this.zzauX.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.zzavl = (zztr) byArtist;
            this.zzauX.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String caption) {
            this.zzavm = caption;
            this.zzauX.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.zzavn = contentSize;
            this.zzauX.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.zzpn = contentUrl;
            this.zzauX.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.zzavo = contributor;
            this.zzauX.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.zzavp = dateCreated;
            this.zzauX.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.zzavq = dateModified;
            this.zzauX.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.zzavr = datePublished;
            this.zzauX.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String description) {
            this.zzZO = description;
            this.zzauX.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String duration) {
            this.zzavs = duration;
            this.zzauX.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.zzavt = embedUrl;
            this.zzauX.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.zzavu = endDate;
            this.zzauX.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.zzavv = familyName;
            this.zzauX.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String gender) {
            this.zzavw = gender;
            this.zzauX.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.zzavx = (zztr) geo;
            this.zzauX.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.zzavy = givenName;
            this.zzauX.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String height) {
            this.zzavz = height;
            this.zzauX.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String id) {
            this.zzFA = id;
            this.zzauX.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String image) {
            this.zzavA = image;
            this.zzauX.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.zzavB = (zztr) inAlbum;
            this.zzauX.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.zzalQ = latitude;
            this.zzauX.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.zzavC = (zztr) location;
            this.zzauX.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.zzalR = longitude;
            this.zzauX.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.zzauX.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.zzavD = (zztr) partOfTVSeries;
            this.zzauX.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.zzavE = performers;
            this.zzauX.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.zzavF = playerType;
            this.zzauX.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.zzavG = postOfficeBoxNumber;
            this.zzauX.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.zzavH = postalCode;
            this.zzauX.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.zzavI = ratingValue;
            this.zzauX.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.zzavJ = (zztr) reviewRating;
            this.zzauX.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.zzavK = startDate;
            this.zzauX.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.zzavL = streetAddress;
            this.zzauX.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String text) {
            this.zzavM = text;
            this.zzauX.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.zzavN = (zztr) thumbnail;
            this.zzauX.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.zzavO = thumbnailUrl;
            this.zzauX.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.zzavP = tickerSymbol;
            this.zzauX.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String type) {
            this.zzxV = type;
            this.zzauX.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String url) {
            this.zzxX = url;
            this.zzauX.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String width) {
            this.zzavQ = width;
            this.zzauX.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.zzavR = worstRating;
            this.zzauX.add(Integer.valueOf(56));
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
