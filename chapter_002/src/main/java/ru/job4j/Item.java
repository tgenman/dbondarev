package ru.job4j;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long create;
    private String comment;

    public Item() {
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.desc = description;
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getCreate() {
        return this.create;
    }

    public String getComment() {
        return this.comment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
