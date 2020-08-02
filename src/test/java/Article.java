public class Article {
    private String imageUrl;
    private String title;
    private int commentCount;

    public Article(String imageUrl, String title, int commentCount) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.commentCount = commentCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getFullInfo() {
        return title + ": " + commentCount;
    }
}
