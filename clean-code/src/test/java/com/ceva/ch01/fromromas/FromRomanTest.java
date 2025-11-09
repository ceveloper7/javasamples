package com.ceva.ch01.fromromas;

import com.ceva.ch01.exceptions.InvalidRomanNumeralException;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static com.ceva.ch01.fromromans.FromRoman.convert;

public class FromRomanTest {
    @Test
    public void valid() throws Exception {
        assertThat(convert(""), is(0));
        assertThat(convert("I"), is(1));
        assertThat(convert("II"), is(2));
        assertThat(convert("III"), is(3));
        assertThat(convert("IV"), is(4));
        assertThat(convert("V"), is(5));
        assertThat(convert("VI"), is(6));
        assertThat(convert("VII"), is(7));
        assertThat(convert("VIII"), is(8));
        assertThat(convert("IX"), is(9));
        assertThat(convert("X"), is(10));
        assertThat(convert("XI"), is(11));
        assertThat(convert("XII"), is(12));
        assertThat(convert("CXC"), is(190));
    }

    @Test
    public void invalid() throws Exception {
        assertInvalid("IIII");
        assertInvalid("VV");
        assertInvalid("XXXX");
        assertInvalid("LL");
        assertInvalid("CCCC");
        assertInvalid("DD");
        assertInvalid("MMMM");
        assertInvalid("IIV");
        assertInvalid("IVI");
        assertInvalid("IXI");
        assertInvalid("VIV");
        assertInvalid("XVX");
        assertInvalid("XIIII");
        assertInvalid("XVV");
        assertInvalid("XIVI");
        assertInvalid("XIXI");
        assertInvalid("XVIV");
        assertInvalid("LXL");
        assertInvalid("XLX");
        assertInvalid("XCX");
        assertInvalid("CDC");
        assertInvalid("DCD");
        assertInvalid("MCMC");
        assertInvalid("MCDM");
    }

    private void assertInvalid(String r) {
        assertThrows(InvalidRomanNumeralException.class, () -> convert(r));
    }
}
