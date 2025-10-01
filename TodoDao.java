package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo") // "todo" 테이블의 모든 데이터를 조회
    List<Todo> getAll();

    @Insert // 데이터를 추가
    void insert(Todo todo);

    @Delete // 데이터를 삭제
    void delete(Todo todo);
}
