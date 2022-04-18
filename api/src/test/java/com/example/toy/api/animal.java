package com.example.toy.api;



public abstract class animal {

    String name;
    int leg;

    Character test;


    public animal() {;
    }

    public void walk() { //일반 메소드는 필수가아니야 , 추상메소드만 필수로 선언해줘야해 상속받은 곳에서
        System.out.println("test");
    }


    abstract void play();

    abstract void stop();


}