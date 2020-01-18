package com.android.example.roomwordssample.di.module;


import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import com.android.example.roomwordssample.dao.WordDao;
import com.android.example.roomwordssample.database.WordRoomDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    /*
     * The method returns the Database object
     * */
    @Provides
    @Singleton
   WordRoomDatabase provideDatabase(@NonNull Application application) {
        return Room.databaseBuilder(application,
                WordRoomDatabase.class, "Entertainment.db")
                .allowMainThreadQueries().build();
    }


    /*
     * We need the MovieDao module.
     * For this, We need the AppDatabase object
     * So we will define the providers for this here in this module.
     * */

    @Provides
    @Singleton
    WordDao provideMovieDao(@NonNull WordRoomDatabase appDatabase) {
        return appDatabase.wordDao();
    }
}