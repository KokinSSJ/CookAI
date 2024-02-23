package com.asugo.cookai;

import java.util.List;

public record CookAssistantRequest(
        List<Ingredient> ingredients,
        String diet,
        String mealType) {
    static String promptString = """
                Na podstawie dostępnych składników: {skladniki},
                oraz z uwzględnieniem diety: {dieta}
                i preferowanego typu posiłku: {posilek},
                daj mi przepis kulinarny, który spełnia te kryteria.
                Nie musisz wykorzystywać wszystkich składników.
                Ponumeruj po kolei wszystkie etapy przygotowania posiłku.
                Odpowiedz po Polsku.
                Zwróć to w formacie: {format}
                """;
}

record Ingredient(
        String name,
        double weight) {
}

