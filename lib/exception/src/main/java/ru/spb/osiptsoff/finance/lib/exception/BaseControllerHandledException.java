package ru.spb.osiptsoff.finance.lib.exception;

import lombok.experimental.StandardException;

/**
 * Наследники этого исключения будут отлавливаться специальным контроллером
 */
@StandardException
public class BaseControllerHandledException extends RuntimeException {
    
}
