package com.song.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SongRepository {
	private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
    	return this.list;
    }

    public Song getSongById(Integer id) {
       for (Song song: list) {
    	   if (song.getId().equals(id)) {
    		   return song;
    	   }
       }
       return null;
    }

    public void addSong(Song s) {
    	this.list.add(s);
    }

    public void updateSong(Song s) {
    	Song song = getSongById(s.getId());
    	list.set(list.indexOf(song), s);
    }

    public void removeSong(Song s) {
    	list.remove(list.indexOf(s));
    }
}
