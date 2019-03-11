package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import java.util.ArrayList;

public abstract class MultiDataBufferRef extends zzd {
    protected final ArrayList<DataHolder> zzadC;

    protected MultiDataBufferRef(ArrayList<DataHolder> dataHolderCollection, int indexForRef, int dataRow) {
        super((DataHolder) dataHolderCollection.get(indexForRef), dataRow);
        this.zzadC = dataHolderCollection;
    }
}
