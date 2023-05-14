package it.school.com.medical_system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotEditableException extends Exception {
    private String message;
    private String name;

    public NotEditableException(String message) {
        this.message = message;
    }

}
