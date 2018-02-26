package ru.job4j.models;

/**
 * class Item.
 *
 * @author Dmitry Bondarev (mailto:tgenman@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    /** ID of Item. */
    private String id;
    /** Name of Item. */
    private String name;
    /** Description of Item. */
    private String desc;
    /** Time of creation of Item. */
    private long create;
    /** Comment to Item. */
    private String comment;

    /** Default constructor. */
    public Item() {
    }

    /** Constructor by name, description and time to create.
     * @param name String
     * @param description String
     * @param create long
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.desc = description;
        this.create = create;
    }

    /** Getter id.
     * @return String id */
    public String getId() {
        return this.id;
    }

    /** Getter name.
     * @return String name */
    public String getName() {
        return this.name;
    }

    /**
     * Getter description.
     * @return String
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Getter time of create.
     * @return long
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * Getter comment.
     * @return String
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Setter Id.
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setter Name.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter description.
     * @param desc String
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Setter time to create.
     * @param create long
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * Setter comment.
     * @param comment String
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
