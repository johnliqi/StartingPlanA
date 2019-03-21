package com.liqi.wawwa.Presenter;

import com.liqi.wawwa.R;
import com.liqi.wawwa.View.MainView;

public class MainPresenterImpl implements MainPresenter {
    private MainView mMainView;

    public MainPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.nav_home:
                mMainView.switchHome();
                break;
            case R.id.nav_friends:
                mMainView.switchFriend();
                break;
            case R.id.nav_discussion:
                mMainView.switchDiscussion();
                break;
            case R.id.nav_messages:
                mMainView.switchMessage();
                break;
            case R.id.nv_main_navigation:
                break;
            case R.id.nav_setting:
                break;
            case R.id.nav_about:
                break;
        }
    }
}
