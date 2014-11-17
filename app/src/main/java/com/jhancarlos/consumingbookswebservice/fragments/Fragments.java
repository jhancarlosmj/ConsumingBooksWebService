package com.jhancarlos.consumingbookswebservice.fragments;

import android.support.v4.app.Fragment;

public enum Fragments {

    ONE(FragmentOne.class), TWO(FragmentTwo.class), THREE(FragmentThree.class);

    final Class<? extends Fragment> fragment;

    private Fragments(Class<? extends Fragment> fragment) {
        this.fragment = fragment;
    }

    public String getFragment() {
        return fragment.getName();
    }
}
