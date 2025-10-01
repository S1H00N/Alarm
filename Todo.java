package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 데이터베이스의 'todo' 테이블과 1:1로 매칭되는 데이터 클래스입니다.
 */
@Entity
public class Todo {

    /**
     * 각 할 일 항목을 구분하는 고유한 ID 값입니다.
     * (autoGenerate = true)는 새로운 할 일이 추가될 때마다 ID를 1씩 자동으로 증가시킵니다.
     */
    @PrimaryKey(autoGenerate = true)
    public int id;

    /**
     * 할 일의 실제 내용을 저장하는 필드입니다.
     */
    public String content;
}
