package com.artsystem.gmailapplocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ImageView;
import com.artsystem.gmailapplocal.data.FakeDataSource;
import com.artsystem.gmailapplocal.maillist.MailAdapter;
import com.artsystem.gmailapplocal.maillist.MailDiffUtilCallback;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mailRecyclerView;
    private MailAdapter mailAdapter;
    private ExtendedFloatingActionButton extFab;
    private ImageView iconDL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
    }

    private void initViews() {
        extFab = findViewById(R.id.extFab100);
        iconDL = findViewById(R.id.menu_icon);
        mailRecyclerView = findViewById(R.id.rvmail);
        mailAdapter = new MailAdapter(new MailDiffUtilCallback());
        mailRecyclerView.setHasFixedSize(true);
        mailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mailRecyclerView.setAdapter(mailAdapter);
        mailAdapter.submitList(FakeDataSource.getListMail());
    }


}