package com.mahull.zeus.domain.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CurrencyUtils {

    public static final int SCALE = 4;
    public static final int SIZE = 16;
    private static final BigDecimal BD100 = new BigDecimal(100);
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    public static final MathContext MC = new MathContext(SCALE, ROUNDING_MODE);
    public static final BigDecimal ZERO = new BigDecimal(0, MC);
    public static final String DECIMAL_FORMAT = "0.##";
}
