package md.vcroitor.licenta.server.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:50 AM
 */
public class Request<T> {

    @NotNull
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
