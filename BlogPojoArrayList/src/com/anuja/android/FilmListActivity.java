package com.anuja.android;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class FilmListActivity extends Activity {
	
	// Declare UI components
	private ListView filmListView;
	private ListView starListView;

	private ArrayList<Film> filmArray; // Type safe with only Film objects
	private ArrayList<String> filmNamesArray;
	private ArrayList<String> starNamesArray;
	private ListAdapter filmListAdapter;
	private ListAdapter starListAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_list); // Load the film_list.xml file
        
        // Initialize UI components
        filmListView = (ListView) findViewById(R.id.filmListView);
        starListView = (ListView) findViewById(R.id.starListView);
   
        // Initialize an array to put film objects with film's all attributes which we have defined in Film.java
        filmArray = new ArrayList<Film>();
        
        // Initialize an array to put film names which we are going to show in the ListView
        filmNamesArray = new ArrayList<String>();
        
        // Initialize an array to put film names which we are going to show in the second ListView
        starNamesArray = new ArrayList<String>();
        
        // Plug the data set (filmNamesArray) to the adapter
        filmListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filmNamesArray);
        
        // Plug the adapter with the UI component (filmListView)
        filmListView.setAdapter(filmListAdapter);

        // Setting Film attributes
        for(int i=0 ; i<4 ; i++ ){
            // Initialize a Film object in order to set it's attributes.
        	// We have to create a Film object each time this loop traverse
            Film film = new Film();
            
            // // Here we set the film name and star name attribute for a film in one loop
        	film.setFilmName("Film name " + i);
        	film.setMainStar("Star name " + i);
        	
        	// Pass the Film object to the array of Film objects 
        	filmArray.add(film);
        	
        	// Add the film name to array of film names
        	filmNamesArray.add(film.getFilmName());
        	
        	// Add the star name to array of film names
        	starNamesArray.add(film.getMainStar());
        }
        
        // Plug the data set (starNamesArray) to the adapter
        starListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, starNamesArray);
        
        // Plug the adapter with the UI component (starListView)
        starListView.setAdapter(starListAdapter);
    }
}