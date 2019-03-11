package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new C01411();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzajI;
    private final byte[] zzajJ;
    private final int zzajK;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage$1 */
    static class C01411 implements Creator<RealTimeMessage> {
        C01411() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdg(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzeX(x0);
        }

        public RealTimeMessage zzdg(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] zzeX(int i) {
            return new RealTimeMessage[i];
        }
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.zzajI = (String) zzx.zzl(senderParticipantId);
        this.zzajJ = (byte[]) ((byte[]) zzx.zzl(messageData)).clone();
        this.zzajK = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzajJ;
    }

    public String getSenderParticipantId() {
        return this.zzajI;
    }

    public boolean isReliable() {
        return this.zzajK == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.zzajI);
        parcel.writeByteArray(this.zzajJ);
        parcel.writeInt(this.zzajK);
    }
}
