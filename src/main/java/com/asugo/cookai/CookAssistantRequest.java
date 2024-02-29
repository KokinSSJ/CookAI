package com.asugo.cookai;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CookAssistantRequest(
        List<Ingredient> ingredients,
        @NotBlank String diet,
        String mealType) {

}

record Ingredient(
        String name,
        double weight) {
}

