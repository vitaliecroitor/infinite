package md.vcroitor.licenta.server.persistence;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 10:27 AM
 */
public class PromotionInfo {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}