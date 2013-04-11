package md.vcroitor.licenta.server.persistence;

import md.vcroitor.licenta.server.enums.PromotionCategory;
import md.vcroitor.licenta.server.enums.PromotionStatus;

import java.util.Date;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 9:40 AM
 */
public class Promotion {

    protected long id;
    protected Date createdDate;
    protected Date expireDate;
    protected double oldPrice;
    protected double newPrice;
    protected PromotionStatus status;
    protected PromotionCategory category;
    protected Shop shop;
    protected PromotionInfo info;
}