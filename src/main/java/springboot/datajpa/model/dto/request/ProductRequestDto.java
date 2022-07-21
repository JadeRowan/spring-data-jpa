package springboot.datajpa.model.dto.request;

import java.util.Objects;

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
        if (o == this) {
            return true;
        }
        if (!(o instanceof ProductRequestDto)) {
            return false;
        }
        final ProductRequestDto other = (ProductRequestDto) o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (!Objects.equals(this$title, other$title)) {
            return false;
        }
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (!Objects.equals(this$price, other$price)) {
            return false;
        }
        final Object this$categoryId = this.getCategoryId();
        final Object other$categoryId = other.getCategoryId();
        if (!Objects.equals(this$categoryId, other$categoryId)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProductRequestDto;
    }

    public int hashCode() {
        final int prime = 59;
        int result = 1;
        final Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        final Object $price = this.getPrice();
        result = result * prime + ($price == null ? 43 : $price.hashCode());
        final Object $categoryId = this.getCategoryId();
        result = result * prime + ($categoryId == null ? 43 : $categoryId.hashCode());
        return result;
    }

    public String toString() {
        return "ProductRequestDto(title="
                + this.getTitle()
                + ", price=" + this.getPrice()
                + ", categoryId=" + this.getCategoryId() + ")";
    }
}
