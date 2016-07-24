package com.rsantillanc.domain.model.response;

import com.rsantillanc.domain.model.ErrorModel;

/**
 * Created by Renzo D. Santillán Ch. on 23/07/2016.05:14 PM
 * http://rsantillanc.pe.hu/me/
 */
public abstract class SuperResponse {
    private ErrorModel error;

    public ErrorModel getError() {
        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }
}
