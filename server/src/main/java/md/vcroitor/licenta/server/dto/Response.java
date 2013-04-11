package md.vcroitor.licenta.server.dto;

import md.vcroitor.licenta.server.enums.ResponseStatus;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:50 AM
 */
public class Response<T> {

    public Response(ResponseStatus status){
        this.status = status;
    }

    public Response(T object) {
        this.object = object;
    }

    private ResponseStatus status;
    private T object;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
