/*
 * Baby Central
 * Copyright (c) 2018.
 * Rafal Martinez-Marjanski
 */

package com.archangel_design.babycentral.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Persistence layer error.")
public class PersistenceLayerException extends RuntimeException {
    public PersistenceLayerException() {
        super();
    }
}
