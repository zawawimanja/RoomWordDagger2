package com.android.example.roomwordssample.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;


import com.android.example.roomwordssample.di.ViewModelKey;
import com.android.example.roomwordssample.factory.ViewModelFactory;
import com.android.example.roomwordssample.viewmodel.WordViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);


    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  MovieListViewModel.class as key,
     * and a Provider that will build a MovieListViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(WordViewModel.class)
    protected abstract ViewModel movieListViewModel(WordViewModel moviesListViewModel);
}