package com.example.toy.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

@DisplayName("특수한 케이스 테스트")
public class ApplicationTest {

    int[][] matrix;
    @Test
    public void test() {

        this.matrix = new int[6][6];  // 행렬 생성

        for(int i = 0; i < 6; i++){  // 행렬 초기화
            for(int j = 0; j < 6; j++){
                matrix[i][j] = i*6 + j + 1;
            }
        }

        System.out.println(this.matrix);
    }



}

