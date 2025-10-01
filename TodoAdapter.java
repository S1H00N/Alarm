package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button; // 추가
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private List<Todo> todoList = new ArrayList<>();
    // 1. 클릭 이벤트를 전달할 리스너 인터페이스 정의
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDeleteClick(Todo todo);
    }

    public TodoAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todoList.get(position);
        holder.textView.setText(todo.content);

        // 2. 삭제 버튼 클릭 시 리스너 호출
        holder.deleteButton.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteClick(todo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public void setItems(List<Todo> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        Button deleteButton; // 3. 삭제 버튼 변수 추가
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.todoTextView);
            deleteButton = itemView.findViewById(R.id.deleteButton); // 4. UI와 연결
        }
    }
}
