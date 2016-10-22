package com.mpip.finki.mpip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mpip.finki.mpip.Event;
import com.mpip.finki.mpip.R;
import com.mpip.finki.mpip.SecondActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class EventAdapter extends BaseAdapter {

    public List<Event> eventList;
    public Context mainContext;
    public EventAdapter(Context context) {
        mainContext = context;
        eventList = new ArrayList<Event>();
    }


    public void addEvent(Event newEvent) {
        eventList.add(newEvent);
    }

    public void removeEvent(int position) {
        eventList.remove(position);
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mainContext).inflate(R.layout.listevent, parent, false);
        }
        Event event = eventList.get(position);

        TextView eventName = (TextView) convertView.findViewById(R.id.txtEvent);
        TextView eventDate = (TextView) convertView.findViewById(R.id.txtDate);

        Event chapter = eventList.get(position);

        eventName.setText(event.text);
        eventDate.setText(chapter.dateCreated.toString());

        return convertView;
    }
}