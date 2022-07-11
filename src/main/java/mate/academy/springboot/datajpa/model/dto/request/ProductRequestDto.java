package mate.academy.springboot.datajpa.model.dto.request;

public class ProductRequestDto {
    private String title;
    private Double price;
    private Long categoryId;

    public ProductRequestDto() {
    }

    public ProductRequestDto(String title, Double price, Long categoryId) {
        this.title = title;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProductRequestDto))
            return false;
        final ProductRequestDto other = (ProductRequestDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title))
            return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price))
            return false;
        final Object this$categoryId = this.getCategoryId();
        final Object other$categoryId = other.getCategoryId();
        if (this$categoryId == null ? other$categoryId != null : !this$categoryId.equals(other$categoryId))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProductRequestDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        final Object $categoryId = this.getCategoryId();
        result = result * PRIME + ($categoryId == null ? 43 : $categoryId.hashCode());
        return result;
    }

    public String toString() {
        return "ProductRequestDto(title=" + this.getTitle() + ", price=" + this.getPrice() + ", categoryId=" + this.getCategoryId() + ")";
    }
}
