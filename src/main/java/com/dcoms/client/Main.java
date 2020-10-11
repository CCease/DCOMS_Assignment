package com.dcoms.client;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("src/main/java/com/dcoms/images/mcgLogo.png");
        System.out.println(f.exists());
    }
}
