package com.example.example.Complaints;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.example.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ComplainRegister extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private EditText editTextUsername, editTextTitle, editTextRoomNo, editTextDescription;
    private Spinner spinnerHostel, spinnerComplaintType;
    private CheckBox checkBoxIsPrivate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);

        databaseReference = FirebaseDatabase.getInstance().getReference("complaints");

        editTextUsername = findViewById(R.id.complain_username);
        editTextTitle = findViewById(R.id.complain_title);
        editTextRoomNo = findViewById(R.id.complain_house_no);
        editTextDescription = findViewById(R.id.et_complain_desc);
        spinnerHostel = findViewById(R.id.add_complaint_hostel);
        spinnerComplaintType = findViewById(R.id.add_complaint_type);
        checkBoxIsPrivate = findViewById(R.id.complain_is_private);

        Button buttonSubmit = findViewById(R.id.complain_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerComplaint();
            }
        });
    }

    private void registerComplaint() {
        String username = editTextUsername.getText().toString().trim();
        String title = editTextTitle.getText().toString().trim();
        String roomno = editTextRoomNo.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String hostel = spinnerHostel.getSelectedItem().toString();
        String complaintType = spinnerComplaintType.getSelectedItem().toString();
        boolean isPrivate = checkBoxIsPrivate.isChecked();
        String complainTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(title) && !TextUtils.isEmpty(roomno) && !TextUtils.isEmpty(description)) {
            String complaintId = databaseReference.push().getKey();
            ComplainItemClass complaint = new ComplainItemClass( username, title, roomno, hostel, complaintType, description, isPrivate, complainTime);
            databaseReference.child(complaintId).setValue(complaint);
            Toast.makeText(this, "Complaint registered successfully.", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Please fill in all the fields.", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        editTextUsername.setText("");
        editTextTitle.setText("");
        editTextRoomNo.setText("");
        editTextDescription.setText("");
        spinnerHostel.setSelection(0);
        spinnerComplaintType.setSelection(0);
        checkBoxIsPrivate.setChecked(false);
    }
}
