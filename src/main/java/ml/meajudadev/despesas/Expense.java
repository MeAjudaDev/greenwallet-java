package ml.meajudadev.despesas;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Expense implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String description;
    private Double value;
    private Boolean isFixed;
    private String dueDate;
    private List<Integer> categoryIds;
    private int userId;

    public Expense() {
    }

    public Expense(int id, String description, Double value, Boolean isFixed, String dueDate, List<Integer> categoryIds, int userId) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.isFixed = isFixed;
        this.dueDate = dueDate;
        this.categoryIds = categoryIds;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getIsFixed() {
        return isFixed;
    }

    public void setIsFixed(Boolean isFixed) {
        this.isFixed = isFixed;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
