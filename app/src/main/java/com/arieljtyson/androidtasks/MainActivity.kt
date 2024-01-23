package com.arieljtyson.androidtasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.addTodoBtn
import kotlinx.android.synthetic.main.activity_main.deleteTodoBtn
import kotlinx.android.synthetic.main.activity_main.etTodoTitle
import kotlinx.android.synthetic.main.activity_main.rvTodoItems

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        addTodoBtn.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        deleteTodoBtn.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}