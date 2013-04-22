package md.vcroitor.licenta.common.dto;

import javax.validation.constraints.NotNull;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:50 AM
 */
public class Request<T> {

    public Request(){
    }

    public Request(T object){
        this.object = object;
    }

    @NotNull
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}