package com.mpip.finki.mpip;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    EventAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context currentContext = getBaseContext();
        adapter = new EventAdapter(currentContext);
        setContentView(R.layout.activity_second);
        initButtons();
        enableBtn(false);
        initListViewer();
    }


    private void initListViewer() {
        ListView LV = (ListView) this.findViewById(R.id.listView);
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                removeEventFromLV(position);
            }
        });
        LV.setAdapter(adapter);
    }

    private void removeEventFromLV(int position) {
        adapter.removeEvent(position);
        adapter.notifyDataSetChanged();
    }

    private void initButtons() {
        Button btnBack = (Button) this.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backBtn();
            }
        });

        Button btnEnable = (Button) this.findViewById(R.id.btnEnable);
        btnEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableBtn(true);
            }
        });

        Button btnInsert = (Button) this.findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertBtn();
            }
        });
    }

    private void backBtn() {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    private void enableBtn(Boolean status) {
        EditText tmpText = (EditText) this.findViewById(R.id.editText);
        tmpText.setEnabled(status);
    }

    private void insertBtn() {
        EditText tmpText = (EditText) this.findViewById(R.id.editText);
        if (tmpText.getText().length() > 0) {
            Event newEvent = new Event(tmpText.getText().toString(), new Date());
            tmpText.setText("");
            tmpText.setEnabled(false);
            adapter.addEvent(newEvent);
            adapter.notifyDataSetChanged();
        } else {
            //TODO: show toaster validation failed;
        }
    }



    @Override
    public void onStart() {
        Toast.makeText(getApplication().getApplicationContext(), "Start Second Activity", Toast.LENGTH_SHORT).show();

        super.onStart();
    }

    @Override
    public void onRestart() {
        Toast.makeText(getApplication().getApplicationContext(), "Restart Second Activity", Toast.LENGTH_SHORT).show();

        super.onRestart();
    }

    @Override
    public void onStop() {
        Toast.makeText(getApplication().getApplicationContext(), "Stop Second Activity", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    public void onResume() {
        Toast.makeText(getApplication().getApplicationContext(), "Resume Second Activity", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    public void onPause() {
        Toast.makeText(getApplication().getApplicationContext(), "Pause Second Activity", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplication().getApplicationContext(), "Destroy Second Activity", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

//    public class EventAdapter extends BaseAdapter {
//
//        public List<Event> eventList;
//
//        public EventAdapter() {
//            eventList = new ArrayList<Event>();
//        }
//
//
//        public void addEvent(Event newEvent) {
//            eventList.add(newEvent);
//        }
//
//        public void removeEvent(int position) {
//            eventList.remove(position);
//        }
//
//        @Override
//        public int getCount() {
//            return eventList.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return eventList.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if (convertView == null) {
//                LayoutInflater inflater = (LayoutInflater) SecondActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                convertView = inflater.inflate(R.layout.listevent, parent, false);
//            }
//            Event event = eventList.get(position);
//
//            TextView eventName = (TextView) convertView.findViewById(R.id.txtEvent);
//            TextView eventDate = (TextView) convertView.findViewById(R.id.txtDate);
//
//            Event chapter = eventList.get(position);
//
//            eventName.setText(event.text);
//            eventDate.setText(chapter.dateCreated.toString());
//
//            return convertView;
//        }
//    }
}
