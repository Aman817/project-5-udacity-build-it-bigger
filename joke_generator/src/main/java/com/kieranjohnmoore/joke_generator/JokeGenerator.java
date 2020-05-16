package com.kieranjohnmoore.joke_generator;

import java.util.concurrent.ThreadLocalRandom;

public class JokeGenerator {
    private final String[] jokes = new String[] {
        "What’s Whitney Houston’s favourite type of coordination? HAAAAND EEEEEEEEEYYYYEEE!",
        "What’s better than Ted Danson? Ted singing and Danson!",
        "What did the the drummer call his twin daughters? Anna one, Anna two!",
        "I bought some shoes from a drug dealer. I don’t know what he laced them with, but I was tripping all day!",
        "What does a nosey pepper do? It gets jalapeño business!",
        "Why did the golfer change his pants? Because he got a hole in one!",
        "Does anyone need an ark? I Noah guy!",
        "How do you make holy water? You boil the hell out of it.",
        "I bought a ceiling fan the other day. Complete waste of money. He just stands there applauding and saying 'Ooh, I love how smooth it is.'",
    };


    public String getJoke() {
        return jokes[ThreadLocalRandom.current().nextInt(0, jokes.length)];
    }
}
