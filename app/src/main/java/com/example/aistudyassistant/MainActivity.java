package com.example.aistudyassistant;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private EditText editText;
    private Button button;
    private ProgressBar progressBar;
    private ScrollView scrollView;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("🤖 AI Study Assistant");

        linearLayout = findViewById(R.id.linearLayout);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        scrollView = findViewById(R.id.scrollView);

        addMessage("Hello! I'm your AI Study Assistant 📚\n\nAsk me anything!", false);

        button.setOnClickListener(v -> sendMessage());
    }

    private void sendMessage() {
        String userMessage = editText.getText().toString().trim();

        if (TextUtils.isEmpty(userMessage)) {
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show();
            return;
        }

        addMessage(userMessage, true);
        editText.setText("");

        progressBar.setVisibility(View.VISIBLE);
        button.setEnabled(false);

        // Simulate response (remove this and add API call later)
        handler.postDelayed(() -> {
            progressBar.setVisibility(View.GONE);
            button.setEnabled(true);

            String response = getSimpleResponse(userMessage);
            addMessage(response, false);
        }, 1500);
    }

    private String getSimpleResponse(String question) {
        String q = question.toLowerCase();

        if (q.contains("study tip") || q.contains("study advice")) {
            return "📚 **3 Study Tips:**\n\n1. Active Recall - Test yourself\n2. Spaced Repetition - Review over time\n3. Pomodoro - 25 min study, 5 min break";
        }
        if (q.contains("math")) {
            return "🧮 Practice math daily and understand the 'why' behind formulas!";
        }
        if (q.contains("program") || q.contains("coding")) {
            return "💻 Code every day, build small projects, and debug line by line!";
        }
        if (q.contains("exam") || q.contains("test")) {
            return "📝 Start early, take practice exams, and get good sleep before the test!";
        }

        return "I'm your AI Study Assistant! 📚\n\nAsk me for:\n• Study tips\n• Math help\n• Programming advice\n• Exam preparation";
    }

    private void addMessage(String message, boolean isUser) {
        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setPadding(30, 20, 30, 20);
        textView.setTextSize(16);

        if (isUser) {
            textView.setBackgroundColor(0xFF6200EE);
            textView.setTextColor(0xFFFFFFFF);
            textView.setGravity(android.view.Gravity.END);
        } else {
            textView.setBackgroundColor(0xFFE0E0E0);
            textView.setTextColor(0xFF000000);
            textView.setGravity(android.view.Gravity.START);
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 10, 0, 10);
        textView.setLayoutParams(params);

        linearLayout.addView(textView);
        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }
}