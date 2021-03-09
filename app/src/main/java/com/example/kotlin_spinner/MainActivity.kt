package com.example.kotlin_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = mutableListOf("aaa","bbb", "ccc")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        spinner.adapter = adapter

        var departmentList = mutableListOf<Departments>()
        for(i in 1..5) {
            departmentList.add(Departments(i, "department$i"))
        }

        val departmentAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, departmentList)
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = departmentAdapter
        spinner.onItemSelectedListener = this
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                Toast.makeText(this@MainActivity, "Selected: $position", Toast.LENGTH_SHORT).show()
//            }
//        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent) {
            spinner -> {
                Toast.makeText(this@MainActivity, "Selected: $position", Toast.LENGTH_SHORT).show()
            }
        }
    }
}