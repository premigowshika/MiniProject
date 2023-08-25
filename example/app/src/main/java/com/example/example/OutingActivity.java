package com.example.example;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OutingActivity extends Activity {
    private TextView checkInTimeText;
    private TextView checkOutTimeText;
    private EditText nameEditText;
    private EditText departmentEditText;
    private EditText RoomNoEditText;
    private Button checkInButton;
    private Button checkOutButton;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_outing);

            checkInTimeText = findViewById(R.id.check_in_time_text);
            checkOutTimeText = findViewById(R.id.check_out_time_text);
            nameEditText = findViewById(R.id.name_edit_text);
            departmentEditText = findViewById(R.id.department_edit_text);
            RoomNoEditText=findViewById(R.id.Room_no_edit_text);
            checkInButton = findViewById(R.id.check_in_button);
            checkOutButton = findViewById(R.id.check_out_button);

            // Initialize Firebase Realtime Database reference
            databaseReference = FirebaseDatabase.getInstance().getReference("checkInOut");

            checkInButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleCheckIn();
                }
            });

            checkOutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleCheckOut();
                }
            });
        }

        private void handleCheckIn() {
            String name = nameEditText.getText().toString();
            String department = departmentEditText.getText().toString();
            String roomno = RoomNoEditText.getText().toString();
            String currentTime = getCurrentTime();

            String checkInId = databaseReference.push().getKey();
            CheckInOut checkIn = new CheckInOut(name, department,roomno,currentTime);
            databaseReference.child(checkInId).setValue(checkIn);

            checkInTimeText.setText("Check-In Time: " + currentTime);
        }
        private void handleCheckOut() {
            String currentTime = getCurrentTime();

            checkOutTimeText.setText("Check-Out Time: " + currentTime);

            // Update the check-out time in the last check-in record
            databaseReference.orderByKey().limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        String checkInId = childSnapshot.getKey();
                        databaseReference.child(checkInId).child("checkOutTime").setValue(currentTime);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle onCancelled event if needed
                }
            });
        }
        private String getCurrentTime() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            return sdf.format(new Date());
        }

        public class CheckInOut {
            private String name;
            private String department;
            private String roomno;
            private String checkInTime;
            private String checkOutTime;

            public CheckInOut() {
                // Default constructor required for Firebase Realtime Database
            }

            public CheckInOut(String name, String employeeId,String roomno, String checkInTime) {
                this.name = name;
                this.department = employeeId;
                this.roomno=roomno;
                this.checkInTime = checkInTime;
            }

            public String getName() {
                return name;
            }

            public String getDepartment() {
                return department;
            }

            public String getRoomno(){
                return roomno;
            }

            public String getCheckInTime() {
                return checkInTime;
            }

            public String getCheckOutTime() {
                return checkOutTime;
            }

            public void setCheckOutTime(String checkOutTime) {
                this.checkOutTime = checkOutTime;
            }
        }
}
