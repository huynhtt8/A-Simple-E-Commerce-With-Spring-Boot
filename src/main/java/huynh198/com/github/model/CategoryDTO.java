package huynh198.com.github.model;

public class CategoryDTO {
    private int categoryId;

    private String categoryName;

    private String categoryDecription;

    public CategoryDTO(int categoryId, String categoryName, String categoryDecription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDecription = categoryDecription;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDecription() {
        return categoryDecription;
    }

    public void setCategoryDecription(String categoryDecription) {
        this.categoryDecription = categoryDecription;
    }
}
