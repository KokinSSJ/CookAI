package com.asugo.cookai;

import java.util.List;

public record Recipe(
        String title,
        int prepTimeMinutes,
        List<String> instructionSteps) {
}
