package com.dcoms.client;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("src/main/resources/images/Salad.png");
        System.out.println(f.exists());
    }
}
