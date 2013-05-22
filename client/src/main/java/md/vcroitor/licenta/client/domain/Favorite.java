package md.vcroitor.licenta.client.domain;

import md.vcroitor.licenta.common.enums.ItemType;

/**
 * User: vcroitor
 * Date: 5/22/13
 * Time: 8:54 PM
 */
public class Favorite {

    private ItemType type;
    private String id;
    private String name;
    private String uri;

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
