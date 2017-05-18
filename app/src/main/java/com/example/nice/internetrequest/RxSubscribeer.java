package com.example.nice.internetrequest;

import android.content.Context;

import com.example.nice.internetrequest.widget.LoadingDialog;

import rx.Subscriber;

/**
 * Created by walter on 2017/5/17.
 */

public abstract class RxSubscribeer<T> extends Subscriber<T> {
    private LoadingDialog mDialog;

    public RxSubscribeer(Context context) {
        mDialog  = new LoadingDialog(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mDialog!=null){
            mDialog.show();
        }
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    /**
     * 隐藏dialog
     */
    private void dismissProgressDialog() {
        if(mDialog!=null){
            if(mDialog.isShowing()){
                mDialog.dismiss();
            }
        }
    }


    @Override
    public void onError(Throwable e) {
        _onError(e.toString());
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);
}
