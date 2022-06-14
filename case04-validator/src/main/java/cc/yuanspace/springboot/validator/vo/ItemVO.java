package cc.yuanspace.springboot.validator.vo;

import lombok.Data;

import java.util.List;

@Data
public class ItemVO {

    private Long itemId;

    private String itemName;

    private List<String> items;


    public void valid() {
        if (itemId == null) {
            throw new IllegalArgumentException("参数缺失");
        }
        if (itemName == null) {
            throw new IllegalArgumentException("参数缺失");
        }
        if (items == null || items.size() == 0) {
            throw new IllegalArgumentException("参数缺失");
        }
    }
}
