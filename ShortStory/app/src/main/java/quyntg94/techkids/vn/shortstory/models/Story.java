package quyntg94.techkids.vn.shortstory.models;

import java.io.Serializable;

/**
 * Created by quyntg94 on 18/04/2017.
 */

public class Story implements Serializable{

    private int id;
    private String title;
    private String description;
    private String author;
    private String genre;
    private String image;
    private boolean isFavorite;
    private int lastChapterNo;

    public Story(int id, String title, String description, String author, String genre, String image, boolean isFavorite, int lastChapterNo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.genre = genre;
        this.image = image;
        this.isFavorite = isFavorite;
        this.lastChapterNo = lastChapterNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getLastChapterNo() {
        return lastChapterNo;
    }

    public void setLastChapterNo(int lastChapterNo) {
        this.lastChapterNo = lastChapterNo;
    }


    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", image='" + image + '\'' +
                ", isFavorite=" + isFavorite +
                ", lastChapterNo=" + lastChapterNo +
                '}';
    }
}
