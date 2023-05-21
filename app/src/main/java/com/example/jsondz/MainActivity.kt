package com.example.jsondz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    private val btn: Button by lazy { findViewById(R.id.button) }
    private val tvJsonOrDataClass: TextView by lazy { findViewById(R.id.tvJsonOrDataClass) }
    private val tvTitle: TextView by lazy { findViewById(R.id.tvTitle) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = "{\n" +
                "\"id\": \"6212577f0095c22f40b1a78a\",\n" +
                "\"email\": \"fields_tyson@manglo.degree\",\n" +
                "\"roles\": [\n" +
                "\"owner\",\n" +
                "\"guest\"\n" +
                "],\n" +
                "\"apiKey\": \"f767f1e7-63e2-4f7b-984d-1f4743e7dfd1\",\n" +
                "\"profile\": {\n" +
                "\"dob\": \"1989-02-17\",\n" +
                "\"name\": \"Fields Tyson\",\n" +
                "\"about\": \"Quis labore commodo culpa aliquip cillum deserunt culpa non pariatur minim ullamco reprehenderit nulla esse. Ullamco aliquip do commodo cillum.\",\n" +
                "\"address\": \"59 Menahan Street, Loretto, Washington\",\n" +
                "\"company\": \"Manglo\",\n" +
                "\"location\": {\n" +
                "\"lat\": 56.740646,\n" +
                "\"long\": -60.715809\n" +
                "}\n" +
                "},\n" +
                "\"username\": \"fields89\",\n" +
                "\"createdAt\": \"2013-12-09T14:53:16.548Z\",\n" +
                "\"updatedAt\": \"2013-12-10T14:53:16.548Z\"\n" +
                "}"

        val gson = Gson()
        val model = gson.fromJson(response, Model::class.java)
        val json = gson.toJson(model)

        btn.setOnClickListener {
            if (btn.text == getString(R.string.json_to_data_class)) {
                tvJsonOrDataClass.text = model.toString()
                btn.text = getString(R.string.data_class_to_json)
                tvTitle.text = getString(R.string.title_data_class)
            } else {
                tvJsonOrDataClass.text = json
                btn.text = getString(R.string.json_to_data_class)
                tvTitle.text = getString(R.string.title_json)
            }
        }
    }
}