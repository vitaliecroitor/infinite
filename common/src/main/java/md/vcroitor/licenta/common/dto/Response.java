package md.vcroitor.licenta.common.dto;

import md.vcroitor.licenta.common.enums.ErrorEnum;
import md.vcroitor.licenta.common.enums.ResponseStatusEnum;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:50 AM
 */
public class Response<T> {

    private ResponseStatusEnum status;
    private T object;
    private ErrorEnum error;

    public Response(ResponseStatusEnum status){
        this.status = status;
    }

    public Response(T object) {
        this.object = object;
    }

    public Response(ErrorEnum errorEnum){
        this.error = errorEnum;
    }

    public ResponseStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ResponseStatusEnum status) {
        this.status = status;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public ErrorEnum getError() {
        return error;
    }

    public void setError(ErrorEnum error) {
        this.error = error;
    }
}
