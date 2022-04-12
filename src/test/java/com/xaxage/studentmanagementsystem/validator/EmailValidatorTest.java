package com.xaxage.studentmanagementsystem.validator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailValidatorTest {

    private final EmailValidator emailValidator = new EmailValidator();

    @Test
    public void validateEmail() {
        assertThat(emailValidator.test("xaxage@gmail.com")).isTrue();
        assertThat(emailValidator.test("xaxage@g2@mail.com")).isFalse();
    }
}