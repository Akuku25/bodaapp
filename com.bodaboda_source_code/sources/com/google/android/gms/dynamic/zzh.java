package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

public final class zzh extends zza {
    private Fragment zzPt;

    private zzh(Fragment fragment) {
        this.zzPt = fragment;
    }

    public static zzh zza(Fragment fragment) {
        return fragment != null ? new zzh(fragment) : null;
    }

    public Bundle getArguments() {
        return this.zzPt.getArguments();
    }

    public int getId() {
        return this.zzPt.getId();
    }

    public boolean getRetainInstance() {
        return this.zzPt.getRetainInstance();
    }

    public String getTag() {
        return this.zzPt.getTag();
    }

    public int getTargetRequestCode() {
        return this.zzPt.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.zzPt.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzn(this.zzPt.getView());
    }

    public boolean isAdded() {
        return this.zzPt.isAdded();
    }

    public boolean isDetached() {
        return this.zzPt.isDetached();
    }

    public boolean isHidden() {
        return this.zzPt.isHidden();
    }

    public boolean isInLayout() {
        return this.zzPt.isInLayout();
    }

    public boolean isRemoving() {
        return this.zzPt.isRemoving();
    }

    public boolean isResumed() {
        return this.zzPt.isResumed();
    }

    public boolean isVisible() {
        return this.zzPt.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.zzPt.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.zzPt.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.zzPt.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.zzPt.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.zzPt.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.zzPt.startActivityForResult(intent, requestCode);
    }

    public void zzd(zzd zzd) {
        this.zzPt.registerForContextMenu((View) zze.zzf(zzd));
    }

    public void zze(zzd zzd) {
        this.zzPt.unregisterForContextMenu((View) zze.zzf(zzd));
    }

    public zzd zzlh() {
        return zze.zzn(this.zzPt.getActivity());
    }

    public zzc zzli() {
        return zza(this.zzPt.getParentFragment());
    }

    public zzd zzlj() {
        return zze.zzn(this.zzPt.getResources());
    }

    public zzc zzlk() {
        return zza(this.zzPt.getTargetFragment());
    }
}
