package com.example.lifegreenproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DictionaryActivity extends AppCompatActivity {
    private EditText searchEditText;
    private ImageView garbageImageView;
    private TextView garbageTypeTextView, recyclableTextView, recycleMethodTextView;
    private ImageButton btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        // Ánh xạ các view
        searchEditText = findViewById(R.id.searchEditText);
        garbageImageView = findViewById(R.id.garbageImageView);
        garbageTypeTextView = findViewById(R.id.garbageTypeTextView);
        recyclableTextView = findViewById(R.id.recyclableTextView);
        recycleMethodTextView = findViewById(R.id.recycleMethodTextView);
        btnClear = findViewById(R.id.btnClear);

        // Ẩn nút xóa ban đầu
        btnClear.setVisibility(View.GONE);

        // Xử lý logic tìm kiếm khi nhập từ khóa
        searchEditText.setOnEditorActionListener((v, actionId, event) -> {
            String keyword = searchEditText.getText().toString().trim();
            if (!keyword.isEmpty()) {
                // Giả sử bạn có hàm để tìm kiếm thông tin loại rác từ từ khóa
                searchGarbage(keyword);
            }
            return false;
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    btnClear.setVisibility(View.VISIBLE);
                } else {
                    btnClear.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        btnClear.setOnClickListener(v -> {
            searchEditText.setText("");
        });

        // Xử lý nút quay lại
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }

    private void searchGarbage(String keyword) {
        // Ví dụ logic xử lý tìm kiếm (giả lập)
        if (keyword.equalsIgnoreCase("glass")) {
            garbageImageView.setImageResource(R.drawable.glasstrah); // Đặt hình ảnh tương ứng
            garbageTypeTextView.setText("Garbage Type: Glass");
            recyclableTextView.setText("Recyclable: Yes");
            recycleMethodTextView.setText("Recycle Method: Clean and sort before disposing.");
        } else if (keyword.equalsIgnoreCase("plastic")) {
            garbageImageView.setImageResource(R.drawable.plastic);
            garbageTypeTextView.setText("Garbage Type: Plastic");
            recyclableTextView.setText("Recyclable: Partially");
            recycleMethodTextView.setText("Recycle Method: Separate into recyclable and non-recyclable plastics.");
        } else {
            garbageImageView.setImageResource(R.drawable.carton); // Hình ảnh mặc định
            garbageTypeTextView.setText("Garbage Type: Unknown");
            recyclableTextView.setText("Recyclable: Unknown");
            recycleMethodTextView.setText("Recycle Method: Unknown");
        }
    }
}
